/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.francisnei.dado;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Francisnei_Lima
 */
@Entity
@Table(name = "entrada")
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEntrada")
    private Integer iDEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrada")
    private List<EntradaHasProduto> entradaHasProdutoList;
    @JoinColumn(name = "Fornecedor_IDFornecedor", referencedColumnName = "IDFornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorIDFornecedor;

    public Entrada() {
    }

    public Entrada(Integer iDEntrada) {
        this.iDEntrada = iDEntrada;
    }

    public Entrada(Integer iDEntrada, Date data) {
        this.iDEntrada = iDEntrada;
        this.data = data;
    }

    public Integer getIDEntrada() {
        return iDEntrada;
    }

    public void setIDEntrada(Integer iDEntrada) {
        this.iDEntrada = iDEntrada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<EntradaHasProduto> getEntradaHasProdutoList() {
        return entradaHasProdutoList;
    }

    public void setEntradaHasProdutoList(List<EntradaHasProduto> entradaHasProdutoList) {
        this.entradaHasProdutoList = entradaHasProdutoList;
    }

    public Fornecedor getFornecedorIDFornecedor() {
        return fornecedorIDFornecedor;
    }

    public void setFornecedorIDFornecedor(Fornecedor fornecedorIDFornecedor) {
        this.fornecedorIDFornecedor = fornecedorIDFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEntrada != null ? iDEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.iDEntrada == null && other.iDEntrada != null) || (this.iDEntrada != null && !this.iDEntrada.equals(other.iDEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Entrada[ iDEntrada=" + iDEntrada + " ]";
    }
    
}
