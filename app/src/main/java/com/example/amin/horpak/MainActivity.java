package com.example.amin.horpak;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.amin.horpak.API.ConnectionManager;
import com.example.amin.horpak.API.NotiCallbackListener;
import com.example.amin.horpak.API.ProfileCallbackListener;
import com.example.amin.horpak.API.RoomCallbackListener;
import com.example.amin.horpak.Fragment.ChatFragment;
import com.example.amin.horpak.Fragment.HomeFragment;
import com.example.amin.horpak.Fragment.MoreFragment;
import com.example.amin.horpak.Fragment.NotiFragment;
import com.example.amin.horpak.Fragment.ProfileFragment;
import com.example.amin.horpak.Model.NotiModel;
import com.example.amin.horpak.Model.ProfileModel;
import com.example.amin.horpak.Model.RoomModel;
import com.example.amin.horpak.Utils.StaticClass;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    String TAG = "Main";
    String token;

    private ViewPager mViewPager;
    ConnectionManager connect = new ConnectionManager();
    RoomCallbackListener roomCallbackListener = new RoomCallbackListener() {
        @Override
        public void onResponse(RoomModel roomModel, Retrofit retrofit) {
            StaticClass.roomModel = roomModel;
//            StaticClass.toast(getApplicationContext(),"ready");
            Log.d(TAG, "onResponse: roomModel");

        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t);
        }

    };

    RoomCallbackListener roomCallbackListener2 = new RoomCallbackListener() {
        @Override
        public void onResponse(RoomModel roomModel, Retrofit retrofit) {
            StaticClass.roomModelAll = roomModel;
//            StaticClass.toast(getApplicationContext(),"ready");
            Log.d(TAG, "onResponse: roomModelAll");

        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t);
        }

    };

    RoomCallbackListener roomCallbackListener3 = new RoomCallbackListener() {
        @Override
        public void onResponse(RoomModel roomModel, Retrofit retrofit) {
            StaticClass.roomModelActive = roomModel;
//            StaticClass.toast(getApplicationContext(),"ready");
            Log.d(TAG, "onResponse: roomModelAll");

        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: " + t);
        }

    };

    NotiCallbackListener notiCallbackListener = new NotiCallbackListener() {
        @Override
        public void onResponse(NotiModel notiModel, Retrofit retrofit) {
            StaticClass.notiModel = notiModel;
            Log.d(TAG, "onResponse: notiModel");
//            StaticClass.toast(getApplicationContext(),"ready");
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: notiModel" + t);
        }
    };

    ProfileCallbackListener profileCallbackListener = new ProfileCallbackListener() {
        @Override
        public void onResponse(ProfileModel profileModel, Retrofit retrofit) {
            StaticClass.profileModel = profileModel;
            Log.d(TAG, "onResponse: profileModel");
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: token " + FirebaseInstanceId.getInstance().getToken());
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager,false);
        token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onCreate: " + token);

        connect.postNoti(notiCallbackListener, token);
        connect.getProfile(profileCallbackListener, token);
        connect.getRoom(roomCallbackListener,"blank");
        connect.getRoom(roomCallbackListener3,"noblank");
        connect.getRoom(roomCallbackListener2,"all");

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new ChatFragment();
                case 2:
                    return new NotiFragment();
                case 3:
                    return new ProfileFragment();
                default:
                    return new MoreFragment();
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "Chat";
                case 2:
                    return "Noti";
                case 3:
                    return "Profile";
                case 4:
                    return "More";
            }
            return null;
        }
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
