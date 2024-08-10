package cl.praxis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberParam = request.getParameter("num");

        // Verificar que el parámetro 'num' no sea nulo o vacío
        if (numberParam == null || numberParam.isEmpty()) {
            response.getWriter().append("Error: Parámetro 'num' no proporcionado.");
            return;
        }

        int number;
        try {
            number = Integer.parseInt(numberParam);
        } catch (NumberFormatException e) {
            response.getWriter().append("Error: Parámetro 'num' no es un número válido.");
            return;
        }

        // Calcular el factorial del número
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        // Determinar si el número es par o impar
        boolean isEven = (number % 2 == 0);

        // Responder con el resultado
        response.setContentType("text/html");
        response.getWriter().append("<html><body>");
        response.getWriter().append("<h1>Resultados para el número " + number + "</h1>");
        response.getWriter().append("<p>Factorial: " + factorial + "</p>");
        response.getWriter().append("<p>Es par: " + isEven + "</p>");
        response.getWriter().append("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
