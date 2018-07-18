package com.example.amin.horpak.Adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.amin.horpak.R;
import com.example.amin.horpak.Utils.StaticClass;

public class MoreAdapter extends BaseAdapter {
    private Context mContext;
    private int mStatus;

    public MoreAdapter(Context context, int Status_eva) {
        mContext = context;
        mStatus = Status_eva;
    }

    @Override
    public int getCount() {
        if (StaticClass.loginModel.getStatus().equals("ผู้เช่ารายเดือน")) {
            return 5;
        }else if (StaticClass.loginModel.getStatus().equals("สมาชิก")) {
            return 3;
        } else {
            return 4;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView == null) {
            textView = new TextView(mContext);
            textView.setLayoutParams(new GridView.LayoutParams(250, 250));
            textView.setPadding(4, 4, 4, 4);
        } else {
            textView = (TextView) convertView;
        }
        if (StaticClass.loginModel.getStatus().equals("ผู้เช่ารายเดือน")) {
            switch (position) {
                case 0:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_moveroom, 0, 0);
                    textView.setText("จองห้องพักรายวัน");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_build, 0, 0);
                    textView.setText("ประวัติการซ่อม");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_upload, 0, 0);
                    textView.setText("อัพโหลดหลักฐาน");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_mail, 0, 0);
                    textView.setText("พัสดุ");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 4:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_moveroom, 0, 0);
                    textView.setText("ย้ายห้อง");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 5:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_moveout, 0, 0);
                    textView.setText("ย้ายออก");
                    textView.setGravity(Gravity.CENTER);
                    break;
            }
        } else if (StaticClass.loginModel.getStatus().equals("สมาชิก")) {
            switch (position) {
                case 0:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_moveroom, 0, 0);
                    textView.setText("จองห้องพักรายวัน");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_moveroom, 0, 0);
                    textView.setText("จองห้องพักรายเดือน");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_upload, 0, 0);
                    textView.setText("ประวัติการจอง");
                    textView.setGravity(Gravity.CENTER);
                    break;
            }
        } else {
            switch (position) {

                case 0:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_meter, 0, 0);
                    textView.setText("จดมิเตอร์ไฟ");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_meterwater, 0, 0);
                    textView.setText("จดมิเตอร์น้ำ");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_moveout, 0, 0);
                    textView.setText("ตรวจห้อง");
                    textView.setGravity(Gravity.CENTER);
                    break;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_personnew, 0, 0);
                    textView.setText("เพิ่มรายเซ็น");
                    textView.setGravity(Gravity.CENTER);
                    break;
            }
        }
        return textView;
    }
}
