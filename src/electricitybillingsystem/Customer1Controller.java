package electricitybillingsystem;

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



public class Customer1Controller implements Initializable {
    

    @FXML
    private BorderPane mainPane;
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
    // to view Account page
    public void AccountPage(ActionEvent e){
        switchPage.changePageToAccount(mainPane);
    }
    // to view Bills page
    public void BillsPage(ActionEvent e){
        switchPage.changePageToBill1(mainPane);  
    }
    
    public void Home(ActionEvent e){
        switchPage.changePageToHomeCustomer(mainPane);
    }
    // to view history pag
    public void HistoryPage(ActionEvent e){
        switchPage.changePageToHisotry(mainPane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    

}
