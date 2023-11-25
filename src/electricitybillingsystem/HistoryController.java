package electricitybillingsystem;


import classes.MonthlyData;
import classes.SpecialMethods;
import classes.getData;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class HistoryController implements Initializable {


    
    @FXML
    private TableView<MonthlyData> historyTable;
    @FXML
    private TableColumn<MonthlyData, Boolean> check;

    @FXML
    private TableColumn<MonthlyData, Integer> consumption;

    @FXML
    private TableColumn<MonthlyData, Float> cost;

    @FXML
    private TableColumn<MonthlyData, Integer> dateMonth, dateYear;



    private ArrayList<MonthlyData> InfoMonth = new ArrayList<>();
    ObservableList<MonthlyData> list;
    public void getInformation() throws FileNotFoundException{
        File file = SpecialMethods.getPathFile("Customers",DATA.meterCode);
        int size = getData.countMonthlyBills(file);
        for(int i=1 ; i<=size ; i++){
            boolean check = getData.Check(i, file);
            int dmonth = getData.DateMonth(i, file);
            int dyear = getData.DateYear(i, file);
            float cost = (float) getData.Billing(i, file);
            int cons = getData.Consumption(i, file);
            
            InfoMonth.add(new MonthlyData(dmonth, dyear, check, cons, cost));
        }
        
        list = FXCollections.observableArrayList(InfoMonth);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {         
        try {
            getInformation();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            dateMonth.setCellValueFactory(new PropertyValueFactory<MonthlyData ,Integer>("d_month"));
            dateYear.setCellValueFactory(new PropertyValueFactory<MonthlyData ,Integer>("d_year"));
           
            consumption.setCellValueFactory(new PropertyValueFactory<MonthlyData ,Integer>("consumption"));
            cost.setCellValueFactory(new PropertyValueFactory<MonthlyData ,Float>("billing"));
            check.setCellValueFactory(new PropertyValueFactory<MonthlyData ,Boolean>("check"));
            
            historyTable.setItems(list);
       

    }    
    
}
