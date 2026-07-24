import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/DoctorServlet")

public class DoctorServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {

String name=request.getParameter("name");
String specialization=request.getParameter("specialization");
String phone=request.getParameter("phone");

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps=con.prepareStatement(
"insert into doctor(name,specialization,phone) values(?,?,?)");

ps.setString(1,name);
ps.setString(2,specialization);
ps.setString(3,phone);

ps.executeUpdate();

response.getWriter().println("Doctor Added");

}catch(Exception e){
System.out.println(e);
}

}
}
