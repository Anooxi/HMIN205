package fr.maximereiter.tp1_exo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class SecondaryActivity extends AppCompatActivity {

    private ArrayList<String> villes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent();
        String depart = intent.getStringExtra("depart");
        String arriver = intent.getStringExtra("arriver");
        getVilles();

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(depart);
        tv.append("\n");
        for(String ville : villes){
            tv.append(ville +"\n");
        }
        tv.append(arriver +"\n");
    }

    private void getVilles(){
        villes.add("Béziers");
        villes.add("Agde");
        villes.add("Montpellier");
        villes.add("Paris");
        villes.add("Rome");
    }
}