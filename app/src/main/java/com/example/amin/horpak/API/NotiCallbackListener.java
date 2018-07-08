package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.NotiModel;

import retrofit.Retrofit;

public interface NotiCallbackListener {
    public void onResponse(NotiModel notiModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
