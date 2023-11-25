package electricitybillingsystem;


import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author HP
 */
public class fxmlOrder {    
    
    private Pane view;
    
    public Pane getPage(String fileName){
        try{
            URL fileUrl = FXMain.class.getResource("/electricitybillingsystem/"+fileName+".fxml");
            if(fileUrl == null)
                throw new java.io.FileNotFoundException("FXML file can't be found");
            
            view = new FXMLLoader().load(fileUrl);
        }
        catch(Exception e){
            System.out.println("No Page "+fileName);
        }
          
        return view ;
    }
}
