package fr.maximereiter.tp1_exo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText depart = (EditText) findViewById(R.id.depart);
        EditText arriver = (EditText) findViewById(R.id.arriver);
        Button partir = (Button) findViewById(R.id.button);

        partir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SecondaryActivity.class);
                intent.putExtra("depart",depart.getText().toString());
                intent.putExtra("arriver",arriver.getText().toString());
                startActivity(intent);
            }
        });
    }
}