package com.example.amin.horpak;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.MoveoutCallbackListener;
import com.example.amin.horpak.Model.MoveoutModel;
import com.example.amin.horpak.Utils.StaticClass;

import java.util.Calendar;

import retrofit.Retrofit;

public class MoveOutActivity extends AppCompatActivity {

    CalendarView mCalendar;
    Button mSubmit;
    String TAG = "MoveOutActivity";
    Calendar calendar = Calendar.getInstance();
    String mYear = String.valueOf(calendar.get(Calendar.YEAR));
    String mMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
    String mDayOfMonth = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    TextView mMsg;
    ConnectionManager connect = new ConnectionManager();
    MoveoutCallbackListener moveoutCallbackListener = new MoveoutCallbackListener() {
        @Override
        public void onResponse(MoveoutModel moveoutModel, Retrofit retrofit) {
            Log.d(TAG, "onResponse: Success" );
            AlertDialog.Builder builder = new AlertDialog.Builder(MoveOutActivity.this);
            builder.setMessage("Reserve Success");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    StaticClass.MOVE = 1;
                    finish();
                }
            });
            builder.show();
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mCalendar = (CalendarView) findViewById(R.id.calendarView);
        mSubmit = (Button) findViewById(R.id.btn_submit);
        mMsg = (TextView) findViewById(R.id.txt_msg);

        calendar.add(Calendar.MONTH, 1);
        long start = calendar.getTimeInMillis();
        calendar.add(Calendar.MONTH, 3);
        long end = calendar.getTimeInMillis();
        mCalendar.setMinDate(start);
        mCalendar.setMaxDate(end);
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
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mYear + "-" + mMonth + "-" + mDayOfMonth);
                String dateout = mYear + "-" + mMonth + "-" + mDayOfMonth;
                connect.postMoveout(moveoutCallbackListener,StaticClass.profileModel.getNo_Room(),dateout);
            }
        });

        mMsg.setText("คุณต้องการย้ายออกจากห้อง " + StaticClass.profileModel.getNo_Room() + " วันที่");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
