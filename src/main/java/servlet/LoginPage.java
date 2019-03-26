package servlet;

import model.InBeforeBDD;
import model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginPage extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();


//        if(username.equals("")) {
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
                "                    <a class=\"nav-link active\" href=\"/SimpleServlet-1/signin\">Sign in</a>\n" +
                "                </li>\n" +
                "                <li class=\"nav-item\">\n" +
                "                    <a class=\"nav-link\" href=\"/SimpleServlet-1/signup\">Sign up</a>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "    <div class=\"container\" style=\"padding-top: 2.5em\">\n" +
                "        <form action=\"/SimpleServlet-1/miagebook\" method=\"post\">\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"inputEmail\">Email address</label>\n" +
                "                <input type=\"email\" name=\"inputEmail\" class=\"form-control\" id=\"inputEmail\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n" +
                "                <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"inputPassword\">Password</label>\n" +
                "                <input type=\"password\" name=\"inputPassword\" class=\"form-control\" id=\"inputPassword\" placeholder=\"Password\">\n" +
                "            </div>\n");
        if (reqest.getParameter("pass").equals("error")) {
            out.println(
                    "            <div>\n" +
                            "                <label class=\"text-danger\">Wrong password or email.</label>\n" +
                            "            </div>\n");
        }

        out.println(
                "            <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
                        "        </form>\n" +
                        "    </div>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "    <!-- Coding End -->\n" +
                        "\n" +
                        "    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" +
                        "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
                        "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n" +
                        "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("inputEmail");
        String password = req.getParameter("inputPassword");
        User u = InBeforeBDD.getInstance().getUser(email, password);
        if (u != null) {
            Cookie cookie = new Cookie("miagebook_mail", u.getEmail());
            cookie.setMaxAge(60 * 60 * 24); //cookie set for 1 day
            Cookie cookie1 = new Cookie("miagebook_password", u.getPassword());
            cookie1.setMaxAge(60 * 60 * 24); //cookie set for 1 day

            resp.addCookie(cookie);
            resp.addCookie(cookie1);

            AccueilPage ap = new AccueilPage();
            resp.sendRedirect("/SimpleServlet-1/miagebook");
        } else {
            resp.sendRedirect("/SimpleServlet-1/signin?pass=error");
        }

    }

    @Override
    public void init() {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
