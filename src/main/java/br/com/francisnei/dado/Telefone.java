/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.francisnei.dado;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "telefone")
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t")})
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTelefone")
    private Integer iDTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Telefone")
    private String telefone;
    @JoinColumn(name = "Pessoa", referencedColumnName = "IDPessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(Integer iDTelefone) {
        this.iDTelefone = iDTelefone;
    }

    public Telefone(Integer iDTelefone, String telefone) {
        this.iDTelefone = iDTelefone;
        this.telefone = telefone;
    }

    public Integer getIDTelefone() {
        return iDTelefone;
    }

    public void setIDTelefone(Integer iDTelefone) {
        this.iDTelefone = iDTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTelefone != null ? iDTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.iDTelefone == null && other.iDTelefone != null) || (this.iDTelefone != null && !this.iDTelefone.equals(other.iDTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Telefone[ iDTelefone=" + iDTelefone + " ]";
    }
    
}
