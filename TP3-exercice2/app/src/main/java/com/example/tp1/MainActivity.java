package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    private Button gestionPlatsButton;

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

        //Initialisation de l'adapteur
        ArrayAdapter<String> adapteurEntrees = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        //Ajout des éléments de la liste
        for (int i = 0; i < Modele.lesEntrees.size(); i++) {
            adapteurEntrees.add(Modele.lesEntrees.get(i));
        }

        //Ajout de l'adapteur à la liste
        entreesUtilisateurSpinner.setAdapter(adapteurEntrees);


        platUtilisateurSpinner = findViewById(R.id.platUtilisateurSpinner);

        //Initialisation de l'adapteur
        ArrayAdapter<String> adapteurPlats = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        //Ajout des éléments de la liste
        for (int i = 0; i < Modele.lesPlats.size(); i++) {
            adapteurPlats.add(Modele.lesPlats.get(i));
        }

        //Ajout de l'adapteur à la liste
        platUtilisateurSpinner.setAdapter(adapteurPlats);

        dessertUtilisateurSpinner = findViewById(R.id.dessertUtilisateurSpinner);

        //Initialisation de l'adapteur
        ArrayAdapter<String> adapteurDesserts = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        //Ajout des éléments de la liste
        for (int i = 0; i < Modele.lesDesserts.size(); i++) {
            adapteurDesserts.add(Modele.lesDesserts.get(i));
        }

        //Ajout de l'adapteur à la liste
        dessertUtilisateurSpinner.setAdapter(adapteurDesserts);

        quantiteUtilisateurInput = findViewById(R.id.quantiteUtilisateurInput);
        quantiteUtilisateurSpinner = findViewById(R.id.quantiteUtilisateurSpinner);
        ajouterUtilisateurButton = findViewById(R.id.ajouterUtilisateurButton);
        remarquesUtilisateurInput = findViewById(R.id.remarquesUtilisateurInput);
        enregistrerUtilisateurButton = findViewById(R.id.enregistrerUtilisateurButton);
        annulerUtilisateurButton = findViewById(R.id.annulerUtilisateurButton);
        parametrageButton = findViewById(R.id.parametrageButton);
        gestionPlatsButton = findViewById(R.id.gestionPlats);

        //Selectionner la quantité dans le spinner et l'afficher dans la view quantité
        quantiteUtilisateurSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                quantiteUtilisateurInput.setText(quantiteUtilisateurSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Si un utilisateur saisie une quantité à la main le spinner se désactive durant la saisie
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

        //Associer le bouton paramétrage à l'activité ParametrageActivity
        parametrageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent(MainActivity.this, ParametrageActivity.class);
                startActivity(unIntent);
            }
        });

        //Associer le bouton gestion plats à l'activité GestionPlatsActivity
        gestionPlatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent(MainActivity.this, GestionPlats.class);
                startActivity(unIntent);
            }
        });


    }


}
