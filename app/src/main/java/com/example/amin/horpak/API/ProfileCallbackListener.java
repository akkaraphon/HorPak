package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.ProfileModel;

import retrofit.Retrofit;

public interface ProfileCallbackListener {
    public void onResponse(ProfileModel profileModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
