package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent();
        ((TextView) findViewById(R.id.saNom)).setText(intent.getStringExtra("nomUser"));
        ((TextView) findViewById(R.id.saPrenom)).setText(intent.getStringExtra("prenomUser"));
        ((TextView) findViewById(R.id.saAge)).setText(intent.getStringExtra("ageUser"));
        ((TextView) findViewById(R.id.saDomaine)).setText(intent.getStringExtra("domaineUser"));
        ((TextView) findViewById(R.id.saTel)).setText(intent.getStringExtra("telUser"));

    }

    public void onClickConfirm(View v){
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
    public void onClickReturn(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
