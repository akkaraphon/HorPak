package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.SubmitNotiModel;

import retrofit.Retrofit;

public interface SumitnotiCallbackListener {
    public void onResponse(SubmitNotiModel submitNotiModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
