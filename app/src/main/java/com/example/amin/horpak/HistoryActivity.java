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

public class HistoryActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RoomAdapter adapter;
    GridLayoutManager gridLayoutManager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mRecyclerView = (RecyclerView) findViewById(R.id.ReHistory);
        adapter = new RoomAdapter(getApplicationContext(), StaticClass.roomModelMy.getDetail(), new RoomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(List<RoomModel.DetailBean> topic, int position) {
                StaticClass.toast(getApplicationContext(),topic.get(position).getNo_Room());
                intent = new Intent(HistoryActivity.this, HistoryViewActivity.class);
                intent.putExtra("roomNo", topic.get(position).getNo_Room());
                intent.putExtra("idBook", topic.get(position).getID_book());
                intent.putExtra("status_book", topic.get(position).getStatus_book());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(HistoryActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }
}
