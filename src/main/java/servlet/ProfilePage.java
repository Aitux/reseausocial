package servlet;

import model.InBeforeBDD;
import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfilePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        if (InBeforeBDD.getInstance().isConnected(req)) {
            User current_user = InBeforeBDD.getInstance().getUser(req);
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
                    "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n");
            out.println("<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
                    "        <div class=\"navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2\">\n" +
                    "            <ul class=\"navbar-nav mr-auto\">\n" +
                    "                <li class=\"nav-item\">\n" +
                    "                    <a class=\"nav-link active\" href=\"/SimpleServlet-1/profilepage\">Profile</a>\n" +
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
            out.println("\n" +
                    "<div class=\"container\" style=\"padding-top: 2.5em\">\n" +
                    "<form action=\"\" method=\"post\">\n" +
                    "    <div class=\"form-group\">\n" +
                    "        <label for=\"inputEmail\">Email address</label>\n" +
                    "        <input type=\"email\" class=\"form-control\" name=\"email\" id=\"inputEmail\" aria-describedby=\"emailHelp\" placeholder=\"" + current_user.getEmail() + "\">\n" +
                    "\n" +
                    "    </div>\n" +
                    "\n" +
                    "    <div class=\"form-group\">\n" +
                    "        <label for=\"formControlSelect\">Sexe : " + current_user.getSexe() + " </label>\n" +
                    "        <select class=\"form-control\" id=\"formControlSelect\" name=\"sexe\">\n" +
                    "            <option>Homme</option>\n" +
                    "            <option>Femme</option>\n" +
                    "            <option>Autre</option>\n" +
                    "        </select>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "        <label class=\"col-sm-2 col-form-label\" for=\"formControlInput\">First Name</label>\n" +
                    "        <div class=\"col-sm-4\">\n" +
                    "            <input type=\"text\" name=\"fname\" class=\"form-control\" id=\"formControlInput\" placeholder=\"" + current_user.getFirstname() + "\"\">\n" +
                    "        </div>\n" +
                    "        <label class=\"col-sm-2 col-form-label\" for=\"formControlInput\">Last Name</label>\n" +
                    "        <div class=\"col-sm-4\">\n" +
                    "            <input type=\"text\" name=\"lname\" class=\"form-control\" id=\"formControlInput2\" placeholder=\"" + current_user.getLastname() + "\"\">\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group\">\n" +
                    "        <label for=\"inputPassword\">Password</label>\n" +
                    "        <input type=\"password\" name=\"password\" class=\"form-control\" id=\"inputPassword\" placeholder=\"\">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group\">\n" +
                    "        <label for=\"inputPassword\">Repeat Password</label>\n" +
                    "        <input type=\"Password\" name=\"repeatpassword\" class=\"form-control\" id=\"repeatPassword\" placeholder=\"\">\n" +
                    "    </div>\n" +
                    "\n" +
                    "\n" +
                    "    <div class=\"form-group\">\n" +
                    "        <h3>Friend List</h3><hr>\n" +
                    "<table class=\"table table-borderless\">\n<tbody>\n");
            for (User u :
                    current_user.getFriends()) {
                out.println("<tr>\n" +
                        "<td>" + u.getFirstname() + " " + u.getLastname() + "</td>\n" +
                        "<td><button onclick=\"removeFriend('" + u.getEmail() + "')\" type=\"button\" class=\"btn btn-danger\">Remove friend...</button></td>\n" +
                        "</tr>\n");
            }

            out.println("        </tbody></table>" +
                    "    </div>\n" +
                    "    <button type=\"submit\" class=\"btn btn-primary\">Update my profile</button>\n" +
                    "</form>\n" +
                    "\n" +
                    "</div>\n" +
                    "<!-- Coding End -->\n" +
                    "\n" +
                    "<!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" +
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n" +
                    "<script>\n" +
                    "                function removeFriend(mail) {\n" +
                    "                    $.ajax({\n" +
                    "                        type: 'POST',\n" +
                    "                        url: \"v1/friend/delete/\" + '" + current_user.getEmail() + "',\n" +
                    "                        contentType: \"application/json\",\n" +
                    "                        dataType: \"json\",\n" +
                    "                        data: JSON.stringify({\"email\":mail}),\n" +
                    "                        success: (data, textStatus, jqXHR) => {\n" +
                    "                           location.reload();\n" +
                    "                        },\n" +
                    "                        error: (jqXHR, textStatus, errorThrown) => {\n" +
                    "                           location.reload();\n" +
                    "                        }\n" +
                    "                    });\n" +
                    "                }\n" +
                    "\n" +
                    "            </script>" +
                    "</body>\n" +
                    "</html>");
        } else {
            resp.sendRedirect("/SimpleServlet-1/miagebook");
        }

    }
}
