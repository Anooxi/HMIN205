package fr.maximereiter.tp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    public String userId;

    public TextView text_userId;
    public EditText name;
    public EditText lastName;
    public EditText age;
    public EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_userId = (TextView) findViewById(R.id.textUserId);
        name = (EditText) findViewById(R.id.editTextUserName);
        lastName = (EditText) findViewById(R.id.editTextUserLastName);
        age = (EditText) findViewById(R.id.editTextUserAge);
        phone = (EditText) findViewById(R.id.editTextUserPhone);

        if(savedInstanceState == null){
            userId = UUID.randomUUID().toString();
        }
        text_userId.setText(userId);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);


        name = (EditText) findViewById(R.id.editTextUserName);
        lastName = (EditText) findViewById(R.id.editTextUserLastName);
        age = (EditText) findViewById(R.id.editTextUserAge);
        phone = (EditText) findViewById(R.id.editTextUserPhone);

        outState.putString("USER_ID",this.userId);
        outState.putString("USER_NAME",this.name.getText().toString());
        outState.putString("USER_LASTNAME",this.lastName.getText().toString());
        outState.putString("USER_AGE",this.age.getText().toString());
        outState.putString("USER_PHONE",this.phone.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey("USER_ID")){
            String savedId = savedInstanceState.getString("USER_ID");
            this.text_userId.setText(savedId);
            this.userId = savedId;
        }
        if(savedInstanceState.containsKey("USER_NAME")){
            this.name.setText(savedInstanceState.getString("USER_NAME"));
        }
        if(savedInstanceState.containsKey("USER_LASTNAME")){
            this.lastName.setText(savedInstanceState.getString("USER_LASTNAME"));
        }
        if(savedInstanceState.containsKey("USER_AGE")){
            this.age.setText(savedInstanceState.getString("USER_AGE"));
        }
        if(savedInstanceState.containsKey("USER_PHONE")){
            this.phone.setText(savedInstanceState.getString("USER_PHONE"));
        }
    }
}