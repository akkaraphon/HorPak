package com.example.amin.horpak.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ptwitchapon on 2/4/2561.
 */

public class ConnectUpload {
    //    public static final String BASE_URL = "http://pmis.lpn.co.th";
//    public static final String URL = "http://192.168.43.14/Project/api/";
    public static final String URL = "http://192.168.43.121/Project/api/";
//    public static final String URL = "http://horpak.wat-huathanon.com/api/";
    private static Retrofit retrofit = null;
    public static int unique_id;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
