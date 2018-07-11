package com.example.amin.horpak.Fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.LogoutCallbackListener;
import com.example.amin.horpak.Adapter.MoreAdapter;
import com.example.amin.horpak.CheckOutListActivity;
import com.example.amin.horpak.Model.LogoutModel;
import com.example.amin.horpak.MoveOutActivity;
import com.example.amin.horpak.PowerActivity;
import com.example.amin.horpak.R;
import com.example.amin.horpak.RentRoomActivity;
import com.example.amin.horpak.Utils.StaticClass;
import com.example.amin.horpak.UpidActivity;
import com.example.amin.horpak.WaterActivity;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    Intent intent;
    Button mLogout;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    ConnectionManager connect = new ConnectionManager();
    String token = FirebaseInstanceId.getInstance().getToken();
    String TAG = "MoreF";
    LogoutCallbackListener logoutCallbackListener = new LogoutCallbackListener() {

        @Override
        public void onResponse(LogoutModel notiModel, Retrofit retrofit) {
            editor.clear();
            editor.commit();
            getActivity().finish();
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_more, container, false);

        mLogout = (Button) v.findViewById(R.id.logout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getActivity().getSharedPreferences("prefs_user", Context.MODE_PRIVATE);
                editor = sp.edit();
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("ออกจากระบบ");
                dialog.setCancelable(true);
                dialog.setMessage("คุณต้องการออกจากระบบใช่หรือไม่");
                dialog.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        connect.getLogout(logoutCallbackListener, token);
                    }
                });

                dialog.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });

        GridView gridview = (GridView) v.findViewById(R.id.gridview);
        gridview.setAdapter(new MoreAdapter(getContext(), 1));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (StaticClass.loginModel.getStatus().equals("ผู้เช่ารายเดือน")) {
                    switch (position) {
                        case 0:
                            Toast.makeText(getActivity(), "ประวัติการซ่อม", Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(), UpidActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Toast.makeText(getActivity(), "อัพโหลดหลักฐาน", Toast.LENGTH_SHORT).show();
//                            intent = new Intent(getActivity(), MoveActivity.class);
//                            startActivity(intent);
                            break;
                        case 2:
                            Toast.makeText(getActivity(), "พัสดุ", Toast.LENGTH_SHORT).show();
//                            intent = new Intent(getActivity(), ViewProfileActivity.class);
//                            startActivity(intent);
                            break;
                        case 3:
                            Toast.makeText(getActivity(), "ย้ายห้อง", Toast.LENGTH_SHORT).show();
//                            intent = new Intent(getActivity(), ViewProfileActivity.class);
//                            startActivity(intent);
                            break;
                        case 4:
                            Toast.makeText(getActivity(), "ย้ายออก", Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(), MoveOutActivity.class);
                            startActivity(intent);
                            break;
                    }
                } else if (StaticClass.loginModel.getStatus().equals("สมาชิก")) {
                    switch (position) {
                        case 0:
                            Toast.makeText(getActivity(), "จองห้องพักรายวัน", Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(), RentRoomActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Toast.makeText(getActivity(), "จองห้องพักรายเดือน", Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(), RentRoomActivity.class);
                            startActivity(intent);
                            break;
                        case 2:
                            Toast.makeText(getActivity(), "ประวัติการจอง", Toast.LENGTH_SHORT).show();
//                            intent = new Intent(getActivity(), UpidActivity.class);
//                            startActivity(intent);
                            break;
                    }
                } else {
                    switch (position) {
                        case 0:
                            Toast.makeText(getActivity(), "จดมิเตอร์น้ำ", Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(), PowerActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Toast.makeText(getActivity(), "จดมิเตอร์น้ำ", Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(), WaterActivity.class);
                            startActivity(intent);
                            break;
                        case 2:
                            Toast.makeText(getActivity(), "ตรวจห้อง", Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(), CheckOutListActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            }
        });


        return v;
    }

}
