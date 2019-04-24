package servlet;

import model.InBeforeBDD;
import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class FriendsPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        if (InBeforeBDD.getInstance().isConnected(req)) {
            User current_user = InBeforeBDD.getInstance().getUser(req);
            List<User> notFriend = InBeforeBDD.getInstance().getUsers().stream().filter(x -> !current_user.getFriends().contains(x) && !x.getEmail().equals(current_user.getEmail())).collect(Collectors.toList());
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "\n" +
                    "<head>\n" +
                    "    <!-- Required meta tags -->\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <meta name=\"description\" content=\"log in page for miagebook\">\n" +
                    "    <meta name=\"author\" content=\"Simon Vandeputte\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                    "\n" +
                    "    <title>Miagebook - Login Page</title>\n" +
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
                    "<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
                    "    <div class=\"navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2\">\n" +
                    "        <ul class=\"navbar-nav mr-auto\">\n" +
                    "            <li class=\"nav-item\">\n" +
                    "                <a class=\"nav-link\" href=\"#\">Home</a>\n" +
                    "            </li>\n" +
                    "        </ul>\n" +
                    "    </div>\n" +
                    "    <div class=\"mx-auto order-0\">\n" +
                    "        <a class=\"navbar-brand mx-auto\" href=\"#\">miagebook</a>\n" +
                    "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\".dual-collapse2\">\n" +
                    "            <span class=\"navbar-toggler-icon\"></span>\n" +
                    "        </button>\n" +
                    "    </div>\n" +
                    "    <div class=\"navbar-collapse collapse w-100 order-3 dual-collapse2\">\n" +
                    "        <ul class=\"navbar-nav ml-auto\">\n" +
                    "            <li class=\"nav-item\">\n" +
                    "                <a class=\"nav-link active\" href=\"#\">log out</a>\n" +
                    "            </li>\n" +
                    "\n" +
                    "        </ul>\n" +
                    "    </div>\n" +
                    "</nav>\n" +
                    "\n" +
                    "<div class=\"container\" style=\"padding-top: 2.5em\">\n" +
                    "<table class=\"table table-borderless\">\n<tbody>\n");
            for (User u : notFriend) {
                out.println("                <tr>\n" +
                        "                    <td>" + u.getFirstname() + "</td>\n" +
                        "                    <td>" + u.getLastname() + "</td>\n" +
                        "                    <td><button onclick=\"addFriend('" + u.getEmail() + "')\" type=\"button\" id=\"" + u.getEmail() + "\" class=\"btn btn-success\">Add Friend...</button></td>\n" +
                        "                </tr>\n");
            }
            out.println("</tbody>" +
                    "</table>" +
                    "<script>\n" +
                    "                function addFriend(mail) {\n" +
                    "                    $.ajax({\n" +
                    "                        type: 'POST',\n" +
                    "                        url: \"v1/friend/\" + '" + current_user.getEmail() + "',\n" +
                    "                        contentType: \"application/json\",\n" +
                    "                        dataType: \"json\",\n" +
                    "                        data: JSON.stringify({\"email\":mail}),\n" +
                    "                        success: (data, textStatus, jqXHR) => {\n" +
                    "                           location.reload();\n" +
                    "                        },\n" +
                    "                        error: (jqXHR, textStatus, errorThrown) => {\n" +
                    "                           alert(textStatus);\n" +
                    "                           location.reload();\n" +
                    "                        }\n" +
                    "                    });\n" +
                    "                }\n" +
                    "\n" +
                    "            </script></body></html>");


        } else {
            resp.sendRedirect("/SimpleServlet-1/miagebook");
        }
    }
}
