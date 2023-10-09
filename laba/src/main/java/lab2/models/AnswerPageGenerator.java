package lab2.models;

public class AnswerPageGenerator {
    public static String generateAnswerPage(Check check) {
        String result = check.isResult() ? "Yes!" : "No!";
        String htmlContent = "<html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>answer</title>\n" +
                "  <link rel=\"stylesheet\" href=\"main.css\">\n" +
                "</head>\n" +
                "<table class=\"main-table\" align=\"center\">\n" +
                "  <th colspan=\"2\">\n" +
                "    <p title=\"It's me!\" class=\"main-table\">\n" +
                "      Do Van Dong, P3225, v. 861205\n" +
                "    </p>\n" +
                "  </th>\n" +
                "  <tr>\n" +
                "    <td>\n" +
                "    </td>\n" +
                "    <td>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=\"2\">\n" +
                "      <div class=\"main-table\">\n" +
                "<p class='the_result'>" +
                "<table align=\"center\" class='the_result'>\n" +
                "    <tr>\n" +
                "        <th class=\"variable\">X=" + check.getX() + "</th>\n" +
                "        <th class=\"variable\">Y=" + check.getY() + "</th>\n" +
                "        <th class=\"variable\">R=" + check.getY() + "</th>\n" +
                "        <th>Result " + result + "</th>\n" +
                "    </tr>" + "</p>" + "<form action=\"controllerServlet\">\n" +
                "<button class=\"back_button\" type=\"submit\">Back</button>\n" +
                "</form>\n" +
                "      </div>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        return htmlContent;
    }
}
