package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.RentModel;

import retrofit2.Retrofit;

public interface RentCallbackListener {
    public void onResponse(RentModel rentModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
