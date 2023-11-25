
package javaapplication10;

import electricitybillingsystem.DATA;
import electricitybillingsystem.switchPage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController implements Initializable {

    @FXML
    BorderPane mainPane;
    public void profile(ActionEvent e){
        switchPage.changePageToPro(mainPane);
    }
    
    public void operator(ActionEvent e){        
        switchPage.changePageToOperator(mainPane);
    }

    Stage stage;
    Scene scene;
    Parent root;
    public void logout(ActionEvent e) throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login/sign_in.fxml"));
            root = loader.load();
            Image icon = new Image("/images/electricity.png");
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);   
            stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.getIcons().add(icon);
            stage.setTitle("EBS");
            stage.setResizable(false);
            stage.show();
            DATA.stageHome.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
