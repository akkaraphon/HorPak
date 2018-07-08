package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.UpPicModel;

import retrofit.Retrofit;

public interface UploadCallback {
    public void onResponse(UpPicModel uppic, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(com.squareup.okhttp.ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
