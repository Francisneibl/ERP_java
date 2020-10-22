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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Francisnei_Lima
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descricao")
    private String descricao;
    @Size(max = 200)
    @Column(name = "Foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Preco")
    private float preco;
    @Size(max = 100)
    @Column(name = "Tamanho")
    private String tamanho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoCusto")
    private float precoCusto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduto")
    private int iDProduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<EntradaHasProduto> entradaHasProdutoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<EstoqueHasProduto> estoqueHasProdutoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<ProdutoHasSaida> produtoHasSaidaList;
    @JoinColumn(name = "Categoria", referencedColumnName = "IDCategoria")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "Cor", referencedColumnName = "ID")
    @ManyToOne
    private Cor cor;
    @JoinColumn(name = "Marca", referencedColumnName = "ID")
    @ManyToOne
    private Marca marca;
    @JoinColumn(name = "SubCategoria_idSubCategoria", referencedColumnName = "idSubCategoria")
    @ManyToOne(optional = false)
    private Subcategoria subCategoriaidSubCategoria;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, String descricao, float preco, float precoCusto, int iDProduto) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.precoCusto = precoCusto;
        this.iDProduto = iDProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public int getIDProduto() {
        return iDProduto;
    }

    public void setIDProduto(int iDProduto) {
        this.iDProduto = iDProduto;
    }

    public List<EntradaHasProduto> getEntradaHasProdutoList() {
        return entradaHasProdutoList;
    }

    public void setEntradaHasProdutoList(List<EntradaHasProduto> entradaHasProdutoList) {
        this.entradaHasProdutoList = entradaHasProdutoList;
    }

    public List<EstoqueHasProduto> getEstoqueHasProdutoList() {
        return estoqueHasProdutoList;
    }

    public void setEstoqueHasProdutoList(List<EstoqueHasProduto> estoqueHasProdutoList) {
        this.estoqueHasProdutoList = estoqueHasProdutoList;
    }

    public List<ProdutoHasSaida> getProdutoHasSaidaList() {
        return produtoHasSaidaList;
    }

    public void setProdutoHasSaidaList(List<ProdutoHasSaida> produtoHasSaidaList) {
        this.produtoHasSaidaList = produtoHasSaidaList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Subcategoria getSubCategoriaidSubCategoria() {
        return subCategoriaidSubCategoria;
    }

    public void setSubCategoriaidSubCategoria(Subcategoria subCategoriaidSubCategoria) {
        this.subCategoriaidSubCategoria = subCategoriaidSubCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.francisnei.dado.Produto[ id=" + id + " ]";
    }
    
}
