package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class afficher_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher);
        ListView listeArticles = findViewById(R.id.listView);
        Database database = new Database(this);

        ArrayList<String> Liste = new ArrayList<>();
        Cursor data = database.getListe(); // Utilisation de l'instance de Database pour appeler getListe()
        if (data.getCount() == 0) {
            Toast.makeText(this, "La liste est vide", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {
                // Récupérer les valeurs de chaque colonne
                @SuppressLint("Range") String libelle = data.getString(data.getColumnIndex(Database.ART_COL));
                @SuppressLint("Range") String quantite = data.getString(data.getColumnIndex(Database.Q_COL));
                @SuppressLint("Range") String prix = data.getString(data.getColumnIndex(Database.P_COL));

                // Ajouter les valeurs à la liste
                Liste.add("Libellé: " + libelle + ", Quantité: " + quantite + ", Prix: " + prix);
            }
            // Créer l'adapter avec la liste complète des articles
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Liste);
            listeArticles.setAdapter(listAdapter);
        }
    } // Fermeture de la méthode onCreate()

    public void retour(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
