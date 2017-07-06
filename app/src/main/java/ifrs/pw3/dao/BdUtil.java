package ifrs.pw3.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ifrs.pw3.model.Curso;

public class BdUtil extends SQLiteOpenHelper {

    private static final String BASE = "DATABASE";
    private static final int VERSAO = 1;
    private String tabela;
    private String ddl;


    public BdUtil(Context context, String tabela, String ddl) {
        super(context, BASE, null, VERSAO);
        this.tabela = tabela;
        this.ddl = ddl;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + tabela + " (" + ddl + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + tabela);
        onCreate(db);
    }

    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }

}
