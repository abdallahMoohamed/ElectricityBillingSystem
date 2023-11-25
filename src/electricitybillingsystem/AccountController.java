package electricitybillingsystem;

import classes.SpecialMethods;
import classes.getData;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class AccountController implements Initializable {

    @FXML
    private Label meterCode, name, email, password, phone, reigon, adderss;
    private String fname, fmeterCode=DATA.meterCode,femail, fpassword, fphone, freigon, fadderss ;
    
    @FXML
    private BorderPane mainPane;
       
    @FXML
    public void editProfile(ActionEvent event){        
        switchPage.changePageToEditProfile(mainPane);
    }
    

    private  void getInfo() throws FileNotFoundException{
        File file =SpecialMethods.getPathFile("Customers",fmeterCode);
        fname = getData.Name(file);
        femail = getData.Email(file);
        fpassword = getData.Password(file);
        fphone = getData.Phone(file);  
        freigon = getData.Reigon(file);
        fadderss = getData.Adderss(file);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getInfo();
        } catch (FileNotFoundException ex) {
            System.out.println("Not Found File");
        }
        meterCode.setText("Meter Code : "+fmeterCode);
        name.setText("Name :"+this.fname);
        email.setText("E_mail :"+femail);
        password.setText("Password :"+fpassword);
        phone.setText("Phone :"+fphone);
        reigon.setText("Reigon :"+freigon);
        adderss.setText("Adderss :"+fadderss);
        
    }  
    
}
