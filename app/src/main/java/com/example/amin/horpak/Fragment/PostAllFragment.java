package com.example.amin.horpak.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.PostCallbackListener;
import com.example.amin.horpak.Adapter.PostAdapter;
import com.example.amin.horpak.Adapter.RoomAdapter;
import com.example.amin.horpak.HistoryActivity;
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
public class PostAllFragment extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    View v;
    RecyclerView mRecyclerView;
    PostAdapter adapter;
    GridLayoutManager gridLayoutManager;
    String namePost,numpost;
    String TAG = "PostAllFragment";
    ConnectionManager connect = new ConnectionManager();
    PostCallbackListener postCallbackListener = new PostCallbackListener() {
        @Override
        public void onResponse(PostModel postModel, Retrofit retrofit) {
            StaticClass.postModelAll = postModel;
            setListMyPost();
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t.getMessage());
        }
    };
    PostCallbackListener postCallbackListener2 = new PostCallbackListener() {
        @Override
        public void onResponse(PostModel postModel, Retrofit retrofit) {
            StaticClass.toast(getContext(), namePost);
            Intent intent = new Intent(getContext(), PostViewActivity.class);
            intent.putExtra("numPost", numpost);
            startActivity(intent);
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    public PostAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_post_all, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                connect.getPost(postCallbackListener, "0");
            }
        });
        setListMyPost();

        // Inflate the layout for this fragment
        return v;
    }

    public void setListMyPost() {
        mRecyclerView = (RecyclerView) v.findViewById(R.id.RePostAll);
        adapter = new PostAdapter(getContext(), StaticClass.postModelAll.getDetail(), new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final List<PostModel.DetailBean> topic, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("ต้องการขอรับพัสดุห้องนี้ใช่ไหม");
                builder.setPositiveButton("รับ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        namePost = topic.get(position).getName_post();
                        numpost = topic.get(position).getNum_post();

                        connect.setPost(postCallbackListener2, StaticClass.loginModel.getID_mem(), topic.get(position).getID_post());
                    }
                });
                builder.setNegativeButton("ไม่รับ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }

}
