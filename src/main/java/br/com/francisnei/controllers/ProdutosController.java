/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.francisnei.controllers;

import br.com.francisnei.DAO.ConnectionFactory;
import br.com.francisnei.DAO.GenericDAO;

import br.com.francisnei.dado.Categoria;
import br.com.francisnei.dado.Cor;
import br.com.francisnei.dado.Marca;
import br.com.francisnei.dado.Produto;
import br.com.francisnei.dado.Subcategoria;
import br.com.francisnei.telas.LoadTela;
import br.com.francisnei.telas.LoadTelaModal;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Francisnei_Lima
 */
public class ProdutosController implements Initializable {

    @FXML
    private JFXButton buttonVoltar;
    @FXML
    private JFXButton buttonConfirmar;
    @FXML
    private JFXButton buttonCadastrarCategoria;
    @FXML
    private JFXButton buttonSubCategoria;
    @FXML
    private JFXButton buttonMarca;
    @FXML
    private JFXButton buttonCor;
    @FXML
    private JFXTextField textFieldCodigo;
    @FXML
    private JFXTextField textFieldReferencia;
    @FXML
    private JFXTextField textFieldDescricao;
    @FXML
    private JFXComboBox<Categoria> comboBoxCategoria;
    @FXML
    private JFXComboBox<Subcategoria> comboBoxSubCategoria;
    @FXML
    private JFXComboBox<Marca> comboBoxMarca;
    @FXML
    private JFXComboBox<Cor> comboBoxCor;
    @FXML
    private JFXTextField textFieldValorCusto;
    @FXML
    private JFXTextField textFieldEngargos;
    @FXML
    private JFXTextField textFieldMargemLucro;
    @FXML
    private JFXTextField textFieldPrecoVenda;
    
 
    private ObservableList<Categoria> categorias;
    private ObservableList<Subcategoria> subCategorias;
    private ObservableList<Marca> marcas;
    private ObservableList<Cor> cores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //carregarComboBox();
    }

    @FXML
    private void handleOnActionButtonVoltar(ActionEvent event) throws IOException {
        
       new LoadTela().loadScreen("/fxml/TelaPrincipal.fxml");
    }

    @FXML
    private void handleOnActionButtonConfirmar(ActionEvent event) {
        
       Produto produto = new Produto();
       produto.setCodigo(Integer.parseInt(textFieldReferencia.getText()));
       produto.setDescricao(textFieldDescricao.getText());
       produto.setCategoria(comboBoxCategoria.getSelectionModel().getSelectedItem());
       produto.setSubCategoriaidSubCategoria(comboBoxSubCategoria.getSelectionModel().getSelectedItem());
       produto.setMarca(comboBoxMarca.getSelectionModel().getSelectedItem());
       produto.setCor(comboBoxCor.getSelectionModel().getSelectedItem());
       produto.setPreco(Float.parseFloat(textFieldPrecoVenda.getText()));
       produto.setPrecoCusto(Float.parseFloat(textFieldValorCusto.getText()));
       //implementar tamanho na tela
       
//       GenericDAO<Produto> produtoDao = new GenericDAO<>();
//       produtoDao.saveOrUpdate(produto);
       
       
        
    }

    @FXML
    private void handleOnActionButtonCadastrarCategoria(ActionEvent event) {
        CadastroCategoriaController.setComando("categoria");
        new LoadTelaModal().load("/fxml/CadastrarCategoria.fxml");
       
    }

    @FXML
    private void handleOnActionSubCategoria(ActionEvent event) {
        CadastroCategoriaController.setComando("subcategoria");
        new LoadTelaModal().load("/fxml/CadastrarCategoria.fxml");
    }

    @FXML
    private void handleOnActionButtonMarca(ActionEvent event) {
        CadastroCategoriaController.setComando("marca");
        new LoadTelaModal().load("/fxml/CadastrarCategoria.fxml");
    }

    @FXML
    private void handleOnActionButtonCor(ActionEvent event) {
        CadastroCategoriaController.setComando("cor");
        new LoadTelaModal().load("/fxml/CadastrarCategoria.fxml");
    }
    
    public void carregarComboBox(){
        
        GenericDAO<Categoria> categoriaDao = new GenericDAO<>();
        categorias = FXCollections.observableArrayList(categoriaDao.list(Categoria.class));
        comboBoxCategoria.setItems(categorias);
        
        GenericDAO<Subcategoria> subCategoriaDao = new GenericDAO<>();
        subCategorias = FXCollections.observableArrayList(subCategoriaDao.list(Subcategoria.class));
        comboBoxSubCategoria.setItems(subCategorias);
        
        GenericDAO<Marca> marcaDao = new GenericDAO<>();
        marcas = FXCollections.observableArrayList(marcaDao.list(Marca.class));
        comboBoxMarca.setItems(marcas);
        
        GenericDAO<Cor> corDao = new GenericDAO<>();
        cores = FXCollections.observableArrayList(corDao.list(Cor.class));
        comboBoxCor.setItems(cores);
        
    }
    
    public void metodoPegarValorComboBox(){
        //Categoria categoria = comboBoxCategoria.getSelectionModel().getSelectedItem();
        //categoria.getId();
    }
   
        
}
