import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlett extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isRegistered = registerUser(username, email, password);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isRegistered) {

            response.sendRedirect("success.html");
        } else {
            
            response.sendRedirect("error.html");
        }
    }

    private boolean registerUser(String username, String email, String password) {
       
        return username != null && !username.trim().isEmpty()
                && email != null && !email.trim().isEmpty()
                && password != null && !password.trim().isEmpty();
    }
}
