package com.grupointegrado.listatarefa.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFA";
    public static String TABELA_TAREFAS = "TAREFA";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL);";

        try {
            db.execSQL( sql );
            Log.i("LOGBANCO", "Sucesso ao criar tabela");
        } catch (Exception e) {
            Log.i("LOGBANCO", "Erro ao criar tabela " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;";

        try {
            db.execSQL( sql );
            onCreate(db);
            Log.i("LOGBANCO", "Sucesso ao atualizar APP");
        } catch (Exception e) {
            Log.i("LOGBANCO", "Erro ao atualizar APP " + e.getMessage());
        }
    }
}
