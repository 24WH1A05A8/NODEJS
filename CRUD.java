package firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUD{

    static Connection con;

    // CONNECT
    static void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/24wh1a05a8",
            "root",
            "1234"
        );
    }

    // DISPLAY TABLE
    static void display() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employe");

        System.out.println("\nEMPID\tEMPNAME\tSALARY\tDEP");
        System.out.println("--------------------------------");

        while (rs.next()) {
            System.out.println(
                rs.getInt("empid") + "\t" +
                rs.getString("empname") + "\t" +
                rs.getInt("salary") + "\t" +
                rs.getString("dep")
            );
        }
    }

    // INSERT
    static void insert() throws Exception {
        String sql = "INSERT INTO employe VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, 5);
        ps.setString(2, "arjun");
        ps.setInt(3, 18000);
        ps.setString(4, "testing");

        ps.executeUpdate();
        System.out.println("\nRecord Inserted");
        display();
    }

    // UPDATE
    static void update() throws Exception {
        String sql = "UPDATE employe SET salary=? WHERE empid=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, 25000);
        ps.setInt(2, 2);

        ps.executeUpdate();
        System.out.println("\nRecord Updated");
        display();
    }

    // DELETE
    static void delete() throws Exception {
        String sql = "DELETE FROM employe WHERE empid=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, 5);

        ps.executeUpdate();
        System.out.println("\nRecord Deleted");
        display();
    }

    public static void main(String[] args) {
        try {
            connect();

            System.out.println("Before Operations:");
            display();

            insert();
            update();
            delete();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
