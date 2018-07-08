package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.RoomModel;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public interface RoomCallbackListener {
    public void onResponse(RoomModel roomModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
