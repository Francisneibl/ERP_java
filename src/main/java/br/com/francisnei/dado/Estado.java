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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "estado")
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEstado")
    private Integer iDEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "UF")
    private String uf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoidEstado")
    private List<Cidade> cidadeList;
    @JoinColumn(name = "Pais_idPais", referencedColumnName = "IDPais")
    @ManyToOne(optional = false)
    private Pais paisidPais;

    public Estado() {
    }

    public Estado(Integer iDEstado) {
        this.iDEstado = iDEstado;
    }

    public Estado(Integer iDEstado, String nome, String uf) {
        this.iDEstado = iDEstado;
        this.nome = nome;
        this.uf = uf;
    }

    public Integer getIDEstado() {
        return iDEstado;
    }

    public void setIDEstado(Integer iDEstado) {
        this.iDEstado = iDEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Cidade> getCidadeList() {
        return cidadeList;
    }

    public void setCidadeList(List<Cidade> cidadeList) {
        this.cidadeList = cidadeList;
    }

    public Pais getPaisidPais() {
        return paisidPais;
    }

    public void setPaisidPais(Pais paisidPais) {
        this.paisidPais = paisidPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEstado != null ? iDEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.iDEstado == null && other.iDEstado != null) || (this.iDEstado != null && !this.iDEstado.equals(other.iDEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Estado[ iDEstado=" + iDEstado + " ]";
    }
    
}
