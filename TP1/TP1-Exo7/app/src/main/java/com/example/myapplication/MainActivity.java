package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v){
        AlertDialog.Builder b1 = new AlertDialog.Builder(this);

        b1.setTitle(R.string.valide);
        b1.setMessage(R.string.validate);
        b1.setCancelable(true);

        b1.setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),R.string.alertecontenu,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),SecondaryActivity.class);
                intent.putExtra("nomUser",((EditText)findViewById(R.id.editTextPersonName)).getText().toString());
                intent.putExtra("prenomUser",((EditText)findViewById(R.id.editTextPersonName2)).getText().toString());
                intent.putExtra("ageUser",((EditText)findViewById(R.id.editTextPersonAge)).getText().toString());
                intent.putExtra("domaineUser",((EditText)findViewById(R.id.editTextDomain)).getText().toString());
                intent.putExtra("telUser",((EditText)findViewById(R.id.editTextDomain2)).getText().toString());
                startActivity(intent);
                dialog.cancel();
            }
        });

        b1.setNegativeButton(R.string.non, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog a1 = b1.create();

        a1.show();
    }

}