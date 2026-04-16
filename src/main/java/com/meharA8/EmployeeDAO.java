package com.meharA8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public void deleteEmployee(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05a8", "root", "1234"
            );

            PreparedStatement ps = con.prepareStatement("delete from employee where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}