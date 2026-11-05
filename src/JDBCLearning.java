import java.sql.*;

public class JDBCLearning {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        //load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish the connection
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Rahman@2005";
        Connection connect = DriverManager.getConnection(url,user,password);

        //creating statement
        Statement statement = connect.createStatement();

        /**FOR INSERT,UPDATE AND DELETE USE executeUpdate**/
        //execute query
        //process the result
        String query = "INSERT INTO studentinfo (id,sname,sage,scity)"+
                       "VALUES (19,'Rahman',21,'Hyderabad')";


       int rows = statement.executeUpdate(query);
       System.out.println(rows + " inserted Successfuly");


       String query1 = "UPDATE studentinfo SET sname = 'Ahmed' WHERE id=2";
       int rows1 = statement.executeUpdate(query1);
       System.out.println(rows+ " updated Successfully");


      String query2 = "DELETE FROM studentinfo WHERE id = 3";
      int rows2 = statement.executeUpdate(query2);
      System.out.println(rows+" deleted Successfully");


      /** FOR RETRIEVE(SELECT) USE exexuteQuery AS it returns RESULT SET**/
         String query3 = "SELECT * FROM studentinfo";
         ResultSet rsp = statement.executeQuery(query3);

         while(rsp.next()){
             int id = rsp.getInt("id");
             String name = rsp.getString("sname");
             int age = rsp.getInt("sage");
             String city = rsp.getString("scity");

             System.out.println(id+"--"+name+"--"+age+"--"+city);
         }

        //close the resources
        statement.close();



        /**USE PREPARED STATEMENT TO PROTECT FROM SQL INJECTION**/

        String psQuery = "INSERT INTO studentinfo (id,sname,sage,scity) VALUES (?,?,?,?)";
        PreparedStatement ps = connect.prepareStatement(psQuery);
        ps.setInt(1,290);
        ps.setString(2,"Rahul");
        ps.setInt(3,34);
        ps.setString(4,"Calcutta");

        int rowsps = ps.executeUpdate();
        System.out.println(rows+" inserted Successfully");


        String psQuery1 = "SELECT * FROM studentinfo";
        PreparedStatement ps1 = connect.prepareStatement(psQuery1);


        ResultSet rp = ps1.executeQuery();

        while (rp.next()){
            int id = rp.getInt("id");
            String name = rp.getString("sname");
            int age = rp.getInt("sage");
            String city = rp.getString("scity");

            System.out.println(id+"--"+name+"--"+age+"--"+city);
        }




        connect.close();
    }
}
