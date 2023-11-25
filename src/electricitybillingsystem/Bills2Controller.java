package electricitybillingsystem;

import classes.SpecialMethods;
import classes.getData;
import classes.updateData;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


public class Bills2Controller implements Initializable {
    @FXML
    private Label consumptionLabel, costLabel, yearLabel,monthLabel;
    
    @FXML
    private BorderPane mainPane;
    private Stage stage;
    private Parent root;
    private Scene scene;
    public void postponing(ActionEvent e) throws FileNotFoundException{
        if(DATA.noOfFalseCheck >= 3){
            JOptionPane.showMessageDialog(null, "If you do not pay the bill for the previous"
                    + " three months, your house will cut off electricity !", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{    
            switchPage.changePageToBill1(mainPane);
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
    
    public void pay(ActionEvent e) throws FileNotFoundException{

        String MC = DATA.MC;
        File file =SpecialMethods.getPathFile("Customers",MC);
        int size = getData.countMonthlyBills(file);
        
        if( size>1 && getData.Check(size-1, file) == false){
            showPreviousMonthWindow();
        }
        
        switchPage.changePageToPay(mainPane);    
        
    }
    public void showPreviousMonthWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("perviousMonth.fxml"));
            root = loader.load();
            scene = new Scene(root);
            Image icon = new Image("/images/login.png");

            stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.getIcons().add(icon);
            stage.setTitle("PreviousMonths");
            stage.setResizable(false);
            stage.show();
        }
        catch(IOException e){
            System.out.println("can't load new window.");
        }
    }
    public int countOfFalseCheck() throws FileNotFoundException{
        File file = SpecialMethods.getPathFile("Customers",DATA.MC);
        int count=0;
        int size = getData.countMonthlyBills(file);
        for(int i=1 ; i<= size ; i++){
            if(getData.Check(i, file)== false)
                count++;
        }
        DATA.noOfFalseCheck = count;
        return count;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            countOfFalseCheck();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bills2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        File file = SpecialMethods.getPathFile("Customers",DATA.MC);
        int size=0,mdate=0,myear=0;
        try {
            size = getData.countMonthlyBills(file);
            mdate = getData.DateMonth(size, file);
            myear = getData.DateYear(size, file);
 
        } catch (FileNotFoundException ex) {
            System.out.println("not found file");
        }

        
        consumptionLabel.setText(":  "+DATA.Consumption+" KWh");
        costLabel.setText(": "+Float.parseFloat(DATA.Cost)+" Pounds");
        monthLabel.setText(": "+mdate);
        yearLabel.setText(": "+myear);

    }    


    
}
