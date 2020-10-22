
package br.com.francisnei.controllers;


import br.com.francisnei.DAO.ConnectionFactory;
import br.com.francisnei.DAO.GenericDAO;
import br.com.francisnei.dado.Categoria;
import br.com.francisnei.dado.Cor;
import br.com.francisnei.dado.Marca;
import br.com.francisnei.dado.Subcategoria;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import org.bouncycastle.crypto.tls.ContentType;

/**
 *
 * @author Francisnei_Lima
 */
public class CadastroCategoriaController implements Initializable{
    
    private static String comando;
    @FXML
    private JFXTextField textFieldDescricao;
    @FXML
    private JFXButton buttonCadastrar;
    @FXML
    private JFXButton buttonCancelar;
    
    private EntityManager em;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void handleOnActionButtonCadastrar(ActionEvent event) {
        
        em = ConnectionFactory.getEntityManager();
        System.out.println(comando);
        
       /* switch(comando){
            case "categoria":
                Categoria categoria = new Categoria();
                categoria.setDescricao(textFieldDescricao.getText());
                
                GenericDAO<Categoria> categoriaDao = new GenericDAO<>();
                categoriaDao.saveOrUpdate(categoria);
                textFieldDescricao.clear();
                break;
            case "subcategoria":
                Subcategoria subcategoria = new Subcategoria();
                subcategoria.setDescricao(textFieldDescricao.getText());
                
                GenericDAO<Subcategoria> subCategoriaDao = new GenericDAO<>();
                subCategoriaDao.saveOrUpdate(subcategoria);
                textFieldDescricao.clear();
                
                break;
            case "cor":
                Cor cor = new Cor();
                cor.setDescricao(textFieldDescricao.getText());
                
                GenericDAO<Cor> corDao = new GenericDAO<>();
                corDao.saveOrUpdate(cor);
                textFieldDescricao.clear();
                break;
            case "marca":
                Marca marca = new Marca();
                marca.setDescricao(textFieldDescricao.getText());
                
                GenericDAO<Marca> marcaDao = new GenericDAO<>();
                marcaDao.saveOrUpdate(marca);
                
                textFieldDescricao.clear();
                break;
        }*/
        
    }

    @FXML
    private void handleOnActionCancelar(ActionEvent event) {
        Stage stage = (Stage)buttonCancelar.getScene().getWindow();
        stage.close();
    }
    
    public static void setComando(String comando){
       CadastroCategoriaController.comando = comando;
    }
    
}
