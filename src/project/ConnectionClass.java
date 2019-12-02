package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionClass {
    public Connection connection;
    public Connection getConnection() 
    {
        String dbName="Donations";
        String username="root";
        String password="";
        try
        {   
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,username,password);
        
        }
        catch(ClassNotFoundException | SQLException e)
        {
        }
        return connection;
    }

}
