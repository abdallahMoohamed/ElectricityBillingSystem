import classes.SpecialMethods;
import classes.getData;
import electricitybillingsystem.DATA;
import electricitybillingsystem.switchPage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;




public class Sign_inController implements Initializable {

    @Override    
    public void initialize(URL url, ResourceBundle rb) {
        choice_type.getItems().addAll(types);
        choice_type.setValue("Customer");
    }   
    
    @FXML
    private TextField email_filed;
    @FXML
    private PasswordField pass_Field;
    @FXML
    private BorderPane mainPane;

    @FXML
    private ChoiceBox <String> choice_type;
    private String[] types = {"Admin","Operator","Customer"};
    private String folderName;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    String email;
    String password;
    
    public void AccessChoiseBox(){             
        if(choice_type.getValue().equals("Customer")){
            folderName = "Customers";
        }
        else if(choice_type.getValue().equals("Operator"))
            folderName = "Operators";
        else if(choice_type.getValue().equals("Admin"))
            folderName = "Admin";
        else if(choice_type.getValue().isEmpty())
            System.out.println("Not Found Folder");
    }
    

   
    public void sign_in_Action(ActionEvent event) throws FileNotFoundException, IOException{
       AccessChoiseBox();
     
       email = " "+ email_filed.getText();       
       password = " "+ pass_Field.getText();   
       int sizeCustomers = DATA.countOfFilesCustomers;
       int sizeOperators = DATA.countOfFilesOperators;
       boolean emaiIsFound = false;
       
       if(folderName.equals("Customers")){
            singIn(event, "/electricitybillingsystem/Customer1.fxml", emaiIsFound, sizeCustomers, "Customers",202101 );
       }
       else if(folderName.equals("Admin")){
           singIn(event, "/javaapplication10/Home.fxml",emaiIsFound,1, "Admin",1);
       }
       else
       {
           singIn(event,"/fxml/MainOperator.fxml",emaiIsFound,3,"Operators",1);
       }
  

   }
   
    public void sign_up_Action(ActionEvent event){
        switchPage.changePageToSignUp(mainPane);
    }


    public void singIn(ActionEvent event, String namePage, boolean emaiIsFound, int size, String folder, int start ) throws FileNotFoundException, IOException{
            for(int i= start ; i <= size ; i++){
                
                
                File file = SpecialMethods.getPathFile(folder, String.valueOf(i));                
                String em = getData.Email(file);
                String pass = getData.Password(file);
                if(email.equals(em)){
                    emaiIsFound = true;
                    if(folder.equals("Customers"))
                        DATA.meterCode = String.valueOf(i);
                    if(folder.equals("Operator"))
                        DATA.IdOperator = String.valueOf(i);
                    
                        
                    if(password.equals(pass)){
                         FXMLLoader loader = new FXMLLoader(getClass().getResource(namePage));
                         root = loader.load();
                         Image icon = new Image("/images/electricity.png");
                         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                         scene = new Scene(root);   
                         stage = new Stage();
                         stage.initStyle(StageStyle.DECORATED);
                         stage.setScene(scene);
                         stage.getIcons().add(icon);
                         stage.setTitle("EBS");
                         stage.setResizable(false);
                         stage.show();
                         DATA.stageHome = stage;
                         DATA.stage.close();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Password","Invalid Password", JOptionPane.WARNING_MESSAGE);
                        pass_Field.setText("");
                    }
                }

            }
            if(!emaiIsFound){
                JOptionPane.showMessageDialog(null,"Not Found This Email","Invalid Email", JOptionPane.WARNING_MESSAGE);
                email_filed.setText("");
            }
    }
 
    
}
