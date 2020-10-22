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
@Table(name = "estoque_has_produto")
@NamedQueries({
    @NamedQuery(name = "EstoqueHasProduto.findAll", query = "SELECT e FROM EstoqueHasProduto e")})
public class EstoqueHasProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstoqueHasProdutoPK estoqueHasProdutoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saldo")
    private int saldo;
    @JoinColumn(name = "Produto_IDProduto", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "Estoque_IDEstoque", referencedColumnName = "IDEstoque", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estoque estoque;

    public EstoqueHasProduto() {
    }

    public EstoqueHasProduto(EstoqueHasProdutoPK estoqueHasProdutoPK) {
        this.estoqueHasProdutoPK = estoqueHasProdutoPK;
    }

    public EstoqueHasProduto(EstoqueHasProdutoPK estoqueHasProdutoPK, int saldo) {
        this.estoqueHasProdutoPK = estoqueHasProdutoPK;
        this.saldo = saldo;
    }

    public EstoqueHasProduto(int estoqueIDEstoque, int produtoIDProduto) {
        this.estoqueHasProdutoPK = new EstoqueHasProdutoPK(estoqueIDEstoque, produtoIDProduto);
    }

    public EstoqueHasProdutoPK getEstoqueHasProdutoPK() {
        return estoqueHasProdutoPK;
    }

    public void setEstoqueHasProdutoPK(EstoqueHasProdutoPK estoqueHasProdutoPK) {
        this.estoqueHasProdutoPK = estoqueHasProdutoPK;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estoqueHasProdutoPK != null ? estoqueHasProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstoqueHasProduto)) {
            return false;
        }
        EstoqueHasProduto other = (EstoqueHasProduto) object;
        if ((this.estoqueHasProdutoPK == null && other.estoqueHasProdutoPK != null) || (this.estoqueHasProdutoPK != null && !this.estoqueHasProdutoPK.equals(other.estoqueHasProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.EstoqueHasProduto[ estoqueHasProdutoPK=" + estoqueHasProdutoPK + " ]";
    }
    
}
