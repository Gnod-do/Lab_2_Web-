package lab2.servlets;

import lab2.models.AnswerPageGenerator;
import lab2.models.Check;
import lab2.models.CheckList;
import lab2.models.Clock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Clock clock = new Clock();
        clock.start();
        double x = Double.parseDouble(req.getParameter("X_f"));
        double y = Double.parseDouble(req.getParameter("Y_f"));
        double r = Double.parseDouble(req.getParameter("R_f"));
        if (!checking(x, y, r)) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
        }
        Check check = new Check(x, y, r);
        check.setResult(checkingTheArea(x, y, r));
        clock.stop();
        check.setClock(clock);
        CheckList answerList = (CheckList) getServletContext().getAttribute("answerList");
        if (answerList == null) {
            getServletContext().setAttribute("answerList", new CheckList());
            answerList = (CheckList) getServletContext().getAttribute("answerList");
        }
        answerList.add(check);
        getServletContext().setAttribute("answerList", answerList);
        PrintWriter writer = res.getWriter();
        writer.write(answerPage(check));
        writer.close();
    }
    public String answerPage(Check check) {
        String answer = AnswerPageGenerator.generateAnswerPage(check);
        return answer;
    }
    public boolean checkingTheArea(double x, double y, double r) {
        boolean result1 = (x <= 0) && (x >= -r/2) && (y >= 0) && (y <= r);
        boolean result2 = (x >= 0) && (x <= r) && (y >= 0) && (y <= r) && (x*x + y*y <= r*r);
        boolean result3 = (x >= 0) && (x <= r) && (y <= 0) && (y >= -r) && (y >= 2*x - r);
        return result1 || result2 || result3;
    }
    public boolean checking(double x, double y, double r) {
        return (x >= -2) && (x <= 2) && (y >= -5) && (y <= 3) && (r >= 1) && (r <= 3);
    }
}

