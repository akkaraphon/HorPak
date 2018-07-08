package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.AgrementModel;
import com.example.amin.horpak.Model.LoginModel;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public interface AgrementCallbackListener {
    public void onResponse(AgrementModel agrement, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
