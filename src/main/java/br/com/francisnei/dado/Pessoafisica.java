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
@Table(name = "pessoafisica")
@NamedQueries({
    @NamedQuery(name = "Pessoafisica.findAll", query = "SELECT p FROM Pessoafisica p")})
public class Pessoafisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPessoafisica")
    private Integer iDPessoafisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "CPF")
    private String cpf;
    @JoinColumn(name = "Pessoa", referencedColumnName = "IDPessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Pessoafisica() {
    }

    public Pessoafisica(Integer iDPessoafisica) {
        this.iDPessoafisica = iDPessoafisica;
    }

    public Pessoafisica(Integer iDPessoafisica, String cpf) {
        this.iDPessoafisica = iDPessoafisica;
        this.cpf = cpf;
    }

    public Integer getIDPessoafisica() {
        return iDPessoafisica;
    }

    public void setIDPessoafisica(Integer iDPessoafisica) {
        this.iDPessoafisica = iDPessoafisica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        hash += (iDPessoafisica != null ? iDPessoafisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoafisica)) {
            return false;
        }
        Pessoafisica other = (Pessoafisica) object;
        if ((this.iDPessoafisica == null && other.iDPessoafisica != null) || (this.iDPessoafisica != null && !this.iDPessoafisica.equals(other.iDPessoafisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Pessoafisica[ iDPessoafisica=" + iDPessoafisica + " ]";
    }
    
}
