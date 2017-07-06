package ifrs.pw3.model;

import java.sql.Time;
import java.util.Date;


public class UsuarioDados {

    private String nome;
    private String descricao;
    private String dia;
    private Time horario;
    private int duracao;

    public UsuarioDados() {
    }

    public UsuarioDados(String nome, String descricao, String dia, Time horario, int duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.dia = dia;
        this.horario = horario;
        this.duracao = duracao;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


}
