package com.example.amin.horpak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.amin.horpak.Adapter.RoomAdapter;
import com.example.amin.horpak.Model.RoomModel;
import com.example.amin.horpak.Utils.StaticClass;

import java.util.ArrayList;
import java.util.List;

public class CheckOutListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RoomAdapter adapter;
    GridLayoutManager gridLayoutManager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.reRoomOut);
        adapter = new RoomAdapter(getApplicationContext(), StaticClass.roomModelActive.getDetail(), new RoomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(List<RoomModel.DetailBean> topic, int position) {
                StaticClass.toast(getApplicationContext(),topic.get(position).getID_Room());
                intent = new Intent(CheckOutListActivity.this, CheckoutActivity.class);
//                intent.putExtra("room", topic.get(position).getNo_Room());
                intent.putExtra("td", topic.get(position).getID_Room());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(CheckOutListActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }
}
