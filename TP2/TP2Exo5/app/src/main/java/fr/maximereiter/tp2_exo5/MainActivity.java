package fr.maximereiter.tp2_exo5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor s;
    CameraManager cm;
    float oldX;
    float oldY;
    float oldZ;
    String cameraId;
    long lastUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_GAME);
        cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        oldX = 0;
        oldY = 0;
        oldZ = 0;
        lastUpdate = System.currentTimeMillis();
        try {
            cameraId = cm.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() != Sensor.TYPE_ACCELEROMETER){
            return;
        }
        long curTime = System.currentTimeMillis();
        if((curTime - lastUpdate) > 100){
            long diffTime = (curTime - lastUpdate);
            lastUpdate = curTime;
            float posX,posY,posZ;
            posX = event.values[0];
            posY = event.values[1];
            posZ = event.values[2];

            float speed = Math.abs(posX+posY+posZ-oldX-oldY-oldZ)/ diffTime * 10000;

            if(speed > 1200){
                //turn on flash;
                try {
                    cm.setTorchMode(cameraId,true);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    cm.setTorchMode(cameraId,false);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

            oldX = posX;
            oldY = posY;
            oldZ = posZ;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}