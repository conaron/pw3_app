package ifrs.pw3.model;

/**
 * Created by Ton on 04/07/2017.
 */

public class CursoDepartamento {

    private Integer cursoDepartamentoId;
    private String nome;

    public CursoDepartamento() {
    }

    public CursoDepartamento(Integer cursoDepartamentoId, String nome) {
        this.cursoDepartamentoId = cursoDepartamentoId;
        this.nome = nome;
    }

    public Integer getCursoDepartamentoId() {
        return cursoDepartamentoId;
    }

    public void setCursoDepartamentoId(Integer cursoDepartamentoId) {
        this.cursoDepartamentoId = cursoDepartamentoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
