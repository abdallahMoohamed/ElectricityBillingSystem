/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication10;

import classes.SpecialMethods;
import classes.getData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Java2Controller implements Initializable {
    
    String fname, femail, fpassword, fphone;
    @FXML
    Label nameLabel, phoneLabel,emailLabel, password;
    
    private  void getInfo() throws FileNotFoundException{
        File file =SpecialMethods.getPathFile("Admin","1");
        fname = getData.Name(file);
        femail = getData.Email(file);
        fpassword = getData.Password(file);
        fphone = getData.Phone(file);  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getInfo();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Java2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        nameLabel.setText("Name :"+fname);
        emailLabel.setText("E_mail :"+femail);
        password.setText("Password :"+fpassword);
        phoneLabel.setText("Phone :"+fphone);
        
    }    
    
}
