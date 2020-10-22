
package br.com.francisnei.controllers;

import br.com.francisnei.main.MainApp;
import br.com.francisnei.telas.LoadTela;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Francisnei_Lima
 */
public class TelaLoginController implements Initializable{

    @FXML
    private JFXTextField textFieldUsuario;
    @FXML
    private JFXPasswordField textFieldSenha;
    @FXML
    private JFXButton buttonSair;
    @FXML
    private JFXButton buttonLogin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }

    @FXML
    private void handleOnActionSair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleOnActionLogin(ActionEvent event) throws IOException, Exception {
        
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaPrincipal.fxml"));
       MainApp.getStage().setScene(new Scene(root));
       
    }
}
