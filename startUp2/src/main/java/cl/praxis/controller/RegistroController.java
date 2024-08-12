package cl.praxis.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.dao.UsuariosDAOImpl;
import cl.praxis.model.DireccionesDTO;
import cl.praxis.model.RolesDTO;
import cl.praxis.model.Roles_usuariosDTO;
import cl.praxis.model.UsuarioDTO;
import cl.praxis.dao.DireccionesDAOImpl;
import cl.praxis.dao.IDireccionesDAO;
import cl.praxis.dao.IRolesDAO;
import cl.praxis.dao.IUsuariosDAO;
import cl.praxis.dao.RolesDAOImpl;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/Registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IRolesDAO rolesDao =  new RolesDAOImpl();
		List<RolesDTO> rolesDTO = new ArrayList<RolesDTO>();
		rolesDTO = rolesDao.read();
		request.setAttribute("roles", rolesDTO);
		getServletContext().getRequestDispatcher("/registro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUsuariosDAO pDAO = new UsuariosDAOImpl();
		if (!pDAO.verificaEmail(request.getParameter("correo"))) {
			Date create=new Date();
			Date update=new Date();
			pDAO.create(new UsuarioDTO( request.getParameter("correo"),request.getParameter("nick"),
					request.getParameter("nombre"),request.getParameter("password"),
					Integer.parseInt(request.getParameter("peso")),create,update));
			
			int idUser = pDAO.read(request.getParameter("correo")).getId();
			
			IDireccionesDAO dDAO = new DireccionesDAOImpl();
			dDAO.create(new DireccionesDTO(request.getParameter("nombre"),request.getParameter("numeracion"),idUser));
			
			IRolesDAO iDAO = new RolesDAOImpl();
			iDAO.create(new Roles_usuariosDTO(idUser,Integer.parseInt(request.getParameter("rol"))));
		}
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
