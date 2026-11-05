import java.sql.*;

public class JDBCLearning {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        //load and register driver
        Class.forName("com.mysq.cj.jdbc.Driver");

        //Establish the connection
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Rahman@2005";
        Connection connect = DriverManager.getConnection(url,user,password);

        //creating statement
        Statement statement = connect.createStatement();

        //execute query


        //process the result


        //close the resources
        statement.close();
        connect.close();
    }
}
