package ifrs.pw3.model;

import android.content.ContentValues;

import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable {
    private int usuarioId;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String fone;
    private Date nascimento;
    private String endereco;
    private int cep;
    private int cidadeId;

    public Usuario() {
    }

    public Usuario(Integer usuarioId, String nome, String email, String senha, String cpf, String fone, Date nascimento, String endereco, int cep, int cidadeId) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.fone = fone;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.cidadeId = cidadeId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(int cidadeId) {
        this.cidadeId = cidadeId;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", fone='" + fone + '\'' +
                ", nascimento=" + nascimento +
                ", endereco='" + endereco + '\'' +
                ", cep=" + cep +
                ", cidadeId=" + cidadeId +
                '}';
    }
}
