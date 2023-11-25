package electricitybillingsystem;

import classes.Operator;
import classes.SpecialMethods;
import classes.getData;
import classes.updateData;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;



public class PerviousMonthController implements Initializable {

    @FXML
    private Label noOfmonthLabel;
    
    @FXML
    private TextField noToPayText;

    @FXML
    private BorderPane mainPane;

    public void setNoOfMonths() throws FileNotFoundException{
        int count = DATA.noOfFalseCheck;
        noOfmonthLabel.setText(String.valueOf(count));
    }
    
    public void getTotalCostCons() throws FileNotFoundException{
        File file = SpecialMethods.getPathFile("Customers",DATA.MC);
        int size = getData.countMonthlyBills(file);
        int count = DATA.noOfFalseCheck;
        
        if(!noToPayText.getText().isEmpty() && !SpecialMethods.includeLetter(noToPayText.getText())){
            int startLoop = (size - count)+1;
            int noOfLoop  = Integer.parseInt(noToPayText.getText());
            int endLoop   = startLoop + noOfLoop - 1;
            
            long totalCons = 0, totalCost=0;
            for(int i=startLoop ; i<=endLoop ; i++ ){
                totalCons += getData.Consumption(i, file);
                totalCost += getData.Billing(i, file);
            }

            DATA.totalConsumption = String.valueOf(totalCons);
            DATA.totalCost = String.valueOf(totalCost);
            DATA.perviousMonth = true;
            DATA.startLoop = startLoop;
            DATA.endLoop = endLoop;
        }
    }
    
    public void next(ActionEvent e) throws FileNotFoundException{
        getTotalCostCons();
        String readMonth = noToPayText.getText();
        int count = DATA.noOfFalseCheck;
        if(SpecialMethods.includeLetter(readMonth) || readMonth.isEmpty() || Integer.parseInt(readMonth) > count ){
            JOptionPane.showMessageDialog(null, "Error, sorry invalid input");
            noToPayText.setText("");
        }
        else{
            switchPage.changePageToTotalCostAndCons(mainPane);        
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setNoOfMonths();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PerviousMonthController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
