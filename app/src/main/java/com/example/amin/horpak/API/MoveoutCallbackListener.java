package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.MoveoutModel;

import retrofit.Retrofit;

public interface MoveoutCallbackListener {
    public void onResponse(MoveoutModel moveoutModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
