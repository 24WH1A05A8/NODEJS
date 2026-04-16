package firstproject;

import java.sql.*;

public class Delete{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05a8",
                "root",
                "1234"
            );

            String deleteSql = "DELETE FROM employe WHERE empid=?";
            PreparedStatement ps = con.prepareStatement(deleteSql);

            ps.setInt(1, 5);

            ps.executeUpdate();
            System.out.println("Record Deleted\n");

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
