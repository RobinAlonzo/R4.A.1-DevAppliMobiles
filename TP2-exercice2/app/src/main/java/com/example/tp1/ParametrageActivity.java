package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ParametrageActivity extends AppCompatActivity {

    //Attributs
    private Button ajouterParamButton;
    private RadioGroup radioGroup;
    private EditText inputPlatParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);

        //Initialisation des variables
        ajouterParamButton = findViewById(R.id.ajouterParamButton);
        radioGroup = findViewById(R.id.radioGroup);
        inputPlatParam = findViewById(R.id.inputPlatParam);

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



    }

}