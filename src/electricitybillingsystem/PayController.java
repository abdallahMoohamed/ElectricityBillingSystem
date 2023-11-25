package electricitybillingsystem;

import classes.SpecialMethods;
import classes.getData;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


public class PayController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private TextField cardNumberText;
    @FXML
    private PasswordField cardPasswordText;
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    public void submit(ActionEvent e) throws FileNotFoundException{
        String CN = cardNumberText.getText();
        String CP = cardPasswordText.getText();

        if(CardNumberError1(CN));
        else if(CardNumberError2(CN));
        else if(CardPasswordError(CP));
        else{
            casesOfTrueCheck();
            showSaveWindow();
            switchPage.changePageToBill1(mainPane);
        }
    }
    
    private boolean CardNumberError1(String s){
        boolean flag = false;     
        if(SpecialMethods.includeLetter(s) || s.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error, Please Enter Integer Numbers For Card Number !", "Invalid Card Number",JOptionPane.ERROR_MESSAGE);
            cardNumberText.setText("");            
            flag = true;
        }

        return flag;
    }
    private boolean CardNumberError2(String s){
        boolean flag = false;
        if(s.length()!=14){
            JOptionPane.showMessageDialog(null, "Error, Your card number is incorrect.","Invalid Card Number",JOptionPane.ERROR_MESSAGE);
            cardNumberText.setText("");            
            flag = true;
        }
        return flag;
    }
    private boolean CardPasswordError(String s){
        boolean flag = false;
        if(s.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, Password is empty.","Invalid Card Password",JOptionPane.ERROR_MESSAGE);                   
            flag = true;
        }
        return flag;
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
    
    public void sendTrueCheckToFile(int i) throws FileNotFoundException{
        String MC = DATA.MC;
        File file = SpecialMethods.getPathFile("Customers",MC);
        updateData.Check(file, "true", i);
    }
    
    public void casesOfTrueCheck() throws FileNotFoundException{
        String MC = DATA.MC;
        File file = SpecialMethods.getPathFile("Customers",MC);
        int size = getData.countMonthlyBills(file);
        if(DATA.perviousMonth == true){
            for(int i=DATA.startLoop ; i<= DATA.endLoop ; i++)
                updateData.Check(file, "true", i);
        }
        else if(getData.Check(size, file) == false && size > 1){
            sendTrueCheckToFile(size-1);
        }
        else
            sendTrueCheckToFile(size);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
