package fr.maximereiter.tp2_exo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor s;
    TextView tv;
    TextView tv2;
    TextView tx;
    TextView ty;
    float oldX;
    float oldY;
    int count;
    ArrayList<Float> listx;
    ArrayList<Float> listy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tx = (TextView) findViewById(R.id.txtX);
        ty = (TextView) findViewById(R.id.txtY);
        tv.setText("Please wait");
        oldX = 0;
        oldY = 0;
        count = 0;
        listx = new ArrayList<>();
        listy = new ArrayList<>();
    }


    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() != Sensor.TYPE_ACCELEROMETER){
            return;
        }
        float posX,posY;
        posX = event.values[0];
        posY = event.values[1];

        count++;
        listx.add(posX);
        listy.add(posY);
        if(count < 10){
            return;
        }
            float moyx = 0;
            for(float f : listx){
                moyx += f;
            }
            posX = moyx / count;
            float moyy = 0;
            for(float f : listy){
                moyy += f;
            }
            posY = moyy / count;
            count = 0;
            listx = new ArrayList<>();
            listy = new ArrayList<>();


        if(posX > oldX){
            tv.setText("Droite");
        } else {
            tv.setText("Gauche");
        }
        if(posY > oldY){
            tv2.setText("Haut");
        } else {
            tv2.setText("Bas");
        }
        tx.setText("x :" + posX);
        ty.setText("y : " + posY);

        oldX = posX;
        oldY = posY;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}