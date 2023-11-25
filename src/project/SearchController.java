
package project;

import classes.getData;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class SearchController implements Initializable {
    @FXML
    private TextField search;
    @FXML
    private Label meterCode;
    @FXML
    private Label name;
    @FXML
    private Label email;
    @FXML
    private Label password;
    @FXML
    private Label phone;
    @FXML
    private Label reigon;
    @FXML
    private Label adderss;
          String fmeterCode; 
          String fname ;
          String femail;
          String fpassword;
          String fphone;
          String freigon;
          String fadderss;
  public void search(ActionEvent event) throws FileNotFoundException{
      String element = search.getText();
      File file =new File("D:\\magdy\\Project\\src\\Files\\"+ element+".fxml");
      if(file.exists()){
        fname = getData.Name(file);
        String femail = getData.Email(file);
        String fpassward = getData.Password(file);
        String fphone = getData.Phone(file);
        String freigun = getData.Reigon(file);
        String faddress = getData.Adderss(file);
        
      }
      else{
       System.out.println("File is not Found");
      }
      getData.Name(file);
      System.out.println(getData.Adderss(file));
       meterCode.setText("Meter Code : "+fmeterCode);
       name.setText("Name :"+fname);
       email.setText("E_mail :"+femail);
       password.setText("Password :"+fpassword);
       phone.setText("Phone :"+fphone);
       reigon.setText("Reigon :"+freigon);
       adderss.setText("Adderss :"+fadderss);
    }
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
