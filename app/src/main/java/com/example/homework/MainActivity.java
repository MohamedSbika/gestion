package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ajouter (View view){
        Intent I = new Intent(this, ajouter_activity.class);
        startActivity(I);
    }
    public void supprimer (View view){
        Intent I = new Intent(this, supp_activity.class);
        startActivity(I);
    }
        public void afficher (View view){
        Intent I = new Intent(this, afficher_activity.class);
        startActivity(I);
    }
}