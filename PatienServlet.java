import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/PatientServlet")

public class PatientServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {

String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));
String gender=request.getParameter("gender");
String disease=request.getParameter("disease");
String phone=request.getParameter("phone");

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps=con.prepareStatement(
"insert into patient(name,age,gender,disease,phone) values(?,?,?,?,?)");

ps.setString(1,name);
ps.setInt(2,age);
ps.setString(3,gender);
ps.setString(4,disease);
ps.setString(5,phone);

ps.executeUpdate();

response.getWriter().println("Patient Added");

}catch(Exception e){
System.out.println(e);
}

}
}