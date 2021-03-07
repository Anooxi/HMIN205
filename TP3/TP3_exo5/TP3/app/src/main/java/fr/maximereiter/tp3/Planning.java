package fr.maximereiter.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Planning extends AppCompatActivity {

    private PlanningModel pm;
    private int dayCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);


        TextView p1 = (TextView) findViewById(R.id.textPlanningChange);
        TextView p2 = (TextView) findViewById(R.id.textPlanningChange1);
        TextView p3 = (TextView) findViewById(R.id.textPlanningChange2);
        TextView p4 = (TextView) findViewById(R.id.textPlanningChange3);

        this.pm = new ViewModelProvider(this).get(PlanningModel.class);
        pm.rdv1.observe(this, s -> p1.setText(pm.getRdv1()));
        pm.rdv2.observe(this, s -> p2.setText(pm.getRdv2()));
        pm.rdv3.observe(this, s -> p3.setText(pm.getRdv3()));
        pm.rdv4.observe(this, s -> p4.setText(pm.getRdv4()));
    }

    public void newDay(View v){
        Intent intent = getIntent();
        String filename = intent.getStringExtra("FILENAME");
        String s = ";";
        if(dayCounter > 2) {
            dayCounter = 0;
        };
        try{
            InputStream is = getBaseContext().openFileInput(filename);
            if(is != null){
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String receiveString = "";
                String[] tab;
                StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                while ((receiveString = br.readLine()) != null){
                    if(i == dayCounter){
                        tab = receiveString.split("_");
                        pm.setRdv1(tab[0]);
                        pm.setRdv2(tab[1]);
                        pm.setRdv3(tab[2]);
                        pm.setRdv4(tab[3]);
                    }
                    i++;
                }
                dayCounter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}