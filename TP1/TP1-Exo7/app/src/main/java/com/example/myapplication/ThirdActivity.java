package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private String numTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        ((TextView) findViewById(R.id.taTel)).setText(intent.getStringExtra("telUser"));
        numTel = intent.getStringExtra("telUser");
    }

    public void onClickCall(View v){
        Intent call = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",numTel,null));
        startActivity(call);
    }
}