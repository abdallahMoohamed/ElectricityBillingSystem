package fxml;

import electricitybillingsystem.switchPage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MainOperatorController implements Initializable {
    @FXML
   BorderPane mainPane;
    public void billis (ActionEvent e){
        switchPage.changePageToBill1(mainPane);
    }
    public void profile(ActionEvent e){
        switchPage.changePageToprooperator(mainPane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
