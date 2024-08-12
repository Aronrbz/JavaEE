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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int numero1 = Integer.parseInt(request.getParameter("numero1"));
            int numero2 = Integer.parseInt(request.getParameter("numero2"));
            String operacion = request.getParameter("operacion");
            
            int resultado = 0;
            String resultadoStr = "";

            switch (operacion) {
                case "suma":
                    resultado = numero1 + numero2;
                    resultadoStr = "La suma de " + numero1 + " y " + numero2 + " es: " + resultado;
                    break;
                case "resta":
                    resultado = numero1 - numero2;
                    resultadoStr = "La resta de " + numero1 + " y " + numero2 + " es: " + resultado;
                    break;
                case "multiplicacion":
                    resultado = numero1 * numero2;
                    resultadoStr = "La multiplicación de " + numero1 + " y " + numero2 + " es: " + resultado;
                    break;
                case "division":
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                        resultadoStr = "La división de " + numero1 + " entre " + numero2 + " es: " + resultado;
                    } else {
                        resultadoStr = "Error: No se puede dividir por cero.";
                    }
                    break;
                case "ordenar":
                    resultadoStr = "Los números ordenados son: " + Math.min(numero1, numero2) + ", " + Math.max(numero1, numero2);
                    break;
                case "paridad":
                    resultadoStr = "El número " + numero1 + " es " + (numero1 % 2 == 0 ? "par" : "impar") + 
                                   " y el número " + numero2 + " es " + (numero2 % 2 == 0 ? "par" : "impar");
                    break;
            }
            
            // Redirigir al archivo JSP resultado en la nueva ubicación
            request.setAttribute("resultado", resultadoStr);
            request.getRequestDispatcher("assets/html/resultado.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            // Redirigir al archivo JSP de error en la nueva ubicación
            response.sendRedirect("assets/html/error.jsp");
        }
    }
}
