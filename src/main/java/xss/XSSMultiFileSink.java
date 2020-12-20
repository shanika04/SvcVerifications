package xss;
import org.owasp.encoder.Encode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XSSMultiFileSink {

    public void sink(String name, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String vul = email + name;
        try {
            response.setContentType("text/html");
            PrintWriter out = ((HttpServletResponse)null).getWriter();
            out.write("<br><br>Unsafe quoted attribute:<br>");
            out.write("<button value=\"" + vul + "\">Unsafe quoted attribute</button>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}