package com.example.amin.horpak.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amin.horpak.Model.PostModel;
import com.example.amin.horpak.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MenuViewHolder> {

    Context context;
    List<PostModel.DetailBean> postModel;
    OnItemClickListener listener;
    String TAG = "PostAdapter";


    public PostAdapter(Context context, List<PostModel.DetailBean> postModel, OnItemClickListener listener) {
        this.context = context;
        this.postModel = postModel;
        this.listener = listener;

    }

    public interface OnItemClickListener {
        void onItemClick(List<PostModel.DetailBean> topic, int position);

    }


    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_post, parent, false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.setMenu(postModel, position);
    }


    @Override
    public int getItemCount() {
        return postModel.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView mNamePost, mTimePost, mStatusPost, mNumPost;

        public MenuViewHolder(View itemView) {
            super(itemView);
            mNamePost = (TextView) itemView.findViewById(R.id.name_post);
            mNumPost = (TextView) itemView.findViewById(R.id.num_post);
            mTimePost = (TextView) itemView.findViewById(R.id.timePost);
            mStatusPost = (TextView) itemView.findViewById(R.id.statusPost);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(postModel, getAdapterPosition());
                }
            });
        }

        public void setMenu(List<PostModel.DetailBean> topic, int position) {
            mNamePost.setText(topic.get(position).getName_post());
            mNumPost.setText(topic.get(position).getNum_post());
            mTimePost.setText(topic.get(position).getDate_in());
            mStatusPost.setText(topic.get(position).getStatus_post());
        }

    }
}
