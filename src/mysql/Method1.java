package College;

import java.sql.*;

public class Method1 {
    public static void main(String[] args) throws SQLException {
        System.out.println("welcome");
        //step 1
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //step 2
        Connection connect;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "Ruchi@12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //step 3
        Statement st = connect.createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM student");
        try{
            java.sql.ResultSet resultSet =
        }catch (Exception e){
            System.out.println(e);
        }
        while(result.next()){
            int rollno = result.getInt("rollno");
            String name = result.getString("name");
            String city = result.getString("city");
            System.out.println("student rollno: " + rollno + ", name: " + name + ", city: " + city);
        }
        connect.close();
    }
}
