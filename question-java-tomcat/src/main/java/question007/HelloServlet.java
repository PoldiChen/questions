package question007;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author poldi.chen
 * @className HelloServlet
 * @description TODO
 * @date 2019/6/25 11:11
 **/
public class HelloServlet extends HttpServlet {

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("Java Servlet");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("hello world");
        out.println("</body>");
        out.println("</html>");
    }
}
