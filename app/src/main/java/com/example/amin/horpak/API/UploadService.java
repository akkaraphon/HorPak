package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.UpPicModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit.http.Field;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by ptwitchapon on 2/4/2561.
 */

public interface UploadService {
    @Multipart
    @POST("getPicrental.php")
    Call<UpPicModel> uploadFile(@Part MultipartBody.Part file,
                                @Part("file") RequestBody name,
                                @Part("id_rentel") RequestBody id_rentel,
                                @Part("fname") RequestBody fname,
                                @Part("sname") RequestBody sname);

    @Multipart
    @POST("upid.php")
    Call<UpPicModel> uploadID(@Part MultipartBody.Part file,
                                @Part("file") RequestBody name,
                                @Part("id_rentel") RequestBody id_rentel);
}


