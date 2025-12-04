import java.sql.*;

public class main {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "newuser";
    private static final String pass = "123123123";

    public static void main(String[] args) throws SQLException {
        Connection c = null;
        
        try {
            String query = "Select Name From workers";
            c = DriverManager.getConnection(url, user, pass);
            System.out.print("Connected!");

            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(query);
            while (r.next()) {
                // Retrieve data by column names or column indexes
                int id = r.getInt("id");
                String name = r.getString("name");
                String position = r.getString("position");

                // Display the data
                System.out.println(id + "\t" + name + "\t\t" + position);
            }
        }   
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
    }

}
