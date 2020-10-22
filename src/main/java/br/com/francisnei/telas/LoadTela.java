
package br.com.francisnei.telas;

import br.com.francisnei.main.MainApp;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe responsavel por trocar scene do stage atual
 * @author Francisnei_Lima
 * @since 17/11/19
 */
public class LoadTela{
    
    private Parent root;
    private Stage stageMain;
    
    public void loadScreen(String url){
        
        try {
            root = FXMLLoader.load(getClass().getResource(url));
            MainApp.getStage().setScene(new Scene(root));
            
        } catch (IOException e) {
            
        }
        
    }
    
    public Stage getStage(){
        return stageMain;
    }
    
}
