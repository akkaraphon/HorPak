package com.example.amin.horpak.API;

import com.example.amin.horpak.Model.AgrementModel;
import com.example.amin.horpak.Model.LoginModel;
import com.example.amin.horpak.Model.LogoutModel;
import com.example.amin.horpak.Model.MoveoutModel;
import com.example.amin.horpak.Model.NotiModel;
import com.example.amin.horpak.Model.ProfileModel;
import com.example.amin.horpak.Model.RoomModel;
import com.example.amin.horpak.Model.SubmiModel;
import com.example.amin.horpak.Model.SubmitNotiModel;
import com.example.amin.horpak.Model.UpPicModel;
import com.example.amin.horpak.Model.WPModel;
import com.example.amin.horpak.MoveOutActivity;

import java.io.File;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;


public interface APIService {
    @FormUrlEncoded
    @POST("checkLogin.php")
    Call<LoginModel> postLogin(
            @Field("username") String user,
            @Field("password") String pass,
            @Field("token") String token);

    @GET("getRoom.php")
    Call<RoomModel> getRoom();

    @FormUrlEncoded
    @POST("InsertWP.php")
    Call<WPModel> postWP(
            @Field("type") String type,
            @Field("unit") String unit,
            @Field("roomId") String roomId);

    @FormUrlEncoded
    @POST("getAgrement.php")
    Call<AgrementModel> postAgrement(
            @Field("ID_Rentel") String id_rental,
            @Field("ID_Room") String id_room);

    @FormUrlEncoded
    @POST("getNoti.php")
    Call<NotiModel> postNoti(@Field("token") String user);

    @FormUrlEncoded
    @POST("logout.php")
    Call<LogoutModel> getLogout(@Field("token") String token);

    @FormUrlEncoded
    @POST("getProfile.php")
    Call<ProfileModel> getProfile(@Field("token") String token);

    @FormUrlEncoded
    @POST("postMoveout.php")
    Call<MoveoutModel> postMoveout(
            @Field("ID_Rentel") String ID_Rentel,
            @Field("dateOut") String dateOut);

    @FormUrlEncoded
    @POST("checkSubmit.php")
    Call<SubmiModel> checkSubmit(
            @Field("ID_Rentel") String ID_Rentel);

    @FormUrlEncoded
    @POST("submitNoti.php")
    Call<SubmitNotiModel> submitNoti(
            @Field("id_rentel") String ID_Rentel);

    @FormUrlEncoded
    @POST("getRentel.php")
    Call<SubmitNotiModel> getRentel(
            @Field("id_room") String id_room);

}
