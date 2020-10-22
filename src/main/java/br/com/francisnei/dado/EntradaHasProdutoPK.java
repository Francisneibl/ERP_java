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
public class EntradaHasProdutoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Entrada_IDEntrada")
    private int entradaIDEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Produto_IDProduto")
    private int produtoIDProduto;

    public EntradaHasProdutoPK() {
    }

    public EntradaHasProdutoPK(int entradaIDEntrada, int produtoIDProduto) {
        this.entradaIDEntrada = entradaIDEntrada;
        this.produtoIDProduto = produtoIDProduto;
    }

    public int getEntradaIDEntrada() {
        return entradaIDEntrada;
    }

    public void setEntradaIDEntrada(int entradaIDEntrada) {
        this.entradaIDEntrada = entradaIDEntrada;
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
        hash += (int) entradaIDEntrada;
        hash += (int) produtoIDProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaHasProdutoPK)) {
            return false;
        }
        EntradaHasProdutoPK other = (EntradaHasProdutoPK) object;
        if (this.entradaIDEntrada != other.entradaIDEntrada) {
            return false;
        }
        if (this.produtoIDProduto != other.produtoIDProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.EntradaHasProdutoPK[ entradaIDEntrada=" + entradaIDEntrada + ", produtoIDProduto=" + produtoIDProduto + " ]";
    }
    
}
