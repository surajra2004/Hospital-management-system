import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/AppointmentServlet")

public class AppointmentServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {

String patient=request.getParameter("patient");
String doctor=request.getParameter("doctor");
String date=request.getParameter("date");

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps=con.prepareStatement(
"insert into appointment(patient_name,doctor_name,date) values(?,?,?)");

ps.setString(1,patient);
ps.setString(2,doctor);
ps.setString(3,date);

ps.executeUpdate();

response.getWriter().println("Appointment Booked");

}catch(Exception e){
System.out.println(e);
}

}
}