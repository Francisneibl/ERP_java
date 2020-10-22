/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.francisnei.dado;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Francisnei_Lima
 */
@Entity
@Table(name = "estoque")
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e")})
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEstoque")
    private Integer iDEstoque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estoque")
    private List<EstoqueHasProduto> estoqueHasProdutoList;

    public Estoque() {
    }

    public Estoque(Integer iDEstoque) {
        this.iDEstoque = iDEstoque;
    }

    public Estoque(Integer iDEstoque, String nome) {
        this.iDEstoque = iDEstoque;
        this.nome = nome;
    }

    public Integer getIDEstoque() {
        return iDEstoque;
    }

    public void setIDEstoque(Integer iDEstoque) {
        this.iDEstoque = iDEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EstoqueHasProduto> getEstoqueHasProdutoList() {
        return estoqueHasProdutoList;
    }

    public void setEstoqueHasProdutoList(List<EstoqueHasProduto> estoqueHasProdutoList) {
        this.estoqueHasProdutoList = estoqueHasProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEstoque != null ? iDEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.iDEstoque == null && other.iDEstoque != null) || (this.iDEstoque != null && !this.iDEstoque.equals(other.iDEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Estoque[ iDEstoque=" + iDEstoque + " ]";
    }
    
}
