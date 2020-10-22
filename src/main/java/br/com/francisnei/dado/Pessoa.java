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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPessoa")
    private Integer iDPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TipoPessoa")
    private short tipoPessoa;
    @JoinTable(name = "cliente", joinColumns = {
        @JoinColumn(name = "Pessoa_IDPessoa", referencedColumnName = "IDPessoa")}, inverseJoinColumns = {
        @JoinColumn(name = "Pessoa_IDPessoa", referencedColumnName = "IDPessoa")})
    @ManyToMany
    private List<Pessoa> pessoaList;
    @ManyToMany(mappedBy = "pessoaList")
    private List<Pessoa> pessoaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Telefone> telefoneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Endereco> enderecoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Pessoafisica> pessoafisicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Pessoajuridica> pessoajuridicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaIDPessoa")
    private List<Fornecedor> fornecedorList;

    public Pessoa() {
    }

    public Pessoa(Integer iDPessoa) {
        this.iDPessoa = iDPessoa;
    }

    public Pessoa(Integer iDPessoa, String nome, short tipoPessoa) {
        this.iDPessoa = iDPessoa;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public Integer getIDPessoa() {
        return iDPessoa;
    }

    public void setIDPessoa(Integer iDPessoa) {
        this.iDPessoa = iDPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(short tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public List<Pessoa> getPessoaList1() {
        return pessoaList1;
    }

    public void setPessoaList1(List<Pessoa> pessoaList1) {
        this.pessoaList1 = pessoaList1;
    }

    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public List<Pessoafisica> getPessoafisicaList() {
        return pessoafisicaList;
    }

    public void setPessoafisicaList(List<Pessoafisica> pessoafisicaList) {
        this.pessoafisicaList = pessoafisicaList;
    }

    public List<Pessoajuridica> getPessoajuridicaList() {
        return pessoajuridicaList;
    }

    public void setPessoajuridicaList(List<Pessoajuridica> pessoajuridicaList) {
        this.pessoajuridicaList = pessoajuridicaList;
    }

    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPessoa != null ? iDPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.iDPessoa == null && other.iDPessoa != null) || (this.iDPessoa != null && !this.iDPessoa.equals(other.iDPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Pessoa[ iDPessoa=" + iDPessoa + " ]";
    }
    
}
