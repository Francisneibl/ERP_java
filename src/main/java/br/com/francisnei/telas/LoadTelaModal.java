
package br.com.francisnei.telas;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Francisnei_Lima
 */
public class LoadTelaModal {
    
    public void load(String tela){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(tela));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            
        } catch (IOException e) {
        }
    }
    
}
