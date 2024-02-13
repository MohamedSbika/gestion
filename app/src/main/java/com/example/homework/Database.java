package com.example.homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {

    private static final String DB_NAME = "homework.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "articles";
    private static final String ID_COL = "id";
    public static final String ART_COL = "libelle";
    public static final String P_COL = "prix";
    public static final String Q_COL = "quantite";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ( "
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ART_COL + " TEXT, "
                + P_COL + " TEXT, "
                + Q_COL + " TEXT) ";
        db.execSQL(query);
    }

    public void ajouter(String libelle, String prix, String quantite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ART_COL, libelle);
        values.put(P_COL, prix);
        values.put(Q_COL, quantite);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void delete(String libelle) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ART_COL + "=?", new String[]{libelle});
        db.close();
    }

    public Cursor getListe() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
