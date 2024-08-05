package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperations {
    public void addStudents(Student s) {
        Connection c = null;
        PreparedStatement checkStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;

        try {
            c = ConnectionFactory.getConnectionFactory().getConnection();

            // Check if student already exists
            String checkQuery = "SELECT COUNT(*) FROM details WHERE id = ?";
            checkStmt = c.prepareStatement(checkQuery);
            checkStmt.setInt(1, s.getId());
            rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("Student with ID " + s.getId() + " already exists.");
                return;
            }

            // Insert new student
            String insertQuery = "INSERT INTO details VALUES (?, ?, ?)";
            insertStmt = c.prepareStatement(insertQuery);
            insertStmt.setInt(1, s.getId());
            insertStmt.setString(2, s.getName());
            insertStmt.setInt(3, s.getMarks());

            int ans = insertStmt.executeUpdate();
            if (ans != 0) {
                System.out.println("Successfully added data");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (checkStmt != null) {
                try {
                    checkStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (insertStmt != null) {
                try {
                    insertStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
