package com.example.amin.horpak;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.LoginCallbackListener;
import com.example.amin.horpak.Model.LoginModel;
import com.example.amin.horpak.Utils.StaticClass;
import com.google.firebase.iid.FirebaseInstanceId;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public class
LoginActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    ConnectionManager connect = new ConnectionManager();
    EditText mUsername, mPassword;
    LoginCallbackListener loginCallbackListener;
    Button mLogin;
    int status;
    String TAG = "JUMP";
    String token;

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mUsername = (EditText) findViewById(R.id.txtUser);
        mPassword = (EditText) findViewById(R.id.txtPass);
        mLogin = (Button) findViewById(R.id.btnLogin);
        mPrefs = getSharedPreferences("prefs_user", Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();

        String a = mPrefs.getString("user", null);
        String b = mPrefs.getString("password", null);

        loginCallbackListener = new LoginCallbackListener() {

            @Override
            public void onResponse(LoginModel loginModel, Retrofit retrofit) {
                status = Integer.valueOf(loginModel.getStatusID());
                StaticClass.loginModel = loginModel;
                Log.d(TAG, "onResponse: " + status);

                progressDialog.dismiss();

                if (status != 0) {
                    onLoginSucced();
                } else {
                    onLoginFailed();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                progressDialog.dismiss();
                StaticClass.toast(getApplicationContext(), "ข้อมูลผิดพลาด");

                Log.d(TAG, "onFailure: " + t.toString());
            }

            @Override
            public void onBodyError(ResponseBody responseBody) {
                progressDialog.dismiss();
                StaticClass.toast(getApplicationContext(), "ข้อมูลผิดพลาด");
                Log.d(TAG, "onBodyError: " + responseBody.toString());
            }

            @Override
            public void onBodyErrorIsNull() {
                progressDialog.dismiss();
                StaticClass.toast(getApplicationContext(), "ข้อมูลผิดพลาด");
                Log.d(TAG, "onBodyErrorIsNull: ");
            }
        };
        if (a != null && b != null) {
            token = FirebaseInstanceId.getInstance().getToken();
            Log.d(TAG,"Token : " + token);

            progressDialog = ProgressDialog.show(this, "Please wait", "Loading...", true, false);
            connect.postLogin(loginCallbackListener, a, b, token);
        }
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");
        if (!validate()) {
            onLoginFailed();
            return;
        }
        progressDialog = ProgressDialog.show(this, "Please wait", "Loading...", true, false);

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Token : " + token);

        connect.postLogin(loginCallbackListener, username, password, token);
    }

    public boolean validate() {
        boolean valid = true;

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();
        mEditor.putString("user", username);
        mEditor.putString("password", password);
        mEditor.commit();
        if (username.isEmpty()) {
            mUsername.setError("please fill username");
            valid = false;
        } else {
            mUsername.setError(null);
        }
        if (password.isEmpty()) {
            mPassword.setError("please fill password");
            valid = false;
        } else {
            mPassword.setError(null);
        }
        return valid;
    }

    private void onLoginSucced() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void onLoginFailed() {
        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
    }
}
