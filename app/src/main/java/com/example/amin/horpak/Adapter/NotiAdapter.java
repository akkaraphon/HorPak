package com.example.amin.horpak.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amin.horpak.Model.NotiModel;
import com.example.amin.horpak.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by ptwitchapon on 13/3/2561.
 */

public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.MenuViewHolder> {

    Context context;
    List<NotiModel.DetailBean> noti;
    OnItemClickListener listener;


    public NotiAdapter(Context context, List<NotiModel.DetailBean> noti, OnItemClickListener listener) {
        this.context = context;
        this.noti = noti;
        this.listener = listener;

    }

    public interface OnItemClickListener {
        void onItemClick(List<NotiModel.DetailBean> noti, int position);
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new MenuViewHolder(v);
    }

    @Override
        public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.setMenu(noti, position);
    }


    @Override
    public int getItemCount() {
        return noti.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView detail;
        ImageView pic;

        public MenuViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.pic) ;

            detail = (TextView) itemView.findViewById(R.id.message);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(noti, getAdapterPosition());
                }
            });
        }

        public void setMenu(List<NotiModel.DetailBean> noti, int position) {

            detail.setText(noti.get(position).getMessage());

        }

    }
}