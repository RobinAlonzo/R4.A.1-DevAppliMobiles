package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Attributs
    private Spinner entreesUtilisateurSpinner;
    private Spinner platUtilisateurSpinner;
    private Spinner dessertUtilisateurSpinner;
    private EditText quantiteUtilisateurInput;
    private Spinner quantiteUtilisateurSpinner;
    private Button ajouterUtilisateurButton;
    private EditText remarquesUtilisateurInput;
    private Button enregistrerUtilisateurButton;
    private Button annulerUtilisateurButton;
    private Button parametrageButton;

    //Constructeur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation classe Modele
        Modele.initPlats();
        Modele.initEntrees();
        Modele.initDesserts();


        //Initialisation des objets graphiques
        entreesUtilisateurSpinner = findViewById(R.id.entreesUtilisateurSpinner);
        ArrayAdapter<String> adapteurEntrees = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        for (int i = 0; i < Modele.lesEntrees.size(); i++) {
            adapteurEntrees.add(Modele.lesEntrees.get(i));
        }
        entreesUtilisateurSpinner.setAdapter(adapteurEntrees);

        platUtilisateurSpinner = findViewById(R.id.platUtilisateurSpinner);
        ArrayAdapter<String> adapteurPlats = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        for (int i = 0; i < Modele.lesPlats.size(); i++) {
            adapteurPlats.add(Modele.lesPlats.get(i));
        }
        platUtilisateurSpinner.setAdapter(adapteurPlats);

        dessertUtilisateurSpinner = findViewById(R.id.dessertUtilisateurSpinner);
        ArrayAdapter<String> adapteurDesserts = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        for (int i = 0; i < Modele.lesDesserts.size(); i++) {
            adapteurDesserts.add(Modele.lesDesserts.get(i));
        }
        dessertUtilisateurSpinner.setAdapter(adapteurDesserts);

        quantiteUtilisateurInput = findViewById(R.id.quantiteUtilisateurInput);
        quantiteUtilisateurSpinner = findViewById(R.id.quantiteUtilisateurSpinner);
        ajouterUtilisateurButton = findViewById(R.id.ajouterUtilisateurButton);
        remarquesUtilisateurInput = findViewById(R.id.remarquesUtilisateurInput);
        enregistrerUtilisateurButton = findViewById(R.id.enregistrerUtilisateurButton);
        annulerUtilisateurButton = findViewById(R.id.annulerUtilisateurButton);
        parametrageButton = findViewById(R.id.parametrageButton);

        //Selectionner la quantit?? dans le spinner et l'afficher dans la view quantit??
        quantiteUtilisateurSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                quantiteUtilisateurInput.setText(quantiteUtilisateurSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Si un utilisateur saisie une quantit?? ?? la main le spinner se d??sactive durant la saisie
        quantiteUtilisateurInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (quantiteUtilisateurInput.getText().toString().length() > 0)
                    quantiteUtilisateurSpinner.setEnabled(false);
                else
                    quantiteUtilisateurSpinner.setEnabled(true);
                return false;
            }
        });

        //Associer le bouton param??trage ?? l'activit?? ParametrageActivity
        parametrageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent(MainActivity.this, ParametrageActivity.class);
                startActivity(unIntent);
            }
        });


    }


}
