import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CancellationServlet")
public class Cancellationservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pnrNumber = request.getParameter("pnrNumber");

        boolean isCancelled = cancelReservation(pnrNumber);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isCancelled) {
            out.println("<html><body><p>Your reservation with PNR number " + pnrNumber + " has been cancelled.</p></body></html>");
        } else {
            out.println("<html><body><p>Invalid PNR number. Please check and try again.</p></body></html>");
        }
    }

    private boolean cancelReservation(String pnrNumber) {
        // Implement your logic here to cancel the reservation in the database
        // For demonstration purposes, let's assume that the reservation is cancelled successfully
        // if the PNR number is valid (not null or empty).
        return pnrNumber != null && !pnrNumber.trim().isEmpty();
    }
}
