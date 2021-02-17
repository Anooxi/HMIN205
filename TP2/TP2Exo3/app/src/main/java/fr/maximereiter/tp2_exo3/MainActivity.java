package fr.maximereiter.tp2_exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sm;
    private Sensor s;
    TextView tvx;
    TextView tvy;
    TextView tvz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        tvx = (TextView) findViewById(R.id.textX);
        tvy = (TextView) findViewById(R.id.textY);
        tvz = (TextView) findViewById(R.id.textZ);

        sm.registerListener(this,s, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() != Sensor.TYPE_ACCELEROMETER){
            return;
        }
        float posX, posY, posZ;
        posX = event.values[0];
        posY = event.values[1];
        posZ = event.values[2];

        tvx.setText(String.format("valeur de x = %s", posX));
        tvx.setBackgroundColor(getBgColor(posX));
        tvy.setText(String.format("valeur de y = %s", posY));
        tvy.setBackgroundColor(getBgColor(posY));
        tvz.setText(String.format("valeur de z = %s", posZ));
        tvz.setBackgroundColor(getBgColor(posZ));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public int getBgColor(float i){
        if(i > 5){
            return getResources().getColor(R.color.gray,getTheme());
        } else if (i > 2){
            return getResources().getColor(R.color.red,getTheme());
        } else {
            return getResources().getColor(R.color.green,getTheme());
        }
    }
}