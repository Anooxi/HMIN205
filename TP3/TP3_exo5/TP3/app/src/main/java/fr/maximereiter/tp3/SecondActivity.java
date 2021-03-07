package fr.maximereiter.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.textView);
        Intent i = getIntent();
        String filename = i.getStringExtra("FILENAME");
        String data = readFile(getBaseContext(),filename);

        tv.setText(data);
        Log.d("SecondActivity",data);
    }

    public String readFile(Context context,String filename){
        String data = "";
        String ls = System.getProperty("line.separator");
        try {
            InputStream is = context.openFileInput(filename);
            if(is != null){
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = br.readLine()) != null ) {
                    stringBuilder.append(ls).append(receiveString);
                }

                is.close();
                data = stringBuilder.toString();

            }
        } catch (Exception e){
            Toast.makeText(context,R.string.toast_error2,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return data;
    }
}