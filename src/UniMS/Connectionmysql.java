package UniMS;
/*
1.Register Driver
2.Create Connection
3.Create Statement
4.Execute Query
5.Close Connection
*/
import java.sql.*;

public class Connectionmysql {
    Connection connection;
    Statement statement;
    Connectionmysql(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver
            //Create Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityManagement","root","kvr10");
            //Create Statement(Helps in executing queries)
            statement= connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
