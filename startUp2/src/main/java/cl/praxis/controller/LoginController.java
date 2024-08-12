package cl.praxis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.dao.IRolesDAO;
import cl.praxis.dao.IUsuariosDAO;
import cl.praxis.dao.RolesDAOImpl;
import cl.praxis.dao.UsuariosDAOImpl;
import cl.praxis.model.UsuarioDTO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		IUsuariosDAO pDAO = new UsuariosDAOImpl();
		UsuarioDTO user= pDAO.read( request.getParameter("correo"),request.getParameter("password"));
		System.out.println("usuarioEncontrdo"+user);
		
		IRolesDAO iDAO = new RolesDAOImpl();
		int idAdmin = iDAO.idAdmin();
		System.out.println("idAmin="+idAdmin);
		int rolUser =iDAO.userRol(user.getId()); 
		System.out.println("rolUser="+rolUser);
		if(idAdmin == rolUser) {
			System.out.println("Es admin");
			List<UsuarioDTO> users =new ArrayList<UsuarioDTO>();
			users = pDAO.read();
			System.out.println(users);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);	
		}
		else {
			System.out.println("No es admin");
			response.sendRedirect("error.jsp");
		}
		}catch (Exception e) {
			System.out.println("Error Null Pointer Excetion Login");
			response.sendRedirect("error.jsp");
		}
		
	}

}
