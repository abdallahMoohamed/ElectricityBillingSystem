package javaapplication10;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Java3Controller implements Initializable {

    
        
        @FXML
        private static TextField NameField ;
        @FXML
        private static TextField PhoneField ;
        @FXML
        private static TextField EmailField ;
        @FXML
        private static TextField PasswordField ;
        
        
         
        String Name = NameField.getText();
        String Phone = PhoneField.getText();
        String Email = EmailField.getText();
        String Password = PasswordField.getText();
        public static void Save(){
            //Update.Name(Name,);
            //Update.Phone(Phone , );
            //Update.Email(Email , );
            //Update.Password(Password , );
            
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
