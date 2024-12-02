package computacao.paralela.produtor11.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Pedido implements Serializable {

    @Id
    private Integer id;
    private Date data;
    private Double preco;
    private Integer tipoCafe;
    private Double quantidade;

    public Pedido() {
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", preco=" + preco +
                ", tipoCafe=" + tipoCafe +
                ", quantidade=" + quantidade + '\'' +
                '}';
    }

    public Pedido(Integer id, Date data, Double preco, Integer tipoCafe, Double quantidade) {
        this.id = id;
        this.data = data;
        this.preco = preco;
        this.tipoCafe = tipoCafe;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getTipoCafe() {
        return tipoCafe;
    }

    public void setTipoCafe(Integer tipoCafe) {
        this.tipoCafe = tipoCafe;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}

