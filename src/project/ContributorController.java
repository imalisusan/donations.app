package project;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class ContributorController implements Initializable 
{
    
    public TextField userId;
    public TextField amount; 
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
    }  
    
    public void handleButtonAction(ActionEvent event)throws IOException, SQLException 
    {
       ConnectionClass connectionClass= new ConnectionClass();
       Connection connection=connectionClass.getConnection();
       String sql="INSERT INTO contributions (ContId, UserId, Amount) VALUES(NULL,'"+userId.getText()+"','"+amount.getText()+"');"; 
       Statement statement=connection.createStatement();    
       statement.executeUpdate(sql);
       //ContributorController contribution=new ContributorController(userId,amount);
    }
    public void goBacktoAccount(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show(); 
        
    }
    
    public TextField getuserId()
    {
    return userId;
    }
    public void setuserId(TextField userId)
    {
    this.userId=userId;
    }
    public TextField amount()
    {
    return amount;
    }
    public void amount(TextField amount)
    {
    this.amount=amount;
    }
    public String toString()
    {
    return this.userId+" "+" "+this.amount;
    }
    
}
