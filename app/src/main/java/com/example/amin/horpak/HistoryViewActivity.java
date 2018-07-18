package com.example.amin.horpak;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class HistoryViewActivity extends AppCompatActivity {

    String roomNo, idBook, status_book;
    TextView mRoom, mStatus;
    ImageView qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        Bundle bundle = getIntent().getExtras();
        roomNo = bundle.getString("roomNo");
        idBook = bundle.getString("idBook");
        status_book = bundle.getString("status_book");

        mRoom = (TextView) findViewById(R.id.txtNumRoom);
        mStatus = (TextView) findViewById(R.id.txtStatusBook);
        qrCode = (ImageView) findViewById(R.id.qrCode);
        mRoom.setText("ห้อง " + roomNo);
        mStatus.setText("สถานะ " + status_book);

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(idBook, BarcodeFormat.QR_CODE, 300, 300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
