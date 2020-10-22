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
public class ProdutoHasSaidaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Produto_IDProduto")
    private int produtoIDProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saida_IDSaida")
    private int saidaIDSaida;

    public ProdutoHasSaidaPK() {
    }

    public ProdutoHasSaidaPK(int produtoIDProduto, int saidaIDSaida) {
        this.produtoIDProduto = produtoIDProduto;
        this.saidaIDSaida = saidaIDSaida;
    }

    public int getProdutoIDProduto() {
        return produtoIDProduto;
    }

    public void setProdutoIDProduto(int produtoIDProduto) {
        this.produtoIDProduto = produtoIDProduto;
    }

    public int getSaidaIDSaida() {
        return saidaIDSaida;
    }

    public void setSaidaIDSaida(int saidaIDSaida) {
        this.saidaIDSaida = saidaIDSaida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoIDProduto;
        hash += (int) saidaIDSaida;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoHasSaidaPK)) {
            return false;
        }
        ProdutoHasSaidaPK other = (ProdutoHasSaidaPK) object;
        if (this.produtoIDProduto != other.produtoIDProduto) {
            return false;
        }
        if (this.saidaIDSaida != other.saidaIDSaida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.ProdutoHasSaidaPK[ produtoIDProduto=" + produtoIDProduto + ", saidaIDSaida=" + saidaIDSaida + " ]";
    }
    
}
