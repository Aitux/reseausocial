import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignupPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

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
                "    <!-- Start coding here -->\n" +
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
                "                    <a class=\"nav-link active\" href=\"/SimpleServlet-1/signup\">Sign up</a>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "\n" +
                "    <div class=\"container\" style=\"padding-top: 2.5em\">\n" +
                "        <form action=\"\" method=\"post\">\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"inputEmail\">Email address</label>\n" +
                "                <input type=\"email\" class=\"form-control\" name=\"email\" id=\"inputEmail\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n" +
                "                <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"inputPassword\">Password</label>\n" +
                "                <input type=\"password\" name=\"password\" class=\"form-control\" id=\"inputPassword\" placeholder=\"Password\">\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"formControlSelect\">Sexe</label>\n" +
                "                <select class=\"form-control\" id=\"formControlSelect1\" name=\"sexe\">\n" +
                "                    <option>Homme</option>\n" +
                "                    <option>Femme</option>\n" +
                "                    <option>Autre</option>\n" +
                "                </select>\n" +
                "            </div>\n" +
                "            <div class=\"form-group row\">\n" +
                "                <label class=\"col-sm-2 col-form-label\" for=\"formControlInput\">First Name</label>\n" +
                "                <div class=\"col-sm-4\">\n" +
                "                    <input type=\"text\" name=\"name\" class=\"form-control\" id=\"formControlInput\" placeholder=\"John\">\n" +
                "                </div>\n" +
                "                <label class=\"col-sm-2 col-form-label\" for=\"formControlInput\">Last Name</label>\n" +
                "                <div class=\"col-sm-4\">\n" +
                "                    <input type=\"text\" name=\"name\" class=\"form-control\" id=\"formControlInput\" placeholder=\"Doe\">\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "            <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
                "        </form>\n" +
                "\n" +
                "    </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>\n");
    }
}
