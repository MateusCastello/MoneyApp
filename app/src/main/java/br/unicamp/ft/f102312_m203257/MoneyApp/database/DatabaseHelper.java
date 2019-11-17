package br.unicamp.ft.f102312_m203257.MoneyApp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "FINANCEIRO";
    private static final int DB_VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tabela " +
                "(_id INTEGER PRIMARY KEY, " +
                "Texto Text);");

        db.execSQL("CREATE TABLE despesas " +
                "(_id INTEGER PRIMARY KEY, descricao Text, tipoOperacao Text, valor NUMERIC(10,2));");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < 2){
            db.execSQL("ALTER TABLE tabela " +
                    "ADD COLUMN texto;");
        }
    }
}