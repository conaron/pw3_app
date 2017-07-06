package ifrs.pw3.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Noticia {

    private Integer noticiaId;
    private String titulo;
    private String imagemUrl;
    private String manchete;
    private String noticia;

    public Noticia() {
    }

    public Noticia(Integer noticiaId, String titulo, String imagemUrl, String manchete, String noticia) {
        this.noticiaId = noticiaId;
        this.titulo = titulo;
        this.imagemUrl = imagemUrl;
        this.manchete = manchete;
        this.noticia = noticia;
    }

    public Integer getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(Integer noticiaId) {
        this.noticiaId = noticiaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
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

    @Override
    public String toString() {
        return "Noticia{" +
                "noticiaId=" + noticiaId +
                ", titulo='" + titulo + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", manchete='" + manchete + '\'' +
                ", noticia='" + noticia + '\'' +
                '}';
    }
}
