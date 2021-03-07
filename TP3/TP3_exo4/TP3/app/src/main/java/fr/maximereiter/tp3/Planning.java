package fr.maximereiter.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Planning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        PlanningModel pm = new PlanningModel();
        TextView p1 = (TextView) findViewById(R.id.textPlanning);
        TextView p2 = (TextView) findViewById(R.id.textPlanning1);
        TextView p3 = (TextView) findViewById(R.id.textPlanning2);
        TextView p4 = (TextView) findViewById(R.id.textPlanning3);

        p1.append(pm.rdv1);
        p2.append(pm.rdv2);
        p3.append(pm.rdv3);
        p4.append(pm.rdv4);
    }
}