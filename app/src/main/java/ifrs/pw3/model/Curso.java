package ifrs.pw3.model;


import android.content.ContentValues;
import android.database.Cursor;

public class Curso {

    private Integer cursoId;
    private String nome;
    private String descricao;
    private int curso_departamento_id;

    public Curso() {
    }

    public Curso(Integer cursoId, String nome, String descricao, int curso_departamento_id) {
        this.cursoId = cursoId;
        this.nome = nome;
        this.descricao = descricao;
        this.curso_departamento_id = curso_departamento_id;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCurso_departamento_id() {
        return curso_departamento_id;
    }

    public void setCurso_departamento_id(int curso_departamento_id) {
        this.curso_departamento_id = curso_departamento_id;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "cursoId=" + cursoId +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", curso_departamento_id=" + curso_departamento_id +
                '}';
    }
}
