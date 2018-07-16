package com.example.amin.horpak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.DepositCallbackListener;
import com.example.amin.horpak.Model.DepositModel;

import retrofit.Retrofit;

public class CheckoutActivity extends AppCompatActivity {
    String idRoom;
    EditText mDeposit;
    Button mSubmit;
    TextView mShowSum;
    ConnectionManager connect = new ConnectionManager();
    String TAG = "CheckoutActivity";
    DepositCallbackListener depositCallbackListener = new DepositCallbackListener() {
        @Override
        public void onResponse(DepositModel depositModel, Retrofit retrofit) {
            Log.d(TAG, "onResponse: DepositModel");
            mShowSum.setVisibility(View.VISIBLE);
            int Dif = Integer.parseInt(depositModel.getDeposit_m()) - Integer.parseInt(mDeposit.getText().toString());
            if (Dif > 0) {
                mShowSum.setText("เงินคืน " + Dif);
            } else {
                mShowSum.setText("เพื่มเงิน " + Dif);
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t.getMessage());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Bundle bundle = getIntent().getExtras();
        idRoom = bundle.getString("td");
        Log.d(TAG, "onCreate: " + idRoom);

        mDeposit = (EditText) findViewById(R.id.edtDe);
        mSubmit = (Button) findViewById(R.id.btnSubmitDe);
        mShowSum = (TextView) findViewById(R.id.txtSum);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + idRoom + mDeposit.getText().toString());
                connect.getDeposit(depositCallbackListener, idRoom, mDeposit.getText().toString());
            }
        });
    }
}
