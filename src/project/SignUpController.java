package project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class SignUpController implements Initializable 
{
    public TextField fullName,userName,userId,emailAddress,phoneNumber,password; 
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }   
    
    public void handleButtonAction(ActionEvent event)throws IOException, SQLException, ClassNotFoundException 
    {
      ConnectionClass connectionClass= new ConnectionClass();
       Connection connection=connectionClass.getConnection();
       String sql = "INSERT INTO users (UserId ,FullName, userName, EmailAddress, PhoneNumber, Password) VALUES('"+userId.getText()+"','"+fullName.getText()+"','"+userName.getText()+"','"+emailAddress.getText()+"','"+phoneNumber.getText()+"','"+password.getText()+"');";
       System.out.println(fullName.getText());
       Statement statement=connection.createStatement();    
       statement.executeUpdate(sql);  
       
       Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    public void updateDetails(ActionEvent event) throws SQLException 
    {
       ConnectionClass connectionClass= new ConnectionClass();
       Connection connection=connectionClass.getConnection();
       String sql = "UPDATE users SET FullName='"+fullName.getText()+"','"+userName.getText()+"','"+emailAddress.getText()+"','"+phoneNumber.getText()+"','"+password.getText()+"' WHERE UserId='"+userId.getText()+"'";
       Statement statement=connection.createStatement();    
       statement.executeUpdate(sql);
    }
    public static void main(String[] args) 
    {
        
    } 
    public void exit(ActionEvent event)
    {
     System.out.println("Exiting...");
     System.exit(0);
    }
   public TextField getuserName()
    {
    return userName;
    }
    public void setuserName(TextField userName)
    {
    this.userName=userName;
    }
    public TextField getfullName()
    {
    return fullName;
    }
    public void setfullName(TextField fullName)
    {
    this.fullName=fullName;
    }
    public TextField getuserId()
    {
    return userId;
    }
    public void setuserId(TextField userId)
    {
    this.userId=userId;
    }
    public TextField getemailAddress()
    {
    return emailAddress;
    }
    public void setemailAddress(TextField emailAddress)
    {
    this.emailAddress=emailAddress;
    }
    public TextField getphoneNumber()
    {
    return phoneNumber;
    }
    public void setphoneNumber(TextField phoneNumber)
    {
    this.phoneNumber=phoneNumber;
    }
    public TextField getpassword()
    {
    return password;
    }
    public void setpassword(TextField password)
    {
    this.password=password;
    }
    public String toString()
    {
    return this.userId+" "+" "+this.fullName+" "+this.userName+" "+this.emailAddress+" "+this.phoneNumber;
    }
}
