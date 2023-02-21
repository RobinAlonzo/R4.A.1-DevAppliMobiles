package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ParametrageActivity extends AppCompatActivity {

    //Attributs
    private Button ajouterParamButton;
    private RadioGroup radioGroup;
    private EditText inputPlatParam;
    private Button supprimerParamButton;
    private Spinner listeEntreesParam;
    private Spinner listePlatsParam;
    private Spinner listeDessertsParam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);

        //Initialisation des variables
        ajouterParamButton = findViewById(R.id.ajouterParamButton);
        radioGroup = findViewById(R.id.radioGroup);
        inputPlatParam = findViewById(R.id.inputPlatParam);
        supprimerParamButton = findViewById(R.id.supprimerParamButton);
        listeEntreesParam = findViewById(R.id.listeEntreesParam);
        listePlatsParam = findViewById(R.id.listePlatsParam);
        listeDessertsParam = findViewById(R.id.listeDessertsParam);

        //Ajouter un élément
        ajouterParamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String selectedText = inputPlatParam.getText().toString();
                switch(selectedId){
                    case R.id.radioEntreesParam:
                        Log.d("radioEntreesParam", "Entrée");
                        break;
                    case R.id.radioPlatsParam:
                        Log.d("radioPlatsParam", "Plat");
                        break;
                    case R.id.radioDessertsParam:
                        Log.d("radioDessertsParam", "Dessert");
                        break;
                }

                Log.d("selectedText", selectedText);
            }
        });

        //Supprimer un élément
        supprimerParamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedEntrees = listeEntreesParam.getSelectedItemPosition();
                int selectedPlats = listePlatsParam.getSelectedItemPosition();
                int selectedDesserts = listeDessertsParam.getSelectedItemPosition();

                if (selectedEntrees != 0) {
                    Log.d("NomSelection", "Suppression de l'entrée");
                    Log.d("selectedEntrees", String.valueOf(selectedEntrees));
                    Log.d("NomSelection", listeEntreesParam.getSelectedItem().toString());
                }
                if (selectedPlats != 0) {
                    Log.d("NomSelection", "Suppression du plat");
                    Log.d("selectedPlats", String.valueOf(selectedPlats));
                    Log.d("NomSelection", listePlatsParam.getSelectedItem().toString());
                }
                if (selectedDesserts != 0) {
                    Log.d("NomSelection", "Suppression du dessert");
                    Log.d("selectedDesserts", String.valueOf(selectedDesserts));
                    Log.d("NomSelection", listeDessertsParam.getSelectedItem().toString());
                }
            }
        });



    }

}