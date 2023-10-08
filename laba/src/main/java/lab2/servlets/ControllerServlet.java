package lab2.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            double x = Double.parseDouble(req.getParameter("X_f"));
            double y = Double.parseDouble(req.getParameter("Y_f"));
            double r = Double.parseDouble(req.getParameter("R_f"));
            getServletContext().getRequestDispatcher("/areaCheckServlet").forward(req, res);
        } catch (NumberFormatException e) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
        }
    }
}
