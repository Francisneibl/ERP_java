package br.com.francisnei.main;

import br.com.francisnei.DAO.ConnectionFactory;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;


public class MainApp extends Application {

    private static Stage mainstage;
    
    @Override
    public void start(Stage stage){
        
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/fxml/TelaLogin.fxml"));
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            mainstage = stage;
            
            System.out.println("Certo");
        } catch (IOException e) {
            System.out.println("Errado");
            System.exit(0);
        }
        
    }

    public static void main(String[] args) {
       // launch(args);
       // EntityManager em = ConnectionFactory.getEntityManager();
    }
    
    public static Stage getStage(){
        return mainstage;
    }
}
