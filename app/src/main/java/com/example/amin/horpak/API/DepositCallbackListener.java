package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.DepositModel;

import retrofit.Retrofit;

public interface DepositCallbackListener {
    public void onResponse(DepositModel depositModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
