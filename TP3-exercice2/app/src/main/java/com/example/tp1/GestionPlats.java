package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class GestionPlats extends AppCompatActivity {

    //Attributs
    public static ArrayList<CheckBox> lstCheck = new ArrayList<CheckBox>();
    private LinearLayout listeCheckbox;
    private Button supprimerButton;
    private Button boutonAjouter;
    private EditText nouveauPlat;

    //Methodes

    private void afficherCheck(){
        listeCheckbox.removeAllViews();
        lstCheck.clear();
        for (int i = 0; i < Modele.lesPlats.size(); i++) {
            LinearLayout unLayout = new LinearLayout(GestionPlats.this);
            unLayout.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox uncheck = new CheckBox(this);
            uncheck.setText(Modele.lesPlats.get(i));
            lstCheck.add(uncheck);

            unLayout.addView(uncheck);
            listeCheckbox.addView(unLayout);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gest_plats);

        listeCheckbox = findViewById(R.id.II_listeCheckBox);
        supprimerButton = findViewById(R.id.b_supprimer);
        boutonAjouter = findViewById(R.id.b_ajouter);
        nouveauPlat = findViewById(R.id.et_nouveau);

        //Initialisation liste de checkbox
        afficherCheck();

        //GGestion du bouton supprimer
        supprimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = lstCheck.size() - 1; i > 0; i--) {
                    //Verifier si case cochée
                    if (lstCheck.get(i).isChecked()){
                        Modele.lesPlats.remove(i);
                    }
                }
                afficherCheck();
            }
        });

        boutonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ajout du plat
                Modele.lesPlats.add(nouveauPlat.getText().toString());
                afficherCheck();
            }
        });
    }


};