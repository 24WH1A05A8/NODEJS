package com.meharA8;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/insertEmployee")
public class InsertEmployee extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int salary = Integer.parseInt(request.getParameter("salary"));

        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setSalary(salary);

        EmployeeINS dao = new EmployeeINS();
        dao.insertEmployee(e);

        response.getWriter().println("Inserted Successfully!");
    }
}