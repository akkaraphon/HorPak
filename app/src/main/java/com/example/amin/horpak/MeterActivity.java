package com.example.amin.horpak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.WPCallbackListener;
import com.example.amin.horpak.Model.WPModel;
import com.example.amin.horpak.Utils.StaticClass;

import retrofit.Retrofit;

public class MeterActivity extends AppCompatActivity {

    String room, id, type, unit;
    TextView mRoom;
    LinearLayout waterLayout, powerLayout;
    EditText mWater, mPower;
    Button mSubmit;
    WPCallbackListener wpCallbackListener;
    ConnectionManager connect = new ConnectionManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter);
        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");
        room = bundle.getString("room");
        id = bundle.getString("id");

        wpCallbackListener = new WPCallbackListener() {
            @Override
            public void onResponse(WPModel wpModel, Retrofit retrofit) {
                StaticClass.toast(getApplicationContext(),"บันทึกสำเร็จ");
                finish();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        };

        waterLayout = (LinearLayout) findViewById(R.id.waterLayout);
        powerLayout = (LinearLayout) findViewById(R.id.powerLayout);
        mWater = (EditText) findViewById(R.id.txtWater);
        mPower = (EditText) findViewById(R.id.txtPower);
        mSubmit = (Button) findViewById(R.id.btnSubmit);

        mRoom = (TextView) findViewById(R.id.Room);
        mRoom.setText("ห้อง " + room);
        if (type.equals("water")) {
            powerLayout.setVisibility(View.INVISIBLE);
            waterLayout.setVisibility(View.VISIBLE);
        } else {
            waterLayout.setVisibility(View.INVISIBLE);
            powerLayout.setVisibility(View.VISIBLE);
        }

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("water")) {
                    unit = mWater.getText().toString();
                } else {
                    unit = mPower.getText().toString();
                }
                connect.setWP(wpCallbackListener, type, unit, id);
            }
        });
    }
}
