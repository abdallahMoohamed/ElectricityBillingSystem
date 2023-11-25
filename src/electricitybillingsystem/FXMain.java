package electricitybillingsystem;

import classes.getData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
    import javafx.stage.Stage;


public class FXMain extends Application {
    
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/sign_in.fxml"));
        Scene scene= new Scene(root);
        Image icon= new Image("/images/electricity.png");
        stage.getIcons().add(icon);
        stage.setTitle("EBS");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        DATA.stage = stage;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
