package com.example.amin.horpak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.amin.horpak.Adapter.RoomAdapter;
import com.example.amin.horpak.Model.RoomModel;

import java.util.ArrayList;
import java.util.List;

public class WaterActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RoomAdapter adapter;
    GridLayoutManager gridLayoutManager;
    List<String> list = new ArrayList<>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
//        for (int i=0;i<10;i++){
//            list.add("test");
//        }

        mRecyclerView = (RecyclerView) findViewById(R.id.ReWater);
        adapter = new RoomAdapter(getApplicationContext(),StaticClass.roomModel.getDetail(), new RoomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(List<RoomModel.DetailBean> topic, int position) {
                StaticClass.toast(getApplicationContext(),topic.get(position).getNo_Room());
                intent = new Intent(WaterActivity.this, MeterActivity.class);
                intent.putExtra("type", "water");
                intent.putExtra("room", topic.get(position).getNo_Room());
                intent.putExtra("td", topic.get(position).getID_Room());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(WaterActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }
}
