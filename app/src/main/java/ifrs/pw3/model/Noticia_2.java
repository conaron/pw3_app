package ifrs.pw3.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Noticia_2 {

    private int _id;
    private String titulo;
    private String imagem;
    private String manchete;
    private String noticia;

    // persistencia
    private static final String ID = "_ID";
    private static final String TITULO = "TITULO";
    private static final String IMAGEM = "IMAGEM";
    private static final String MANCHETE = "MANCHETE";
    private static final String NOTICIA = "NOTICIA";

    public static final String TABELA = "NOTICIA";
    public static final String SELECT = "SELECT * FROM " + TABELA + " WHERE " + ID + " = ";
    public static final String SELECT_ALL = "SELECT * FROM " + TABELA + " ORDER BY " + ID;
    public static String DDL = ID + " INTEGER PRIMARY KEY,"
            + TITULO + " TEXT,"
            + IMAGEM + " TEXT,"
            + MANCHETE + " TEXT,"
            + NOTICIA + " TEXT";

    public Noticia_2() {
    }

    public Noticia_2(int _id, String titulo, String imagem, String manchete, String noticia) {
        this._id = _id;
        this.titulo = titulo;
        this.imagem = imagem;
        this.manchete = manchete;
        this.noticia = noticia;
    }

    public Noticia_2(Cursor cursor) {
        this._id = cursor.getInt(cursor.getColumnIndex(ID));
        this.titulo = cursor.getString(cursor.getColumnIndex(TITULO));
        this.imagem = cursor.getString(cursor.getColumnIndex(IMAGEM));
        this.manchete = cursor.getString(cursor.getColumnIndex(MANCHETE));
        this.noticia = cursor.getString(cursor.getColumnIndex(NOTICIA));
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getManchete() {
        return manchete;
    }

    public void setManchete(String manchete) {
        this.manchete = manchete;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public ContentValues getValores() {
        ContentValues valores = new ContentValues();
        valores.put("_ID", _id);
        valores.put("TITULO", titulo);
        valores.put("IMAGEM", imagem);
        valores.put("MANCHETE", manchete);
        valores.put("NOTICIA", noticia);
        return valores;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "_id=" + _id +
                ", titulo='" + titulo + '\'' +
                ", imagem='" + imagem + '\'' +
                ", manchete='" + manchete + '\'' +
                ", noticia='" + noticia + '\'' +
                '}';
    }
}
