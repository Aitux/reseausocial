package servlet;

import model.InBeforeBDD;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AccueilPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        boolean flag = InBeforeBDD.getInstance().isConnected(req);


        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "\n" +
                "<head>\n" +
                "    <!-- Required meta tags -->\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"description\" content=\"log in page for miagebook\">\n" +
                "    <meta name=\"author\" content=\"Simon Vandeputte\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "\n" +
                "    <title>Miagebook</title>\n" +
                "\n" +
                "    <link rel=\"shortcut icon\" href=\"\" type=\"image/x-icon\">\n" +
                "    <link rel=\"apple-touch-icon\" href=\"\">\n" +
                "\n" +
                "    <!-- Bootstrap CSS -->\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" +
                "    <!-- Link to your css file -->\n" +
                "    <link rel=\"stylesheet\" href=\"\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <!-- Start coding here -->\n");

        if (!flag) {
            out.println(
                    "    <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
                            "        <div class=\"navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2\">\n" +
                            "            <ul class=\"navbar-nav mr-auto\">\n" +
                            "                <li class=\"nav-item\">\n" +
                            "                    <a class=\"nav-link\" href=\"/SimpleServlet-1/miagebook\">Home</a>\n" +
                            "                </li>\n" +
                            "            </ul>\n" +
                            "        </div>\n" +
                            "        <div class=\"mx-auto order-0\">\n" +
                            "            <a class=\"navbar-brand mx-auto\" href=\"/SimpleServlet-1/miagebook\">miagebook</a>\n" +
                            "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\".dual-collapse2\">\n" +
                            "                <span class=\"navbar-toggler-icon\"></span>\n" +
                            "            </button>\n" +
                            "        </div>\n" +
                            "        <div class=\"navbar-collapse collapse w-100 order-3 dual-collapse2\">\n" +
                            "            <ul class=\"navbar-nav ml-auto\">\n" +
                            "                <li class=\"nav-item\">\n" +
                            "                    <a class=\"nav-link\" href=\"/SimpleServlet-1/signin\">Sign in</a>\n" +
                            "                </li>\n" +
                            "                <li class=\" nav-item\">\n" +
                            "                    <a class=\"nav-link\" href=\"/SimpleServlet-1/signup\">Sign up</a>\n" +
                            "                </li>\n" +
                            "            </ul>\n" +
                            "        </div>\n" +
                            "    </nav>\n" +
                            "\n");
        } else {
            out.println("<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
                    "        <div class=\"navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2\">\n" +
                    "            <ul class=\"navbar-nav mr-auto\">\n" +
                    "                <li class=\"nav-item\">\n" +
                    "                    <a class=\"nav-link\" href=\"#\">Profile</a>\n" +
                    "                </li>\n" +
                    "            </ul>\n" +
                    "        </div>\n" +
                    "        <div class=\"mx-auto order-0\">\n" +
                    "            <a class=\"navbar-brand mx-auto\" href=\"#\">miagebook</a>\n" +
                    "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\".dual-collapse2\">\n" +
                    "                <span class=\"navbar-toggler-icon\"></span>\n" +
                    "            </button>\n" +
                    "        </div>\n" +
                    "        <div class=\"navbar-collapse collapse w-100 order-3 dual-collapse2\">\n" +
                    "            <ul class=\"navbar-nav ml-auto\">\n" +
                    "                <li class=\"nav-item\">\n" +
                    "                    <span class=\"nav-link\">Bonjour, " + InBeforeBDD.getInstance().getUser(req).getFirstname() + "</span>\n" +
                    "                </li>\n" +
                    "                <li class=\" nav-item\">\n" +
                    "                    <a class=\"nav-link \" href=\"#\">Sign out</a>\n" +
                    "                </li>\n" +
                    "            </ul>\n" +
                    "        </div>\n" +
                    "    </nav>");
        }
        if (!flag) {
            out.println(
                    "    <div class=\"container\" style=\"padding-top: 2.5em\">\n" +
                            "        <div style=\"background-color: #4267B2\">\n" +
                            "            <center><img class=\"img-fluid\" src=\"https://i.imgur.com/fGlE2tP.png\" alt=\"image\"></center>\n" +
                            "        </div>\n" +
                            "        <div class=\"jumbotron\">\n" +
                            "            <p class=\"lead\">Welcome on Miagebook, this is our last project of CAR, and we are supposed to create a little social network.</p>\n" +
                            "            <hr class=\"my-4\">\n" +
                            "            <p>We made it using: IntelliJ IDEA and Brackets. We also used Java, JavaScript, Ajax, HTMl, Bootstrap, JQuery.</p>\n" +
                            "            <p class=\"lead\">\n" +
                            "                <a class=\"btn btn-primary btn-lg\" href=\"/login\" role=\"button\">Try me !</a>\n" +
                            "            </p>\n" +
                            "        </div>\n" +
                            "        <div class=\"card\">\n" +
                            "            <div class=\"card-header\">Quote of the day</div>\n" +
                            "            <div class=\"card-body\">\n" +
                            "                <blockquote class=\"blockquote mb-0\">\n" +
                            "                    <p>As long as he lives, he's not dead !</p>\n" +
                            "                    <footer class=\"blockquote-footer\">Océane Pruvost in <cite title=\"Source Title\">Association MIAGE Lille</cite></footer>\n" +
                            "                </blockquote>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "\n" +
                            "    </div>\n");
        } else {

        }
        out.println(
                "</body>\n" +
                        "\n" +
                        "</html>\n");
    }
}
