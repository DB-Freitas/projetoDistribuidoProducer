package computacao.paralela.produtor11;


import java.io.Serializable;

public class Dados implements Serializable {

    private Integer id;
    private String data;
    private Double quantidadeColhida;
    private Double produtividade;
    private String qualidade;

    public Dados() {
    }

    @Override
    public String toString() {
        return "Dados{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", quantidadeColhida=" + quantidadeColhida +
                ", produtividade=" + produtividade +
                ", qualidade='" + qualidade + '\'' +
                '}';
    }

    public Dados(int id, String data, double quantidadeColhida, double produtividade, String qualidade) {
        this.id = id;
        this.data = data;
        this.quantidadeColhida = quantidadeColhida;
        this.produtividade = produtividade;
        this.qualidade = qualidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getQuantidadeColhida() {
        return quantidadeColhida;
    }

    public void setQuantidadeColhida(double quantidadeColhida) {
        this.quantidadeColhida = quantidadeColhida;
    }

    public double getProdutividade() {
        return produtividade;
    }

    public void setProdutividade(double produtividade) {
        this.produtividade = produtividade;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }
}
