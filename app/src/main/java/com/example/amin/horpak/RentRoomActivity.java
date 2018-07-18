package com.example.amin.horpak;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.RoomCallbackListener;
import com.example.amin.horpak.Adapter.RoomAdapter;
import com.example.amin.horpak.Model.RoomModel;
import com.example.amin.horpak.Utils.StaticClass;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;

public class RentRoomActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RoomAdapter adapter;
    GridLayoutManager gridLayoutManager;
    List<String> list = new ArrayList<>();
    Intent intent;
    String TAG = "RentRoomActivity";
    SwipeRefreshLayout swipeRefreshLayout;ConnectionManager connect = new ConnectionManager();
    RoomCallbackListener roomCallbackListener = new RoomCallbackListener() {
        @Override
        public void onResponse(final RoomModel roomModel, Retrofit retrofit) {
            Log.d(TAG, "onResponse: swipeRefreshLayout ");
            mRecyclerView = (RecyclerView) findViewById(R.id.ReRent);
            adapter = new RoomAdapter(getApplicationContext(),roomModel.getDetail(), new RoomAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(List<RoomModel.DetailBean> topic, int position) {
                    StaticClass.RoomRentModel = roomModel;
                    intent = new Intent(RentRoomActivity.this, RentelActivity.class);
                    startActivity(intent);
                    StaticClass.toast(getApplicationContext(),roomModel.getDetail().get(position).getID_Room());
                }
            });
            mRecyclerView.setAdapter(adapter);
            gridLayoutManager = new GridLayoutManager(RentRoomActivity.this,1);
            mRecyclerView.setLayoutManager(gridLayoutManager);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return 1;
                }
            });
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t);
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_room);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                connect.getRoom(roomCallbackListener,"blank");
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.ReRent);
        adapter = new RoomAdapter(getApplicationContext(),StaticClass.roomModel.getDetail(), new RoomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(List<RoomModel.DetailBean> topic, int position) {
                intent = new Intent(RentRoomActivity.this, RentelActivity.class);
                intent.putExtra("idRoom", topic.get(position).getID_Room());
                intent.putExtra("position", position);
                startActivity(intent);
                finish();
            }
        });
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(RentRoomActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
