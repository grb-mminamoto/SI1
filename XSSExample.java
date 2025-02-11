import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class XSSExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("username");

        // Vulnerabilidade: XSS (não há sanitização ou escape do input do usuário)
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Bem-vindo, !</h1>");  // Usuário fornecido diretamente no HTML
        response.getWriter().println("</body></html>");
    }
}
