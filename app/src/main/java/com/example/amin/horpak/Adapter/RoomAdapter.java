package com.example.amin.horpak.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amin.horpak.Model.RoomModel;
import com.example.amin.horpak.R;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MenuViewHolder> {

    Context context;
    List<RoomModel.DetailBean> roomModel;
    OnItemClickListener listener;


    public RoomAdapter(Context context, List<RoomModel.DetailBean> roomModel, OnItemClickListener listener) {
        this.context = context;
        this.roomModel = roomModel;
        this.listener = listener;

    }

    public interface OnItemClickListener {
        void onItemClick(List<RoomModel.DetailBean> topic, int position);
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_room, parent, false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.setMenu(roomModel, position);
    }


    @Override
    public int getItemCount() {
        return roomModel.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView mRoom;

        public MenuViewHolder(View itemView) {
            super(itemView);
            mRoom = (TextView) itemView.findViewById(R.id.room);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(roomModel, getAdapterPosition());
                }
            });
        }

        public void setMenu(List<RoomModel.DetailBean> topic, int position) {
            mRoom.setText(topic.get(position).getNo_Room());
        }

    }
}
