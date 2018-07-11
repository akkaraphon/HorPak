package com.example.amin.horpak.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amin.horpak.API.AgrementCallbackListener;
import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.NotiCallbackListener;
import com.example.amin.horpak.Adapter.*;
import com.example.amin.horpak.AgrementActivity;
import com.example.amin.horpak.Model.AgrementModel;
import com.example.amin.horpak.Model.NotiModel;
import com.example.amin.horpak.R;
import com.example.amin.horpak.Utils.StaticClass;
import com.google.firebase.iid.FirebaseInstanceId;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotiFragment extends Fragment {
    String TAG = "Noti";
    RecyclerView mRecyclerView;
    NotiAdapter adapter;
    GridLayoutManager gridLayoutManager;
    List<NotiModel> notiModels = new ArrayList<>();
    NotiModel item = new NotiModel();
    ConnectionManager connect = new ConnectionManager();
    AgrementCallbackListener callback;
    String token;
    SwipeRefreshLayout swipeRefreshLayout;
    View v;
    NotiCallbackListener notiCallbackListener = new NotiCallbackListener() {
        @Override
        public void onResponse(NotiModel notiModel, Retrofit retrofit) {
            StaticClass.notiModel = notiModel;
            Log.d(TAG, "onResponse: notiModel");
//            StaticClass.toast(getApplicationContext(),"ready");
            setAdapterNoti(StaticClass.notiModel);
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: notiModel" + t);
        }
    };

    public NotiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_noti, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, "onCreate: " + token);
                connect.postNoti(notiCallbackListener, token);
            }
        });


        callback = new AgrementCallbackListener() {
            @Override
            public void onResponse(AgrementModel agrement, Retrofit retrofit) {
                StaticClass.agrement = agrement;
                StaticClass.toast(getContext(), agrement.getAgm().getStatus_rentel() + " ห้อง " + agrement.getAgm().getNo_Room());
                Intent intent = new Intent(getContext(), AgrementActivity.class);
//                intent.putExtra("id_rentel", "devahoy");
                startActivity(intent);
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }

            @Override
            public void onBodyError(ResponseBody responseBody) {
                Log.d(TAG, "onBodyError: ");
            }

            @Override
            public void onBodyErrorIsNull() {
                Log.d(TAG, "onBodyErrorIsNull: ");
            }
        };

        setAdapterNoti(StaticClass.notiModel);

        return v;

    }   

    public void setAdapterNoti(NotiModel notiModel){
        notiModels.add(notiModel);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.Re1);

        adapter = new NotiAdapter(getContext(), notiModel.getDetail(), new NotiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(List<NotiModel.DetailBean> noti, int position) {
                StaticClass.TYPE_ROOM = noti.get(position).getRental_type();
                Log.d(TAG, "onItemClick: " + noti.get(position).getID_rentel() + " " + noti.get(position).getID_Room());
                connect.postAgrement(callback, noti.get(position).getID_rentel(), noti.get(position).getID_Room());
            }
        });
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }

}
