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

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.PostCallbackListener;
import com.example.amin.horpak.Adapter.PostAdapter;
import com.example.amin.horpak.HistoryViewActivity;
import com.example.amin.horpak.Model.PostModel;
import com.example.amin.horpak.PostViewActivity;
import com.example.amin.horpak.R;
import com.example.amin.horpak.Utils.StaticClass;

import java.util.List;

import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostMyFragment extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    View v;
    RecyclerView mRecyclerView;
    PostAdapter adapter;
    GridLayoutManager gridLayoutManager;
    String TAG = "PostAllFragment";
    ConnectionManager connect = new ConnectionManager();
    PostCallbackListener postCallbackListener = new PostCallbackListener() {
        @Override
        public void onResponse(PostModel postModel, Retrofit retrofit) {
            Log.d(TAG, "onResponse: " + postModel.getStatusID());
            StaticClass.postModel = postModel;
            setListMyPost();
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t.getMessage());
        }
    };

    public PostMyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_post_my, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                connect.getPost(postCallbackListener, StaticClass.loginModel.getID_mem());
            }
        });
        setListMyPost();

        // Inflate the layout for this fragment
        return v;
    }

    public void setListMyPost(){
        mRecyclerView = (RecyclerView) v.findViewById(R.id.RePostMy);
        adapter = new PostAdapter(getContext(), StaticClass.postModel.getDetail(), new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(List<PostModel.DetailBean> topic, int position) {
                StaticClass.toast(getContext(),topic.get(position).getName_post());
                Intent intent = new Intent(getContext(), PostViewActivity.class);
                intent.putExtra("numPost", topic.get(position).getNum_post());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }

}
