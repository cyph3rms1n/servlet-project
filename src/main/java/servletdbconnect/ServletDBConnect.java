package servletdbconnect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDBConnect extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String tb = req.getParameter("table");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            Statement stmt = con.createStatement();

            System.out.println("Connected to database successfully");

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tb);
            while (rs.next()) {
                pw.println(rs.getString(1) + " " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            pw.println("Error: " + e.getMessage());
        }
    }
}