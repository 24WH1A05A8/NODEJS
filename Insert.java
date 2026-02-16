package firstproject;

import java.sql.*;

public class Insert{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05a8",
                "root",
                "1234"
            );

            String insertSql = "INSERT INTO employe VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSql);

            ps.setInt(1, 5);
            ps.setString(2, "arjun");
            ps.setInt(3, 18000);
            ps.setString(4, "testing");

            ps.executeUpdate();
            System.out.println("Record Inserted\n");

            // DISPLAY
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employe");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("empid") + " " +
                    rs.getString("empname") + " " +
                    rs.getInt("salary") + " " +
                    rs.getString("dep")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
