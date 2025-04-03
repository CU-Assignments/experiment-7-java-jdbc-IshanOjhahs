import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedb"; // Change database name
        String user = "root"; // Change if you have a different username
        String password = "!$#@n0j#@030103"; // Change to your MySQL password

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database!");

            
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Employee"; // Change table name if needed

            
            ResultSet rs = stmt.executeQuery(query);

            
            while (rs.next()) {
                System.out.println("EmpID: " + rs.getInt("EmpID") + 
                                   ", Name: " + rs.getString("Name") + 
                                   ", Salary: " + rs.getDouble("Salary"));
            }

            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}