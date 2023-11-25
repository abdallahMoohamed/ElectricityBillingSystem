
package javaapplication10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class EditCustomerController implements Initializable {
        @FXML
        private Label Region ;
        @FXML
        private ChoiceBox <String> ChoiceBox;
        private String[] types = {"Maddie" , "Massara" , "Helwan"};

        public static void CustomerInformation(String name, String phone, String email, String password, String reigon, String adderss, File file) throws FileNotFoundException{

        try(PrintWriter output = new PrintWriter(file)){
            output.println("name: "+name);
            output.println("phone: "+phone);
            output.println("email: "+email);
            output.println("password: "+password);
            output.println("reigon: "+reigon);
            output.println("adderss: "+adderss);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChoiceBox.getItems().addAll(types);
    }    
    
}
