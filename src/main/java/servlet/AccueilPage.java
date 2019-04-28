package servlet;

import model.InBeforeBDD;
import model.StatusGenerator;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AccueilPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        User current_user = InBeforeBDD.getInstance().getUser(req);
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
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n" +
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
                    "                    <a class=\"nav-link\" href=\"/SimpleServlet-1/profilepage\">Profile</a>\n" +
                    "                </li>\n" +
                    "                <li class=\"nav-item\">\n" +
                    "                    <a class=\"nav-link\" href=\"/SimpleServlet-1/friend\">Add Friend</a>\n" +
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
                    "                    <span class=\"nav-link\">Bonjour, " + InBeforeBDD.getInstance().getUser(req).getFirstname() + "</span>\n" +
                    "                </li>\n" +
                    "                <li class=\" nav-item\">\n" +
                    "                    <a class=\"nav-link \" href=\"/SimpleServlet-1/logout\">Sign out</a>\n" +
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


            out.println("<div class=\"container\" style=\"padding-top: 2.5em\">\n");
            out.println(" <div class=\"form-group\">\n" +
                    "            <textarea class=\"form-control\" id=\"status\" rows=\"3\" placeholder=\"What's on your mind ?\"></textarea>\n" +
                    "            <button onclick=\"postStatus()\" type=\"button\" class=\"btn btn-outline-primary btn-block\">Create Status</button>\n" +
                    "        </div>");

            current_user.getLatestStatus().forEach(x -> {
                out.println(StatusGenerator.generateStatus(x));
            });
            out.println("</div>");
            out.println("<script>\n" +
                    " function postComment(idx) {\n" +
                    "            let x = $(\"#comment_\" + idx).val();\n" +
                    "            $.ajax({\n" +
                    "                type: 'POST',\n" +
                    "                url: \"v1/commentaire/" + current_user.getEmail() + "/\" + idx,\n" +
                    "                contentType: \"application/json\",\n" +
                    "                dataType: \"json\",\n" +
                    "                data: JSON.stringify({\n" +
                    "                    \"commentaire\": x\n" +
                    "                }),\n" +
                    "                success: (data, textStatus, jqXHR) => {\n" +
                    "                    location.reload();\n" +
                    "                },\n" +
                    "                error: (jqXHR, textStatus, errorThrown) => {\n" +
                    "                    location.reload();\n" +
                    "                }\n" +
                    "\n" +
                    "            });\n" +
                    "}" +
                    "\n" +
                    "    </script>\n");
            out.println("<script>\n" +
                    "   function postStatus() {\n" +
                    "            let x = $(\"#status\").val();\n" +
                    "            $.ajax({\n" +
                    "                type: 'POST',\n" +
                    "                url: \"v1/status/"+current_user.getEmail()+"\",\n" +
                    "                contentType: \"application/json\",\n" +
                    "                dataType: \"json\",\n" +
                    "                data: JSON.stringify({\n" +
                    "                    \"status\": x\n" +
                    "                }),\n" +
                    "                success: (data, textStatus, jqXHR) => {\n" +
                    "                    location.reload();\n" +
                    "                },\n" +
                    "                error: (jqXHR, textStatus, errorThrown) => {\n" +
                    "                    console.log(\"error\");\n" +
                    "                    location.reload();\n" +
                    "                }\n" +
                    "\n" +
                    "            });\n" +
                    "        }" +
                    "\n" +
                    "    </script>");
        }
        out.println(
                "</body>\n" +
                        "\n" +
                        "</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
