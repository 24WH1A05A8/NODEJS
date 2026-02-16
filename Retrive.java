package firstproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Retrive {
    public static void main(String[] args) {
        try {
            // Step 1: Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step 2: Connect to DB
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05a8",
                "root",
                "1234"
            );

            // Step 3: Create statement
            Statement statement = connection.createStatement();

            // Step 4: Execute query
            ResultSet rs = statement.executeQuery("SELECT * FROM employe");

            System.out.println("EMPID\tEMPNAME\tSALARY\tDEP");
            System.out.println("-----------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("empid") + "\t" +
                    rs.getString("empname") + "\t" +
                    rs.getInt("salary") + "\t" +
                    rs.getString("dep")
                );
            }

            // Step 5: Close connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
