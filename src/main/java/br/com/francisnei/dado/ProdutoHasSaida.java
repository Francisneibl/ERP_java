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
import javax.validation.constraints.Size;

/**
 *
 * @author Francisnei_Lima
 */
@Entity
@Table(name = "produto_has_saida")
@NamedQueries({
    @NamedQuery(name = "ProdutoHasSaida.findAll", query = "SELECT p FROM ProdutoHasSaida p")})
public class ProdutoHasSaida implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoHasSaidaPK produtoHasSaidaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
    @Size(max = 100)
    @Column(name = "Observacao")
    private String observacao;
    @JoinColumn(name = "Produto_IDProduto", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "Saida_IDSaida", referencedColumnName = "IDSaida", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Saida saida;

    public ProdutoHasSaida() {
    }

    public ProdutoHasSaida(ProdutoHasSaidaPK produtoHasSaidaPK) {
        this.produtoHasSaidaPK = produtoHasSaidaPK;
    }

    public ProdutoHasSaida(ProdutoHasSaidaPK produtoHasSaidaPK, int quantidade) {
        this.produtoHasSaidaPK = produtoHasSaidaPK;
        this.quantidade = quantidade;
    }

    public ProdutoHasSaida(int produtoIDProduto, int saidaIDSaida) {
        this.produtoHasSaidaPK = new ProdutoHasSaidaPK(produtoIDProduto, saidaIDSaida);
    }

    public ProdutoHasSaidaPK getProdutoHasSaidaPK() {
        return produtoHasSaidaPK;
    }

    public void setProdutoHasSaidaPK(ProdutoHasSaidaPK produtoHasSaidaPK) {
        this.produtoHasSaidaPK = produtoHasSaidaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoHasSaidaPK != null ? produtoHasSaidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoHasSaida)) {
            return false;
        }
        ProdutoHasSaida other = (ProdutoHasSaida) object;
        if ((this.produtoHasSaidaPK == null && other.produtoHasSaidaPK != null) || (this.produtoHasSaidaPK != null && !this.produtoHasSaidaPK.equals(other.produtoHasSaidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.ProdutoHasSaida[ produtoHasSaidaPK=" + produtoHasSaidaPK + " ]";
    }
    
}
