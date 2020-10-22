
package br.com.francisnei.controllers;

import br.com.francisnei.telas.LoadTela;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Francisnei_Lima
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private ImageView buttonHome;
    @FXML
    private MenuButton menuProdutos;
    @FXML
    private MenuButton menuVendas;
    @FXML
    private MenuButton menuRelatorios;
    @FXML
    private JFXButton buttonLogin;
    @FXML
    private MenuItem menuItemCadastrarProdutos;
    @FXML
    private MenuItem menuItemListarProdutos;
    
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void handleCadastrarProdutos(ActionEvent event) throws IOException {

        new LoadTela().loadScreen("/fxml/Produtos.fxml");
    }

    @FXML
    private void handleListarProdutos(ActionEvent event) {
    }
    
    public AnchorPane getAnchorPane(){
        return this.anchorPanePrincipal;
    }
    
    
}
