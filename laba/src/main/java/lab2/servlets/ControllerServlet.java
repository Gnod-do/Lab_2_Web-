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

            if (isValidData(x,y,r)) {
                getServletContext().getRequestDispatcher("/areaCheckServlet").forward(req, res);
            } else {
                req.setAttribute("errorMessage","Invalid data. Please check your inputs.");
                getServletContext().getRequestDispatcher("/index.jsp").forward(req,res);
            }

        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid data format. Please enter valid numbers.");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
        }
    }

    private boolean isValidData(double x, double y, double r) {
        boolean isValidX = x >= -2 && x <= 2;
        boolean isValidY = y >= -5 && y <= 3;
        boolean isValidR = r >= -1 && r <= 3;
        return isValidX && isValidY && isValidR;
    }
}
