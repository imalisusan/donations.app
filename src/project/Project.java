package project;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle; 
public class Project extends Application {
    public TextField fullName,userName,userId,emailAddress,phoneNumber,password;
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        root.getStylesheets().add("/sample/style.css");
        Scene scene = new Scene(root);  
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
public void handleButtonAction(ActionEvent event)throws IOException 
    {
       
    }
 
    public static void main(String[] args) {
        launch(args);
        SignUpController account=new SignUpController();
        ContributorController contribution=new ContributorController();
    }
    
}
