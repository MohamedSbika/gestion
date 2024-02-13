package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class supp_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supp);
    }

    public void Delete(View view) {
        EditText libelleEdit = findViewById(R.id.libelle);
        String libelle = libelleEdit.getText().toString();
        Database database = new Database(this);
        if (libelle.isEmpty()) {
            Toast.makeText(this, "Veuillez saisir le libelle", Toast.LENGTH_SHORT).show();
            return;
        }

        database.delete(libelle); // Utilisation de l'instance de Database pour appeler la méthode delete()
        Toast.makeText(this, "Article supprimé.", Toast.LENGTH_SHORT).show();
    }

    public void retour(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
