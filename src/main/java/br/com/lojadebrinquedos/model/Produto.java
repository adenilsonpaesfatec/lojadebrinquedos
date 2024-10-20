package br.com.lojadebrinquedos.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pro_id")
    private int id;

    @Column(name="pro_descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name="cat_id")
    private Categoria categoria;

    @Column(name="pro_marca")
    private String marca;

    @Column(name="pro_imagem")
    private String imagem;

    @Column(name="pro_valor")
    private BigDecimal valor;

    @Column(name="pro_detalhes")
    private String detalhes;

    // Construtores
    public Produto() {
    }

    public Produto(int id, String descricao, Categoria categoria, String marca, String imagem, BigDecimal valor, String detalhes) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.marca = marca;
        this.imagem = imagem;
        this.valor = valor;
        this.detalhes = detalhes;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}