package Login;

import classes.SpecialMethods;
import electricitybillingsystem.switchPage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;


public class SignUpController implements Initializable {


    @FXML
    private BorderPane mainPane;
    @FXML
    private TextField nameText, adderssText, emailText, pass1Text, pass2Text, phoneText;
    private String name =nameText.getText();
    private String adderss =adderssText.getText();
    private String email =emailText.getText();
    private String pass1 =pass1Text.getText();
    private String pass2 =pass2Text.getText();
    private String phone =phoneText.getText();

    @FXML
    private ChoiceBox <String> ChoiceBox_region;
    private String[] regions = {"Helwan","Maasara","Maadie"};
      
    public void Submit(ActionEvent event){
        //switchPage.changePageToSignIn(mainPane);

//        if(passwordError());
//        else if(EmailError());        
//        else{
 //       }
    }
//    public boolean passwordError(){
//        boolean flag = false;
//        if(!pass2.equals(pass1)){
//            JOptionPane.showMessageDialog(null, "The Confirm Pass not equal first pass", "warning", JOptionPane.WARNING_MESSAGE);
//            pass2Text.setText("");
//            return flag;
//        }
//        return flag;
//    }
//    public boolean EmailError(){
//        boolean flag = false;
//        if(!email.isEmpty()){
//            if(!email.matches(".*@.*")){
//                JOptionPane.showMessageDialog(null, "This email not has '@',Plaese Enter Real email!","Invalid Email",0);
//                emailText.setText("");
//                flag= true;
//            }
//        }
//        return flag;
//    }
//    public boolean PhoneError(){
//        boolean flag = false ;
//                if(!phone.isEmpty()){
//            if(SpecialMethods.includeLetter(phone)){
//                JOptionPane.showMessageDialog(null, "This phone incorrect.","Invalid Password",0);
//                phoneText.setText("");
//                flag= true;
//            }
//        }
//        return flag;
//    }    
//    public boolean FullDataError(){
//        boolean flag = false ;        
//        if(adderss.isEmpty()|| name.isEmpty() || email.isEmpty() || pass1.isEmpty() || pass2.isEmpty() || phone.isEmpty()){
//                JOptionPane.showMessageDialog(null, "One or more filed is empty","Error Data",0);
//                flag = true;
//        }
//        return flag;
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChoiceBox_region.getItems().addAll(regions);
      
    }      
    
}
