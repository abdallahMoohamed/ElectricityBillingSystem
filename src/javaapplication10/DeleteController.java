/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class DeleteController implements Initializable {
          @FXML
        private static TextField DeleteFile ;
        private static int meterCode; 
        

    public static void Delete(ActionEvent e) throws FileNotFoundException{
        String meter = DeleteFile.getText();
        File file = new File(""+meter+".txt");
        file.delete();
        
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
