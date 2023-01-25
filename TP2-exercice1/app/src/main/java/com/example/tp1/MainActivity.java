package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

    //Constructeur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation des objets graphiques
        entreesUtilisateurSpinner = findViewById(R.id.entreesUtilisateurSpinner);
        platUtilisateurSpinner = findViewById(R.id.platUtilisateurSpinner);
        dessertUtilisateurSpinner = findViewById(R.id.dessertUtilisateurSpinner);
        quantiteUtilisateurInput = findViewById(R.id.quantiteUtilisateurInput);
        quantiteUtilisateurSpinner = findViewById(R.id.quantiteUtilisateurSpinner);
        ajouterUtilisateurButton = findViewById(R.id.ajouterUtilisateurButton);
        remarquesUtilisateurInput = findViewById(R.id.remarquesUtilisateurInput);
        enregistrerUtilisateurButton = findViewById(R.id.enregistrerUtilisateurButton);
        annulerUtilisateurButton = findViewById(R.id.annulerUtilisateurButton);

        //Selectionner la quantité dans le spinner et l'afficher dans la view quantité
        quantiteUtilisateurSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                quantiteUtilisateurInput.setText(quantiteUtilisateurSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                quantiteUtilisateurInput.setText("1");
            }
        });

    }


}
