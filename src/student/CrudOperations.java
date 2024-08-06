package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class CrudOperations {
Connection c = null;
     PreparedStatement ppst = null;
     ResultSet rs = null;

     public  Connection doSimple(){
         Connection connect = null;

         try {
             connect  = ConnectionFactory.getConnectionFactory().getConnection() ;
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return connect;
     }

    // crud  - create , read   , update  , delete
    public void addStudent(Student s ) {

        try {
            c  = doSimple() ;
             ppst  = c.prepareStatement("insert into details values(?, ? ,?)") ;
            ppst.setInt(1, s.getId());
            ppst.setString(2, s.getName()) ;
            ppst.setInt(3,  s.getMarks()) ;

            int ans  = ppst.executeUpdate() ; // one row mai data  insert huva hai

            if (ans != 0) {
                System.out.println("data got inserted succesfully ");
            }else {
                System.out.println("some thing went wrong");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try{
                if(ppst!=null){
                    ppst.close();
                }
                if (c!=null){
                    c.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }


    }
 public void updateData(Student s){
         try{
             c = doSimple();
             ppst = c.prepareStatement("UPDATE details set marks = ? WHERE id = ? ");
             ppst.setInt(1,s.getMarks());
             ppst.setInt(2,s.getId());
             int ans =  ppst.executeUpdate();
             if (ans != 0) {
                 System.out.println("data got updated succesfully ");
             }else {
                 System.out.println("some thing went wrong");
             }
         }    catch (SQLException e){
             e.printStackTrace();

         } finally {
             try{
                 if(ppst!=null){
                     ppst.close();
                 }
                 if (c!=null){
                     c.close();
                 }

             }catch (SQLException e){
                 e.printStackTrace();
             }
         }
 }

 public void deleteData(Student s){
         try{
             c = doSimple();
             ppst = c.prepareStatement("DELETE FROM details WHERE id = ? AND marks = ? ");
             ppst.setInt(1,s.getId());
             ppst.setInt(2,s.getMarks());
             int ans = ppst.executeUpdate();
             if (ans != 0) {
                 System.out.println("data got deleted succesfully ");
             }else {
                 System.out.println("some thing went wrong");
             }
         }    catch (SQLException e){
             e.printStackTrace();

         } finally {
             try{
                 if(ppst!=null){
                     ppst.close();
                 }
                 if (c!=null){
                     c.close();
                 }

             }catch (SQLException e){
                 e.printStackTrace();
             }
         }

 }
 public void readData(int s){
         try {
             c = doSimple();
             ppst = c.prepareStatement("SELECT * FROM details");
             ResultSet ans = ppst.executeQuery();
             System.out.println("Reading data");
             while (ans.next()){
                 int Id = ans.getInt("id");
                 String name = ans.getString("name");
                 int marks = ans.getInt("marks");

                 System.out.println("ID: " + Id + ", Name: " + name + ", Marks: " + marks);

             }

         }catch (SQLException e){
             e.printStackTrace();
         }
         finally {
             try{
                 if(rs!=null){
                 rs.close();
             }
                 if(c!=null){
                 c.close();
             }
             }
         catch(SQLException e){
                 e.printStackTrace();
             }


 }

 }
 }


