package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.PostModel;

import retrofit.Retrofit;

public interface PostCallbackListener {
    public void onResponse(PostModel postModel, Retrofit retrofit);
    public void onFailure(Throwable t);
}
