package com.example.amin.horpak;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.Toast;

import com.example.amin.horpak.API.ConnectUpload;
import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.UploadService;
import com.example.amin.horpak.Model.UpPicModel;
import com.github.gcacace.signaturepad.views.SignaturePad;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignatureActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private SignaturePad mSignaturePad;
    private Button mClearButton;
    private Button mSaveButton;
    EditText mName,mLname;
    File svgFile;

    String mIDRentel;
    String detail;
    String TAG = "Signature :";
    String img_path = "";
    String name;
    ProgressDialog progressDialog;
    ConnectionManager connectionManager = new ConnectionManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        Bundle bundle = getIntent().getExtras();
        if (Build.VERSION.SDK_INT > 22) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        name = bundle.getString("name");
        mIDRentel = bundle.getString("IDRentel");
        mName = (EditText) findViewById(R.id.Fname);
        mLname = (EditText) findViewById(R.id.Lname);

        if(name.equals("mRent")){
            mName.setVisibility(View.INVISIBLE);
            mLname.setVisibility(View.INVISIBLE);
        }

        mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
                Toast.makeText(SignatureActivity.this, "OnStartSigning", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSigned() {
                mSaveButton.setEnabled(true);
                mClearButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                mSaveButton.setEnabled(false);
                mClearButton.setEnabled(false);
            }
        });

        mClearButton = (Button) findViewById(R.id.clear_button);
        mSaveButton = (Button) findViewById(R.id.save_button);

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSignaturePad.clear();
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (addSvgSignatureToGallery(mSignaturePad.getSignatureSvg())) {
                    Toast.makeText(SignatureActivity.this, "SVG Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
                    uploadFile();
                    finish();
                } else {
                    Toast.makeText(SignatureActivity.this, "Unable to store the SVG signature", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length <= 0
                        || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(SignatureActivity.this, "Cannot write images to external storage", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("SignaturePad", "Directory not created");
        }
        return file;
    }

    private void scanMediaFile(File photo) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(photo);
        mediaScanIntent.setData(contentUri);
        SignatureActivity.this.sendBroadcast(mediaScanIntent);
    }

    public boolean addSvgSignatureToGallery(String signatureSvg) {
        boolean result = false;
        try {
            svgFile = new File(getAlbumStorageDir("SignaturePad"),
                    String.format("Signature_%d.svg", System.currentTimeMillis()));
            OutputStream stream = new FileOutputStream(svgFile);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(signatureSvg);
            writer.close();
            stream.flush();
            stream.close();
            scanMediaFile(svgFile);
            result = true;
        } catch (IOException e) {
            Log.d(TAG, "addSvgSignatureToGallery: " + e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Checks if the app has permission to write to device storage
     * <p/>
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity the activity from which permissions are checked
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


    // Uploading Image/Video
    private void uploadFile() {
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/svg+xml"), svgFile);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", svgFile.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), svgFile.getName());

//        String mIdRentel;
//        String mFname,mSname;
        RequestBody mIdRentel = RequestBody.create(MediaType.parse("text/plain"), mIDRentel);
        RequestBody mFname,mSname;
        if(name.equals("mRent")){
            mFname = RequestBody.create(MediaType.parse("text/plain"),"-1");
            mSname = RequestBody.create(MediaType.parse("text/plain"), "-1");
        }else{
            mFname = RequestBody.create(MediaType.parse("text/plain"), mName.getText().toString());
            mSname = RequestBody.create(MediaType.parse("text/plain"), mLname.getText().toString());
        }

        UploadService getResponse = ConnectUpload.getClient().create(UploadService.class);
        Call<UpPicModel> call = getResponse.uploadFile(fileToUpload, filename,mIdRentel,mFname,mSname);
        call.enqueue(new Callback<UpPicModel>() {
            @Override
            public void onResponse(Call<UpPicModel> call, Response<UpPicModel> response) {
                Log.d(TAG, "onResponse: " + response.toString());
                UpPicModel serverResponse = response.body();
                if (serverResponse != null) {
                    if (serverResponse.isSuccess()) {
                        Log.d(TAG, "onResponse : "+serverResponse.getMessage());
                    } else {

                    }
                } else {
                    assert serverResponse != null;
                }
            }

            @Override
            public void onFailure(Call<UpPicModel> call, Throwable t) {

            }
        });
    }
}
