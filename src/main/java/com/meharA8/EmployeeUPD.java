package com.meharA8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeUPD {

    public void updateEmployee(Employee e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05a8", "root", "1234"
            );

            PreparedStatement ps = con.prepareStatement(
                "UPDATE employee SET name=?, salary=? WHERE id=?"
            );

            ps.setString(1, e.getName());
            ps.setInt(2, e.getSalary());
            ps.setInt(3, e.getId());

            ps.executeUpdate();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}