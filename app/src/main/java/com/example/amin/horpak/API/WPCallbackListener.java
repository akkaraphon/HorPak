package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.WPModel;

import retrofit.Retrofit;

public interface WPCallbackListener {
    public void onResponse(WPModel wpModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
