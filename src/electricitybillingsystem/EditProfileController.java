package electricitybillingsystem;

import classes.SpecialMethods;
import classes.updateData;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;





public  class EditProfileController implements Initializable {

    @FXML
    private ChoiceBox<String> reigonChoiceBox;
    private String[] reigons = {"Helwan","Maadi","Maasara"};
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        reigonChoiceBox.getItems().addAll(reigons);
    }    
    
    @FXML
    private TextField updateName, updatePhone,updateEmail,updatePassword,updateAdderss;
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    public void updating(ActionEvent event) throws FileNotFoundException{
        String fname = updateName.getText();
        String fphone = updatePhone.getText();
        String femail = updateEmail.getText();
        String fpassword = updatePassword.getText();
        String fadderss = updateAdderss.getText();
        String freigon =reigonChoiceBox.getValue();
       
        // Handle some error by users
        if(EmailError(femail));
        else if(PhoneError(fphone));
        else{
             // to access data into file
            String code = DATA.meterCode;
            File file = SpecialMethods.getPathFile("Customers",code);
            updateData.Name(file, fname);
            updateData.Email(file, femail);
            updateData.Phone(file, fphone);
            updateData.Password(file, fpassword);
            updateData.Adderss(file, fadderss);


            if(freigon != null)
                updateData.Reigon(file, freigon);



            updateName.setText("");
            updatePhone.setText("");
            updateEmail.setText("");
            updatePassword.setText("");
            updateAdderss.setText("");
            showSaveWindow();
        }



        
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

    
    public boolean EmailError(String ema){
        
        boolean flag = false;
        if(!ema.isEmpty()){
            if(!ema.matches(".*@.*")){
                JOptionPane.showMessageDialog(null, "This email not has '@',Plaese Enter Real email!","Invalid Email",0);
                updateEmail.setText("");
                flag= true;
            }
        }
        return flag;
    }

    public boolean PhoneError(String ph){
        boolean flag = false ;
                if(!ph.isEmpty()){
            if(SpecialMethods.includeLetter(ph)){
                JOptionPane.showMessageDialog(null, "This phone incorrect.","Invalid Password",0);
                updatePhone.setText("");
                flag= true;
            }
        }
        return flag;
    }
    

    
}
