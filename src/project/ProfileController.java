package project;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class ProfileController implements Initializable 
{
   @FXML
    public TextField fullName,userName,userId,emailAddress,phoneNumber,password;
   public String dbFullName,dbUserName,dbUserId,dbEmailAddress,dbPhoneNumber,dbPassword;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    public void goBackToAccount(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show(); 
        
    }
    public void handleButtonAction(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();  
    }
    public void goToUpdate(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("UpdateDetails.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show(); 
        
    }
    //function works. Just get the right data.
        public void deleteAccount(ActionEvent event)throws SQLException, ClassNotFoundException, IOException
        {
            String sql= "DELETE FROM users";
            try{
            ConnectionClass connectionClass= new ConnectionClass();
            Connection connection=connectionClass.getConnection();
            Statement statement=connection.createStatement();    
            statement.executeUpdate(sql);  
            }
            catch(SQLException e)
            {}
            Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        }

    public void showDetails(ActionEvent event) throws SQLException
    {
       try{
        ConnectionClass connectionClass= new ConnectionClass();
           Connection connection=connectionClass.getConnection();
           String sql="SELECT UserId, FullName,UserName,EmailAddress,PhoneNumber,Password FROM users WHERE UserId= ?;";   
           PreparedStatement statement=connection.prepareStatement(sql);   
           ResultSet rs=statement.executeQuery(sql);
           while (rs.next())
          {
            dbUserId=(rs.getString("UserId"));
            dbFullName=(rs.getString("FullName"));
            dbUserName=(rs.getString("UserName"));
            dbEmailAddress=(rs.getString("EmailAddress"));
            dbPhoneNumber=(rs.getString("PhoneNumber"));
            dbPassword=(rs.getString("PhoneNumber"));
            userId.setText(dbUserId);
            fullName.setText(dbFullName);
            userName.setText(dbUserName);
            emailAddress.setText(dbEmailAddress);
            phoneNumber.setText(dbPhoneNumber);
            password.setText(dbPassword);
            
          }
           statement.close(); 
        }
         catch (Exception e)
        {
        }
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
    public static void main(String args[])
    {
    
        
    }
}
