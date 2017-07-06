package ifrs.pw3.model;

import java.util.Date;

public class Enquete {

    private int enqueteId;
    private String data;
    private String pergunta;
    private String opcao1;
    private String opcao2;
    private String opcao3;
    private int opcao1Quantidade;
    private int opcao2Quantidade;
    private int opcao3Quantidade;

    public Enquete() {
    }

    public Enquete(int enqueteId, String data, String pergunta, String opcao1, String opcao2, String opcao3, int opcao1Quantidade, int opcao2Quantidade, int opcao3Quantidade) {
        this.enqueteId = enqueteId;
        this.data = data;
        this.pergunta = pergunta;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.opcao3 = opcao3;
        this.opcao1Quantidade = opcao1Quantidade;
        this.opcao2Quantidade = opcao2Quantidade;
        this.opcao3Quantidade = opcao3Quantidade;
    }

    public int getEnqueteId() {
        return enqueteId;
    }

    public void setEnqueteId(int enqueteId) {
        this.enqueteId = enqueteId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getOpcao1() {
        return opcao1;
    }

    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }

    public String getOpcao2() {
        return opcao2;
    }

    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }

    public String getOpcao3() {
        return opcao3;
    }

    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }

    public int getOpcao1Quantidade() {
        return opcao1Quantidade;
    }

    public void setOpcao1Quantidade(int opcao1Quantidade) {
        this.opcao1Quantidade = opcao1Quantidade;
    }

    public int getOpcao2Quantidade() {
        return opcao2Quantidade;
    }

    public void setOpcao2Quantidade(int opcao2Quantidade) {
        this.opcao2Quantidade = opcao2Quantidade;
    }

    public int getOpcao3Quantidade() {
        return opcao3Quantidade;
    }

    public void setOpcao3Quantidade(int opcao3Quantidade) {
        this.opcao3Quantidade = opcao3Quantidade;
    }

    @Override
    public String toString() {
        return "Enquete{" +
                "enqueteId=" + enqueteId +
                ", data='" + data + '\'' +
                ", pergunta='" + pergunta + '\'' +
                ", opcao1='" + opcao1 + '\'' +
                ", opcao2='" + opcao2 + '\'' +
                ", opcao3='" + opcao3 + '\'' +
                ", opcao1Quantidade=" + opcao1Quantidade +
                ", opcao2Quantidade=" + opcao2Quantidade +
                ", opcao3Quantidade=" + opcao3Quantidade +
                '}';
    }
}
