package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ajouter_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
    }

    public void ADD(View view) {
        EditText libelleEdit = findViewById(R.id.libelle);
        String libelle = libelleEdit.getText().toString();

        EditText prixEdit = findViewById(R.id.prix);
        String prixString = prixEdit.getText().toString();
        int prix;
        try {
            prix = Integer.parseInt(prixString);
        } catch (NumberFormatException e) {
            Toast.makeText(ajouter_activity.this, "Veuillez saisir un prix valide", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText quantiteEdit = findViewById(R.id.quantite);
        String quantiteString = quantiteEdit.getText().toString();
        int quantite;
        try {
            quantite = Integer.parseInt(quantiteString);
        } catch (NumberFormatException e) {
            Toast.makeText(ajouter_activity.this, "Veuillez saisir une quantité valide", Toast.LENGTH_SHORT).show();
            return;
        }

        Database database = new Database(this);
        if (libelle.isEmpty() || quantiteString.isEmpty() || prixString.isEmpty()) {
            Toast.makeText(ajouter_activity.this, "Saisissez toutes les données", Toast.LENGTH_SHORT).show();
            return;
        }

        database.ajouter(libelle, prixString, quantiteString);
        Toast.makeText(ajouter_activity.this, "Article ajouté avec succès.", Toast.LENGTH_SHORT).show();
    }

    public void retour(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
