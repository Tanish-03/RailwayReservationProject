import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValidUser = authenticateUser(username, password);

        if (isValidUser) {
          
            response.sendRedirect("ReservationForm.html");
        } else {
          
            response.sendRedirect("login.html?error=true");
        }
    }

    private boolean authenticateUser(String username, String password) {
      
        return "admin".equals(username) && "admin123".equals(password);
    }
}
