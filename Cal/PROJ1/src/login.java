import java.sql.*;
import java.util.Scanner;
public class login {
    private static final String sql = "jdbc:mysql://localhost:3306/userlogin";
    private static final String user = "root"; 
    private static final String passwd = "rx-78-2";
    
    static void Loginpage(String dbuser, String dbpass){
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        String user_name = input.nextLine();
        System.out.print("Password: ");
        String pass = input.nextLine();

        if (user_name.equals(dbuser) && pass.equals(dbpass)){
            System.out.println("Login Successful");
        }
        else {
            System.out.println("Login Failed");
        }
        
    }
    public static void main(String[] args) {  
        try{
            String a = "HAHAHA";
            String getval = "SELECT * FROM usercreds;";
            String query =  "UPDATE usercreds SET password='" + a + "' where username='user';"
                            
            ;
            Connection connect = DriverManager.getConnection(sql, user, passwd);
            // PreparedStatement statement = connect.prepareStatement(query);
            // statement.executeUpdate();
         
            Statement statement = connect.createStatement();
            ResultSet r = statement.executeQuery(getval);
          
            while (r.next()) {
                String aa = r.getString("username");
               
                if (aa.equals("Prince")){
                    System.out.println(aa);
                }
            }
            statement.close();
            r.close();
            connect.close();
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
            
        }
    }
}
