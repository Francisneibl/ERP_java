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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Francisnei_Lima
 */
@Entity
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFornecedor")
    private Integer iDFornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedorIDFornecedor")
    private List<Entrada> entradaList;
    @JoinColumn(name = "Pessoa_IDPessoa", referencedColumnName = "IDPessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoaIDPessoa;

    public Fornecedor() {
    }

    public Fornecedor(Integer iDFornecedor) {
        this.iDFornecedor = iDFornecedor;
    }

    public Integer getIDFornecedor() {
        return iDFornecedor;
    }

    public void setIDFornecedor(Integer iDFornecedor) {
        this.iDFornecedor = iDFornecedor;
    }

    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    public Pessoa getPessoaIDPessoa() {
        return pessoaIDPessoa;
    }

    public void setPessoaIDPessoa(Pessoa pessoaIDPessoa) {
        this.pessoaIDPessoa = pessoaIDPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFornecedor != null ? iDFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.iDFornecedor == null && other.iDFornecedor != null) || (this.iDFornecedor != null && !this.iDFornecedor.equals(other.iDFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Fornecedor[ iDFornecedor=" + iDFornecedor + " ]";
    }
    
}
