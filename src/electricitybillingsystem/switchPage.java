package electricitybillingsystem;


import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


/**
 *
 * @author HP
 */
public class switchPage {
    private Pane view;

    
    
    public Pane getPage(String fileName){
        try{
            URL fileUrl = FXMain.class.getResource(fileName+".fxml");
            if(fileUrl == null)
                throw new java.io.FileNotFoundException("FXML file can't be found");
            
            view = new FXMLLoader().load(fileUrl);
        }
        catch(Exception e){
            System.out.println("No Page "+fileName);
        }
          
        return view ;
    }
    
    private  static  void changePage(BorderPane pane, String page){
            switchPage object = new switchPage();
            Pane view = object.getPage(page);         
            pane.setCenter(view); 
    }
    
    public static void changePageToBill1(BorderPane pane){
        changePage(pane,"Bills");
    }
    public static void changePageToBill2(BorderPane pane){
        changePage(pane,"bills2");
    }
    public static void changePageToAccount(BorderPane pane){
        changePage(pane,"Account");
    }
    public static void changePageToEditProfile(BorderPane pane){
        changePage(pane,"EditProfile");
    }
    public static void changePageToPay(BorderPane pane){
        changePage(pane,"Pay");
    }
    

    public static void changePageToTotalCostAndCons(BorderPane pane){
        changePage(pane,"viewTotalCostAndCons");
    }
    
    public static void changePageToHisotry(BorderPane pane){
        changePage(pane, "history");
    }
    
    // sign in and sign up
    public static void changePageToSignUp(BorderPane pane){
        changePage(pane, "/Login/SignUp");
    }
    
    public static void changePageToSignIn(BorderPane pane){
        changePage(pane, "/Login/sign_in");
    }
    
    // admin     
    public static void changePageToSearch(BorderPane pane){
        changePage(pane, "search");
    }
    
    public static void changePageToPro(BorderPane pane){
        changePage(pane, "/javaapplication10/Java2");
    }
    
    public static void changePageToOperator(BorderPane pane){
        changePage(pane, "/project/Edit Customer1");
    }
    public static void changePageToUpdate(BorderPane pane){
        changePage(pane, "/project/Update");
    }
    
    public static void changePageToprooperator(BorderPane pane){
        changePage(pane, "/fxml/profileoperator.fxml");
    }
    public static void changePageToHomeCustomer(BorderPane pane){
        changePage(pane, "homeCustomer.fxml");
    }
    
    
    
}
