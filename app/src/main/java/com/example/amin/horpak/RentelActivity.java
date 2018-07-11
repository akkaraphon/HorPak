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
import com.example.amin.horpak.Utils.StaticClass;

import java.util.Calendar;

public class RentelActivity extends AppCompatActivity {

    TextView mRoom, mPrice, mDeposit;
    CalendarView mCalendar;
    Button mSubmit;
    String mIdRoom;
    int mPosition;
    String TAG = "MoveOutActivity";
    Calendar calendar = Calendar.getInstance();
    String mYear = String.valueOf(calendar.get(Calendar.YEAR));
    String mMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
    String mDayOfMonth = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    ConnectionManager connect;


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

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datein = mYear + "-" + mMonth + "-" + mDayOfMonth;
                Log.d(TAG, "onClick: " + datein);
            }
        });

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long start = calendar.getTimeInMillis();
        mCalendar.setMinDate(start);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
