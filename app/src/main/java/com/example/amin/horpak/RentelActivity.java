package com.example.amin.horpak;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.RentCallbackListener;
import com.example.amin.horpak.Model.RentModel;
import com.example.amin.horpak.Utils.StaticClass;

import java.util.Calendar;

import retrofit.Retrofit;

public class RentelActivity extends AppCompatActivity {

    TextView mRoom, mPrice, mDeposit;
    CalendarView mCalendar;
    Button mSubmit;
    String mIdRoom;
    int mPosition;
    String datein;
    String TAG = "MoveOutActivity";
    Calendar calendar = Calendar.getInstance();
    String mYear = String.valueOf(calendar.get(Calendar.YEAR));
    String mMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
    String mDayOfMonth = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    String idMem = StaticClass.loginModel.getID_mem();
    ConnectionManager connect;
    RentCallbackListener rentCallbackListener = new RentCallbackListener() {
        @Override
        public void onResponse(RentModel rentModel, Retrofit retrofit) {
            Log.d(TAG, "onResponse: " + rentModel.getStatusID());
            StaticClass.toast(getApplicationContext(), "จองสำเร็จ");
//            finish();
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t.getMessage());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentel);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        mIdRoom = bundle.getString("idRoom");
        mPosition = bundle.getInt("position");

        mRoom = (TextView) findViewById(R.id.txtRoomNo);
        mPrice = (TextView) findViewById(R.id.txtPrice);
        mDeposit = (TextView) findViewById(R.id.txtDeposit);

        mSubmit = (Button) findViewById(R.id.btnRentel);

        mCalendar = (CalendarView) findViewById(R.id.calRent);

        mRoom.setText(StaticClass.roomModel.getDetail().get(mPosition).getNo_Room());
        mPrice.setText("ค่าห้องเดือนละ " + StaticClass.roomModel.getDetail().get(mPosition).getPrice() + " บาท");
        mDeposit.setText("ค่ามัดจำ " + StaticClass.roomModel.getDetail().get(mPosition).getDeposit() + " บาท");

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long start = calendar.getTimeInMillis();
        mCalendar.setMinDate(start);
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if (dayOfMonth < 10) {
                    mDayOfMonth = "0" + String.valueOf(dayOfMonth);
                } else {
                    mDayOfMonth = String.valueOf(dayOfMonth);
                }

                mYear = String.valueOf(year);

                if (month + 1 < 10) {
                    mMonth = "0" + String.valueOf(month + 1);
                } else {
                    mMonth = String.valueOf(month + 1);
                }

                datein = mYear + "-" + mMonth + "-" + mDayOfMonth;
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + datein);
                Log.d(TAG, "onClick: " + idMem);
                Log.d(TAG, "onClick: " + mIdRoom);
                connect.getRentel(rentCallbackListener, idMem, mIdRoom, datein);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
