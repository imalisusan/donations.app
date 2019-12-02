package project;
import java.io.IOException;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class LoginController implements Initializable 
{
    @FXML
    private TextField userName,passCode;
    @FXML
    private Button btnSignIn;
    @FXML
    private Label lblErrors;

    public void handleButtonAction(ActionEvent event) throws IOException
    {
       if(event.getSource()==btnSignIn)
       {
       logIn();
       Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        root.getStylesheets().add("/sample/style.css");
        Scene scene = new Scene(root);  
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
       }
       else{}
    }
       @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }  
    public LoginController()
    {
    }
    Connection con=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    private void logIn()
    {
    String username= userName.getText();
    String password= passCode.getText();
    //query
    String sql = "SELECT * FROM users WHERE  username= ? and password= ?";  
        try {
            preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet=preparedStatement.executeQuery();
            if(!resultSet.next())
            {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Enter  Correct Username/Password!");
            }   
            else
            {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Log In Successful. Redirecting.....");
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void goToSignUp(ActionEvent event) throws IOException
    {
     Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        root.getStylesheets().add("/sample/style.css");
        Scene scene = new Scene(root);  
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
   
    public void exit(ActionEvent event)
    {
     System.out.println("Exiting...");
     System.exit(0);
    }
   
}
