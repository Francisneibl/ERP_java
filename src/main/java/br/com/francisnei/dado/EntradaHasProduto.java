/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.francisnei.dado;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Francisnei_Lima
 */
@Entity
@Table(name = "entrada_has_produto")
@NamedQueries({
    @NamedQuery(name = "EntradaHasProduto.findAll", query = "SELECT e FROM EntradaHasProduto e")})
public class EntradaHasProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntradaHasProdutoPK entradaHasProdutoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Preco")
    private float preco;
    @JoinColumn(name = "Produto_IDProduto", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "Entrada_IDEntrada", referencedColumnName = "IDEntrada", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Entrada entrada;

    public EntradaHasProduto() {
    }

    public EntradaHasProduto(EntradaHasProdutoPK entradaHasProdutoPK) {
        this.entradaHasProdutoPK = entradaHasProdutoPK;
    }

    public EntradaHasProduto(EntradaHasProdutoPK entradaHasProdutoPK, int quantidade, float preco) {
        this.entradaHasProdutoPK = entradaHasProdutoPK;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public EntradaHasProduto(int entradaIDEntrada, int produtoIDProduto) {
        this.entradaHasProdutoPK = new EntradaHasProdutoPK(entradaIDEntrada, produtoIDProduto);
    }

    public EntradaHasProdutoPK getEntradaHasProdutoPK() {
        return entradaHasProdutoPK;
    }

    public void setEntradaHasProdutoPK(EntradaHasProdutoPK entradaHasProdutoPK) {
        this.entradaHasProdutoPK = entradaHasProdutoPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entradaHasProdutoPK != null ? entradaHasProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaHasProduto)) {
            return false;
        }
        EntradaHasProduto other = (EntradaHasProduto) object;
        if ((this.entradaHasProdutoPK == null && other.entradaHasProdutoPK != null) || (this.entradaHasProdutoPK != null && !this.entradaHasProdutoPK.equals(other.entradaHasProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.EntradaHasProduto[ entradaHasProdutoPK=" + entradaHasProdutoPK + " ]";
    }
    
}
