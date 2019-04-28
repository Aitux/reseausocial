package servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutPage extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws IOException {
        Cookie cookie = new Cookie( "miagebook_password", "");
        Cookie cookie1 = new Cookie("miagebook_mail", "");
        cookie.setMaxAge(0);
        cookie1.setMaxAge(0);
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.sendRedirect("/SimpleServlet-1/miagebook");
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
