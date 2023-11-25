package electricitybillingsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ViewTotalCostAndConsController implements Initializable {


    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    Label TotalConstLabel,totalConsumLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalConsumLabel.setText(": "+DATA.totalConsumption+" KWh");
        TotalConstLabel.setText(": "+DATA.totalCost+" Pounds");
    }    
    
}
