package electricitybillingsystem;

import classes.Operator;
import classes.SpecialMethods;
import classes.getData;
import classes.insertData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.Icon;
import javax.swing.JOptionPane;


public class BillsController implements Initializable {

    @FXML
    private TextField meterCodeText;
    @FXML
    private TextField readingText;

    @FXML
    private BorderPane mainPane;
    
    //to view next page 
    public void nextPage(ActionEvent e) throws FileNotFoundException, IOException{
        
        String MC = meterCodeText.getText();
        String MR  = readingText.getText();
        File file = SpecialMethods.getPathFile("Customers",MC);
        DATA.MC = MC;


        if(CodeError1(MC));
        else if(CodeError2(MC));
        else if(ReadingError1(MR));
        else if(ReadingError2(file,MR));
        else{   

            DATA.Consumption = ConsumptionLabel(file,MR);
            DATA.Cost = CostLabel(file,MR);
            sendDataToFile(file,MR);
            switchPage.changePageToBill2(mainPane);

            DATA.meterCode = MC;
        }
        
    }
    
    
    private boolean CodeError1(String s){
        boolean flag = false;

        if(SpecialMethods.includeLetter(s) || s.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error, Plaese Enter Integer Numbers For Meter Code !", "ERROR",JOptionPane.ERROR_MESSAGE);
            meterCodeText.setText("");
            flag = true;
        }
        return flag;
    }
    private boolean CodeError2(String s) throws FileNotFoundException{
        if(SpecialMethods.searchOfMeterCode(s) != true){
            JOptionPane.showMessageDialog(null,"Sorry, Not found this meter code!", "Error",JOptionPane.ERROR_MESSAGE);
            meterCodeText.setText("");    
            return true;
        }
        else
            return false;
       
        
    }
    private boolean ReadingError1(String s){
        boolean flag = false;     
        if(SpecialMethods.includeLetter(s) || s.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error, Plaese Enter Integer Numbers For Meter Reading !", "ERROR",JOptionPane.ERROR_MESSAGE);
            readingText.setText("");            
            flag = true;
        }

        return flag;
    }
    private boolean ReadingError2(File file,String s) throws FileNotFoundException{
        boolean flag = false;        
        if(!Operator.validateReading(file,Integer.parseInt(s))){
            JOptionPane.showMessageDialog(null,"Warning, Invalid Meter Reading !", "WARNING",JOptionPane.WARNING_MESSAGE);
            readingText.setText("");
            flag = true;
        }

        return flag;
    }
    
    private String ConsumptionLabel(File file, String reading) throws FileNotFoundException, IOException{

        int cons = Operator.CalcOfConsumption(file, Integer.parseInt(reading));   
        return String.valueOf(cons);
    }
    private String CostLabel(File file, String reading) throws FileNotFoundException, IOException{
        int cons = Operator.CalcOfConsumption(file, Integer.parseInt(reading));
        double cost = Operator.CalcOfBill(cons);
        return String.valueOf(cost);
    }
    
    public void sendDataToFile(File file, String read) throws FileNotFoundException, IOException{
        int size = getData.countMonthlyBills(file);
        int cons = Operator.CalcOfConsumption(file, Integer.parseInt(read));   
        float cost = (float) Operator.CalcOfBill(cons);
        Date d;
        int dateMonth=0, dateYear=0;
        
        if(size == 0){
            d = new Date();
            dateMonth = d.getMonth()+1;
            dateYear  = d.getYear()+1900;
        }
        else{
            if(getData.DateMonth(size, file)==12){
                dateMonth = 1;
                dateYear = getData.DateYear(size, file)+1;
            }
            else{
                dateMonth = getData.DateMonth(size, file)+1;
                 dateYear = getData.DateYear(size, file);
            }
        }

        insertData.MonthlyDataOfCusomter(size+1, dateMonth, dateYear, Integer.parseInt(read), cons, cost, false, file);

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
