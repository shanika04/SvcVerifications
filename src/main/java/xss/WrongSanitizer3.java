package xss;

import org.owasp.encoder.Encode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WrongSanitizer3 {
    //XssTest90
    HttpServletRequest request;
    HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        String name = request.getParameter("name");
        unsafe(name);
    }

    private void unsafe(String name) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<br><br>Unsafe CSS style attribute context:<br>");
//            out.write("<div style=\"color:" + Encode.forCssString(name) + "\">");
            out.write("<div style=\"color:" + Encode.forJavaScriptAttribute(name) + "\">");
            out.write("<h1>TEXT</h1>");
            out.write("</div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}