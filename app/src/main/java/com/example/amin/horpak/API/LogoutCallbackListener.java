package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.LogoutModel;

import retrofit.Retrofit;

public interface LogoutCallbackListener {
    public void onResponse(LogoutModel notiModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
