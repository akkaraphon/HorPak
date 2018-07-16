package com.example.amin.horpak.API;

import android.util.Log;

import com.example.amin.horpak.Model.AgrementModel;
import com.example.amin.horpak.Model.DepositModel;
import com.example.amin.horpak.Model.LoginModel;
import com.example.amin.horpak.Model.LogoutModel;
import com.example.amin.horpak.Model.MoveoutModel;
import com.example.amin.horpak.Model.NotiModel;
import com.example.amin.horpak.Model.ProfileModel;
import com.example.amin.horpak.Model.RentModel;
import com.example.amin.horpak.Model.RoomModel;
import com.example.amin.horpak.Model.SubmiModel;
import com.example.amin.horpak.Model.SubmitNotiModel;
import com.example.amin.horpak.Model.UpPicModel;
import com.example.amin.horpak.Model.WPModel;
import com.squareup.okhttp.ResponseBody;

import java.io.File;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ConnectionManager {
    //    String URL = "http://192.168.43.121/Project/api/";
    String URL = "http://192.168.43.121/Project/api/";
//    String URL = "http://horpak.wat-huathanon.com/api/";

    public ConnectionManager() {

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    APIService con = retrofit.create(APIService.class);

    public void postLogin(final LoginCallbackListener listener, String user, String pass, String token) {
        Call call = con.postLogin(user, pass, token);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Response<LoginModel> response, Retrofit retrofit) {
                LoginModel user = response.body();
                if (user == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(user, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void getRoom(final RoomCallbackListener listener, String status) {
        Call call = con.getRoom(status);
        call.enqueue(new Callback<RoomModel>() {
            @Override
            public void onResponse(Response<RoomModel> response, Retrofit retrofit) {
                RoomModel room = response.body();
                if (room == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(room, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void postAgrement(final AgrementCallbackListener listener, String id_rental, String id_room) {
        Call call = con.postAgrement(id_rental, id_room);
        call.enqueue(new Callback<AgrementModel>() {
            @Override
            public void onResponse(Response<AgrementModel> response, Retrofit retrofit) {
                Log.d("service", "onResponse: ");
                AgrementModel agrement = response.body();
                if (agrement == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(agrement, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }

    public void setWP(final WPCallbackListener listener, String type, String unit, String id_room) {
        Call call = con.postWP(type, unit, id_room);
        call.enqueue(new Callback<WPModel>() {
            @Override
            public void onResponse(Response<WPModel> response, Retrofit retrofit) {
                Log.d("service", "onResponse: ");
                WPModel wpModel = response.body();
                if (wpModel == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(wpModel, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }

    public void postNoti(final NotiCallbackListener listener, String user) {
        Call call = con.postNoti(user);
        call.enqueue(new Callback<NotiModel>() {
            @Override
            public void onResponse(Response<NotiModel> response, Retrofit retrofit) {
                Log.d("service", "onResponse: ");
                NotiModel notiModel = response.body();
                if (notiModel == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(notiModel, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }

    public void getLogout(final LogoutCallbackListener listener, String token) {
        Call call = con.getLogout(token);
        call.enqueue(new Callback<LogoutModel>() {
            @Override
            public void onResponse(Response<LogoutModel> response, Retrofit retrofit) {
                LogoutModel logout = response.body();
                if (logout == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(logout, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void getProfile(final ProfileCallbackListener listener, String token) {
        Call call = con.getProfile(token);
        call.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Response<ProfileModel> response, Retrofit retrofit) {
                ProfileModel profile = response.body();
                if (profile == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(profile, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void postMoveout(final MoveoutCallbackListener listener, String ID_Rentel, String dateOut) {
        Call call = con.postMoveout(ID_Rentel, dateOut);
        call.enqueue(new Callback<MoveoutModel>() {
            @Override
            public void onResponse(Response<MoveoutModel> response, Retrofit retrofit) {
                MoveoutModel moveoutModel = response.body();
                if (moveoutModel == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(moveoutModel, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void checkSubmit(final SubmitCallbackListener listener, String ID_Rentel) {
        Call call = con.checkSubmit(ID_Rentel);
        call.enqueue(new Callback<SubmiModel>() {
            @Override
            public void onResponse(Response<SubmiModel> response, Retrofit retrofit) {
                SubmiModel submiModel = response.body();
                if (submiModel == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(submiModel, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void submitNoti(final SumitnotiCallbackListener listener, String ID_Rentel) {
        Call call = con.submitNoti(ID_Rentel);
        call.enqueue(new Callback<SubmitNotiModel>() {
            @Override
            public void onResponse(Response<SubmitNotiModel> response, Retrofit retrofit) {
                SubmitNotiModel submitNotiModel = response.body();
                if (submitNotiModel == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(submitNotiModel, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void getRentel(final RentCallbackListener listener, String ID_Mem, String id_room, String Date_checkin) {
        Call call = con.getRent(ID_Mem, id_room, Date_checkin);
        call.enqueue(new Callback<RentModel>() {
            @Override
            public void onResponse(Response<RentModel> response, Retrofit retrofit) {
                RentModel rentModel = response.body();
                if (rentModel == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(rentModel, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void getDeposit(final DepositCallbackListener listener, String idRoom, String deposit) {
        Call call = con.getDeposit(idRoom, deposit);
        call.enqueue(new Callback<DepositModel>() {
            @Override
            public void onResponse(Response<DepositModel> response, Retrofit retrofit) {
                DepositModel depositModel = response.body();
                if (depositModel == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                } else {
                    //200
                    listener.onResponse(depositModel, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

}
