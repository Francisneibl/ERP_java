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
@Table(name = "pessoajuridica")
@NamedQueries({
    @NamedQuery(name = "Pessoajuridica.findAll", query = "SELECT p FROM Pessoajuridica p")})
public class Pessoajuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPessoaJuridica")
    private Integer iDPessoaJuridica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CNPJ")
    private String cnpj;
    @JoinColumn(name = "Pessoa", referencedColumnName = "IDPessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Pessoajuridica() {
    }

    public Pessoajuridica(Integer iDPessoaJuridica) {
        this.iDPessoaJuridica = iDPessoaJuridica;
    }

    public Pessoajuridica(Integer iDPessoaJuridica, String cnpj) {
        this.iDPessoaJuridica = iDPessoaJuridica;
        this.cnpj = cnpj;
    }

    public Integer getIDPessoaJuridica() {
        return iDPessoaJuridica;
    }

    public void setIDPessoaJuridica(Integer iDPessoaJuridica) {
        this.iDPessoaJuridica = iDPessoaJuridica;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        hash += (iDPessoaJuridica != null ? iDPessoaJuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoajuridica)) {
            return false;
        }
        Pessoajuridica other = (Pessoajuridica) object;
        if ((this.iDPessoaJuridica == null && other.iDPessoaJuridica != null) || (this.iDPessoaJuridica != null && !this.iDPessoaJuridica.equals(other.iDPessoaJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Pessoajuridica[ iDPessoaJuridica=" + iDPessoaJuridica + " ]";
    }
    
}
