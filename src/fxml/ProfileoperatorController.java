package fxml;

import classes.SpecialMethods;
import classes.getData;
import electricitybillingsystem.DATA;
import electricitybillingsystem.switchPage;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class ProfileoperatorController implements Initializable {


    

    @FXML
    private Label id, name, email, password, phone, reigon;
    private String fname,fid,femail, fpassword, fphone, freigon;


    

    private  void getInfo() throws FileNotFoundException{
        File file =SpecialMethods.getPathFile("Operators",DATA.IdOperator);
        fname = getData.Name(file);
        femail = getData.Email(file);
        fpassword = getData.Password(file);
        fphone = getData.Phone(file);  
        freigon = getData.Reigon(file);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getInfo();
        } catch (FileNotFoundException ex) {
            System.out.println("Not Found File");
        }
        id.setText("Meter Code : "+fid);
        name.setText("Name :"+this.fname);
        email.setText("E_mail :"+femail);
        password.setText("Password :"+fpassword);
        phone.setText("Phone :"+fphone);
        reigon.setText("Reigon :"+freigon);

        
    } 
    
}
