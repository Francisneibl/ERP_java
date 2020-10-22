/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.francisnei.dado;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Francisnei_Lima
 */
@Embeddable
public class EstoqueHasProdutoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Estoque_IDEstoque")
    private int estoqueIDEstoque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Produto_IDProduto")
    private int produtoIDProduto;

    public EstoqueHasProdutoPK() {
    }

    public EstoqueHasProdutoPK(int estoqueIDEstoque, int produtoIDProduto) {
        this.estoqueIDEstoque = estoqueIDEstoque;
        this.produtoIDProduto = produtoIDProduto;
    }

    public int getEstoqueIDEstoque() {
        return estoqueIDEstoque;
    }

    public void setEstoqueIDEstoque(int estoqueIDEstoque) {
        this.estoqueIDEstoque = estoqueIDEstoque;
    }

    public int getProdutoIDProduto() {
        return produtoIDProduto;
    }

    public void setProdutoIDProduto(int produtoIDProduto) {
        this.produtoIDProduto = produtoIDProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estoqueIDEstoque;
        hash += (int) produtoIDProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstoqueHasProdutoPK)) {
            return false;
        }
        EstoqueHasProdutoPK other = (EstoqueHasProdutoPK) object;
        if (this.estoqueIDEstoque != other.estoqueIDEstoque) {
            return false;
        }
        if (this.produtoIDProduto != other.produtoIDProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.EstoqueHasProdutoPK[ estoqueIDEstoque=" + estoqueIDEstoque + ", produtoIDProduto=" + produtoIDProduto + " ]";
    }
    
}
