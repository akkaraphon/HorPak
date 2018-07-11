package com.example.amin.horpak;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.SubmitCallbackListener;
import com.example.amin.horpak.API.SumitnotiCallbackListener;
import com.example.amin.horpak.Model.SubmiModel;
import com.example.amin.horpak.Model.SubmitNotiModel;
import com.example.amin.horpak.Utils.StaticClass;

import retrofit.Retrofit;


public class AgrementActivity extends AppCompatActivity {
    TextView fname, lname, rentel, dip, address, room, floor, startdate, payday, fur, enddate, txt3;
    LinearLayout dateout, txt1;
    Button mRent, mPayan, mUpID, mSubmit;
    String TAG = "AgrementActivity";
    ConnectionManager connect = new ConnectionManager();
    SumitnotiCallbackListener sumitnotiCallbackListener = new SumitnotiCallbackListener() {
        @Override
        public void onResponse(SubmitNotiModel submitNotiModel, Retrofit retrofit) {
            finish();
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };
    SubmitCallbackListener submitCallbackListener = new SubmitCallbackListener() {
        @Override
        public void onResponse(SubmiModel submiModel, Retrofit retrofit) {
            Log.d(TAG, "onResponse: ");
            if (submiModel.getImg_signature_renter().equals("")) {
                StaticClass.toast(getApplicationContext(), "กรุณาเซ็นสัญญา");
            }
            if (submiModel.getImg_signature_witness().equals("") && StaticClass.TYPE_ROOM.equals("รายเดือน")) {
                StaticClass.toast(getApplicationContext(), "กรุณาเให้พยานซ็นสัญญา");
            }
            if (submiModel.getImg_card().equals("")) {
                StaticClass.toast(getApplicationContext(), "กรุณาอัพโหลดบัตรประชาชน");
            }
            if (!submiModel.getImg_card().equals("")
                    && !submiModel.getImg_signature_renter().equals("")
                    && !submiModel.getImg_signature_witness().equals("")) {
                Log.d(TAG, "onResponse: " + submiModel.getID_Rentel());
                connect.submitNoti(sumitnotiCallbackListener, submiModel.getID_Rentel());
            }
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrement);
        dateout = (LinearLayout) findViewById(R.id.dateout);
        fname = (TextView) findViewById(R.id.name);
        lname = (TextView) findViewById(R.id.lastname);
        rentel = (TextView) findViewById(R.id.rentel);
        dip = (TextView) findViewById(R.id.dip);
        address = (TextView) findViewById(R.id.address);
        room = (TextView) findViewById(R.id.room);
        floor = (TextView) findViewById(R.id.floor);
        startdate = (TextView) findViewById(R.id.startdate);
        payday = (TextView) findViewById(R.id.payday);
        fur = (TextView) findViewById(R.id.fur);
        enddate = (TextView) findViewById(R.id.enddate);
        txt1 = (LinearLayout) findViewById(R.id.txt1);
        txt3 = (TextView) findViewById(R.id.txt3);
        mRent = (Button) findViewById(R.id.btnRent);
        mPayan = (Button) findViewById(R.id.btnPayan);
        mUpID = (Button) findViewById(R.id.btnUpID);
        mSubmit = (Button) findViewById(R.id.btnSubmit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fname.setText(StaticClass.agrement.getAgm().getName_Mem());
        lname.setText(StaticClass.agrement.getAgm().getLname_Mem());
        rentel.setText(StaticClass.agrement.getAgm().getPrice());
        dip.setText(StaticClass.agrement.getAgm().getDeposit());
        address.setText(StaticClass.agrement.getAgm().getAddress());
        room.setText(StaticClass.agrement.getAgm().getNo_Room());
        floor.setText(StaticClass.agrement.getAgm().getFloor());
        startdate.setText(StaticClass.agrement.getAgm().getDate_checkin());
        payday.setText(StaticClass.agrement.getAgm().getDate_rentel());
        if (StaticClass.agrement.getFur().getStatus_fur().equals("1")) {
            for (int i = 0; i < StaticClass.agrement.getFur().getDetail().size(); i++) {
                fur.setText(i + ". " + StaticClass.agrement.getFur().getDetail().get(i).getName_fur()
                        + " จำนวน "
                        + StaticClass.agrement.getFur().getDetail().get(i).getAmount() + "\n");
            }
        } else {
            fur.setText("ไม่มีเฟอร์นิเจอร์");
        }
        if (StaticClass.TYPE_ROOM.equals("รายวัน")) {
            mPayan.setVisibility(View.INVISIBLE);
            dateout.setVisibility(View.VISIBLE);
            enddate.setText(StaticClass.agrement.getAgm().getDate_checkout1());
            txt3.setText("ค่าเช่าวันละ");
            txt1.setVisibility(View.GONE);
        }

        mRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgrementActivity.this, SignatureActivity.class);
                intent.putExtra("name", "mRent");
                intent.putExtra("IDRentel", StaticClass.agrement.getAgm().getID_Rentel());
                startActivity(intent);
            }
        });
        mPayan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgrementActivity.this, SignatureActivity.class);
                intent.putExtra("name", "mPayan");
                intent.putExtra("IDRentel", StaticClass.agrement.getAgm().getID_Rentel());
                startActivity(intent);
            }
        });
        mUpID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgrementActivity.this, UpidActivity.class));
            }
        });
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect.checkSubmit(submitCallbackListener, StaticClass.agrement.getAgm().getID_Rentel());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
