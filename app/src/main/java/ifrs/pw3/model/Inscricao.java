package ifrs.pw3.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Inscricao {

    private int inscricaoId;
    private String nome;
    private String email;
    private String fone;
    private int cursoId;

    public Inscricao() {
    }

    public Inscricao(int inscricaoId, String nome, String email, String fone, int cursoId) {
        this.inscricaoId = inscricaoId;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
        this.cursoId = cursoId;
    }

    public int getInscricaoId() {
        return inscricaoId;
    }

    public void setInscricaoId(int inscricaoId) {
        this.inscricaoId = inscricaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    @Override
    public String toString() {
        return "Inscricao{" +
                "inscricaoId=" + inscricaoId +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                ", cursoId=" + cursoId +
                '}';
    }
}
