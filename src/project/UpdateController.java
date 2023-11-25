
package project;

import classes.SpecialMethods;
import classes.updateData;
import electricitybillingsystem.DATA;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class UpdateController implements Initializable {
  @FXML
  private TextField meterc;
  @FXML
  private TextField name;
  @FXML
  private TextField email;
  @FXML
  private TextField passward;
  @FXML
  private TextField phone;
  @FXML
  private TextField region;
  @FXML
  private TextField address;
   
  Stage stage ;
  Scene scene;
  Parent root;
  public void save(ActionEvent event)throws FileNotFoundException{
      
        String fname = name.getText();
        String fphone = phone.getText();
        String femail = email.getText();
        String fpassword = passward.getText();
        String fadderss = address.getText();
        String freigon =region.getText();


        String code = meterc.getText();
        File file = SpecialMethods.getPathFile("Customers",code);
        updateData.Name(file, fname);
        updateData.Email(file, femail);
        updateData.Phone(file, fphone);
        updateData.Password(file, fpassword);
        updateData.Adderss(file, fadderss);    
        updateData.Reigon(file, freigon);



        name.setText("");
        phone.setText("");
        email.setText("");
        passward.setText("");
        address.setText("");
        region.setText("");
        
        showSaveWindow();
    }



        
    
    
    public void showSaveWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("saved.fxml"));
            root = loader.load();
            scene = new Scene(root);
            Image icon = new Image("/images/check.png");

            stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.getIcons().add(icon);
            stage.setTitle("saved");
            stage.setResizable(false);
            stage.show();
        }
        catch(IOException e){
            System.out.println("can't load new window.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

}
