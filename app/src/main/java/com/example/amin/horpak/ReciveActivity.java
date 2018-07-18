package com.example.amin.horpak;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.amin.horpak.Utils.StaticClass;

import java.io.File;
import java.util.Calendar;

public class ReciveActivity extends AppCompatActivity {

    //private Button button;
    private WebView webView;
    final Activity activity = this;
    public Uri imageUri;

    Calendar calendar = Calendar.getInstance();
    String mYear;
    String mMonth;
    String mDayOfMonth;

    private static final int FILECHOOSER_RESULTCODE = 2888;
    private ValueCallback<Uri> mUploadMessage;
    private Uri mCapturedImageURI = null;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Get webview
        webView = (WebView) findViewById(R.id.webView);

        // Define url that will open in webview
        String webViewUrl = StaticClass.URL + "bill2.php?ID_bill=1&ID_Room=61&bill_month=%E0%B8%81%E0%B8%A3%E0%B8%81%E0%B8%8F%E0%B8%B2%E0%B8%84%E0%B8%A1&bill_year="
                + mYear + "&from=app";


        // Javascript inabled on webview
        webView.getSettings().setJavaScriptEnabled(true);

        // Other webview options
        webView.getSettings().setLoadWithOverviewMode(true);

        //webView.getSettings().setUseWideViewPort(true);

        //Other webview settings
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
//        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setSupportZoom(true);

        //Load url in webview
        webView.loadUrl(webViewUrl);

    }

    // Open previous opened link from history on webview when back button pressed

    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {

        if (webView.canGoBack()) {

            webView.goBack();

        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }
}
