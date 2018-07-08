package com.example.amin.horpak;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.amin.horpak.API.ConnectUpload;
import com.example.amin.horpak.API.UploadService;
import com.example.amin.horpak.Model.UpPicModel;
import com.mindorks.paracamera.Camera;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpidActivity extends AppCompatActivity {

    Camera camera;
    ImageView slip;
    Button picker,upload;
    String TAG = "UpidAc";
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upid);

        slip =(ImageView) findViewById(R.id.slip);
        picker = (Button) findViewById(R.id.picker);
        upload = (Button) findViewById(R.id.upload);

        if (Build.VERSION.SDK_INT > 22) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });
    }

    public void pick(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        camera = new Camera.Builder()
                .resetToCorrectOrientation(true)
                .setTakePhotoRequestCode(1)
                .setDirectory("pics")
                .setName("ali_" + System.currentTimeMillis())
                .setImageFormat(Camera.IMAGE_JPEG)
                .setCompression(75)
                .setImageHeight(1000)
                .build(this);
        try {
            camera.takePicture();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Camera.REQUEST_TAKE_PHOTO) {
            bitmap = camera.getCameraBitmap();
            if (bitmap != null) {
                slip.setImageBitmap(bitmap);
            } else {
                Toast.makeText(getApplicationContext(), "Picture not taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Uploading Image/Video
    private void uploadFile() {
        File file = new File(camera.getCameraBitmapPath());
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/svg+xml"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        RequestBody mIdRentel = RequestBody.create(MediaType.parse("text/plain"), StaticClass.agrement.getAgm().getID_Rentel());

        UploadService getResponse = ConnectUpload.getClient().create(UploadService.class);
        Call<UpPicModel> call = getResponse.uploadID(fileToUpload, filename,mIdRentel);
        call.enqueue(new Callback<UpPicModel>() {
            @Override
            public void onResponse(Call<UpPicModel> call, Response<UpPicModel> response) {
                Log.d(TAG, "onResponse: " + response.toString());
                UpPicModel serverResponse = response.body();
                if (serverResponse != null) {
                    if (serverResponse.isSuccess()) {
                        Log.d(TAG, "onResponse : "+serverResponse.getMessage());
                        StaticClass.toast(getApplicationContext(),"อัพโหลดสำเร็จ");
                        finish();
                    } else {

                    }
                } else {
                    assert serverResponse != null;
                }
            }

            @Override
            public void onFailure(Call<UpPicModel> call, Throwable t) {

            }
        });
    }
}
