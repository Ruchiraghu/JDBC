package College;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            // Fetch data from the database using DatabaseHelper
            java.sql.ResultSet result = Query.executeQuery("SELECT * FROM student");


        while (result.next()){
            int rollno = result.getInt("rollno");
            String name = result.getString("name");
            String city = result.getString("city");
            Student student = new Student(rollno, name, city);
            list.add(student);
        }
            result.getStatement().getConnection().close();}
        catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<Student> itr = list.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println(list);
    }
}
