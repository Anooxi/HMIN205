package fr.maximereiter.tp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    public String userId;

    public TextView text_userId;
    public EditText name;
    public EditText lastName;
    public EditText age;
    public EditText phone;
    public Utilisation utilisation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.utilisation = new Utilisation(this);
        getLifecycle().addObserver(this.utilisation);

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

    public void submit(View v){
        String ls = System.getProperty("line.separator");
        String filename = this.lastName.getText().toString() + this.userId;
        try {
            OutputStreamWriter osw = new OutputStreamWriter(getBaseContext().openFileOutput(filename, Context.MODE_PRIVATE));
            osw.write(this.userId + ls);
            osw.write(this.name.getText().toString() + ls);
            osw.write(this.lastName.getText().toString() + ls);
            osw.write(this.age.getText().toString() + ls);
            osw.write(this.phone.getText().toString() + ls);
            osw.write(this.utilisation.toString() + ls);
            osw.close();
            Toast.makeText(getApplicationContext(),R.string.toast_success,Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),R.string.toast_error,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        Intent secondActivity = new Intent(this,SecondActivity.class);
        secondActivity.putExtra("FILENAME",filename);
        this.startActivity(secondActivity);
    }

    public void showPlanning(View v){
        String ls = System.getProperty("line.separator");
        String filename = "planning";
        String dayOne = "Réunion sprint 2 pour projet 123_Finir dossier recrutement_Continuer dossier vente_Rencontre avec le nouveau client";
        String dayTwo = "Réunion avec le boss_check BDD du projet_Voir l'états des serveurs_Continuer dossier vente";
        String dayThree = "Rencontre client Dupont_Travailler le dossier recrutement_Réunion équipe_Préparation dossier vente";

        try {
            OutputStreamWriter osw = new OutputStreamWriter(getBaseContext().openFileOutput(filename, Context.MODE_PRIVATE));
            osw.write(dayOne + ls);
            osw.write(dayTwo + ls);
            osw.write(dayThree + ls);
            osw.close();
            Toast.makeText(getApplicationContext(),R.string.toast_success,Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),R.string.toast_error,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        Intent planning = new Intent(this,Planning.class);
        planning.putExtra("FILENAME",filename);
        this.startActivity(planning);
    }
}