package com.meharA8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeINS {

    public void insertEmployee(Employee e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05a8", "root", "1234"
            );

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employee(id,name,salary) VALUES(?,?,?)"
            );

            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setInt(3, e.getSalary());

            ps.executeUpdate();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}