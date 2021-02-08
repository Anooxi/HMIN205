package fr.maximereiter.tp1_exo3_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Nom
        TextView tvNom = new TextView(this);
        tvNom.setText(R.string.nom);
        EditText edNom = new EditText(this);
        // Prénom
        TextView tvPrenom = new TextView(this);
        tvPrenom.setText(R.string.prenom);
        EditText edPrenom = new EditText(this);
        // Age
        TextView tvAge = new TextView(this);
        tvAge.setText(R.string.age);
        EditText edAge = new EditText(this);
        // Domaine
        TextView tvDomaine = new TextView(this);
        tvDomaine.setText(R.string.domaine);
        EditText edDomaine = new EditText(this);
        // Téléphone
        TextView tvTel = new TextView(this);
        tvTel.setText(R.string.tel);
        EditText edTel = new EditText(this);

        // Bouton
        Button button = new Button(this);
        button.setText(R.string.bouton);

        TableLayout tl = new TableLayout(this);
        tl.setColumnStretchable(1,true);
        tl.setColumnShrinkable(1,true);
        // Nom
        TableRow tr1 = new TableRow(this);
        tr1.addView(tvNom);
        tr1.addView(edNom);
        tl.addView(tr1);
        // Prenom
        TableRow tr2 = new TableRow(this);
        tr2.addView(tvPrenom);
        tr2.addView(edPrenom);
        tl.addView(tr2);
        // Age
        TableRow tr3 = new TableRow(this);
        tr3.addView(tvAge);
        tr3.addView(edAge);
        tl.addView(tr3);
        // Domaine
        TableRow tr4 = new TableRow(this);
        tr4.addView(tvDomaine);
        tr4.addView(edDomaine);
        tl.addView(tr4);
        // Téléphone
        TableRow tr5 = new TableRow(this);
        tr5.addView(tvTel);
        tr5.addView(edTel);
        tl.addView(tr5);
        // Bouton
        TableRow tr6 = new TableRow(this);
        tr6.addView(button);
        tl.addView(tr6);

        // Affichage final
        setContentView(tl);
    }
}