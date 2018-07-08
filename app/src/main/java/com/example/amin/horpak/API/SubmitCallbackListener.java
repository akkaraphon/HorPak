package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.SubmiModel;

import retrofit.Retrofit;

public interface SubmitCallbackListener {
    public void onResponse(SubmiModel submiModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
