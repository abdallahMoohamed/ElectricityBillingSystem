
package project;

import electricitybillingsystem.switchPage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javax.lang.model.SourceVersion;
public class EditCustomerAdminController implements Initializable {
   
    @FXML
    private BorderPane mainpane;

    @FXML
    void addbtn(ActionEvent event) {
        
    }

    @FXML
    void deletebtn(ActionEvent event) {

    }

    @FXML
    void searchbtn(ActionEvent event) {
        switchPage.changePageToSearch(mainpane);
    }

    @FXML
    void updatabtn(ActionEvent event) {   
        switchPage.changePageToUpdate(mainpane);
    
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       try {
//         getInfo();
//       }catch(FileNotFoundException ex){
//         System.out.println("Not Found File");
//       }
  }    
//    



}
