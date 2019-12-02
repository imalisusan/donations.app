package project;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AccountController implements Initializable 
{
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
    }    
    public void myProfileButton(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show(); 
        
    }
    //doesn't work
    public void makeContributionButton(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Contributor.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show(); 
        
    }
    public void logOutButton(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show(); 
        
    }
    
}
