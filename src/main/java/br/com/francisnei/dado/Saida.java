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
@Table(name = "saida")
@NamedQueries({
    @NamedQuery(name = "Saida.findAll", query = "SELECT s FROM Saida s")})
public class Saida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSaida")
    private Integer iDSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saida")
    private List<ProdutoHasSaida> produtoHasSaidaList;

    public Saida() {
    }

    public Saida(Integer iDSaida) {
        this.iDSaida = iDSaida;
    }

    public Saida(Integer iDSaida, Date data) {
        this.iDSaida = iDSaida;
        this.data = data;
    }

    public Integer getIDSaida() {
        return iDSaida;
    }

    public void setIDSaida(Integer iDSaida) {
        this.iDSaida = iDSaida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ProdutoHasSaida> getProdutoHasSaidaList() {
        return produtoHasSaidaList;
    }

    public void setProdutoHasSaidaList(List<ProdutoHasSaida> produtoHasSaidaList) {
        this.produtoHasSaidaList = produtoHasSaidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSaida != null ? iDSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.iDSaida == null && other.iDSaida != null) || (this.iDSaida != null && !this.iDSaida.equals(other.iDSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Saida[ iDSaida=" + iDSaida + " ]";
    }
    
}
