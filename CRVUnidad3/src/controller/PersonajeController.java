package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonajeDAO;
import dao.PersonajeDAOImpl;
import model.Personaje;

/**
 * Servlet implementation class PersonajeController
 */
@WebServlet("/PersonajeController")
public class PersonajeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Personaje personaje;
	private List<Personaje> personajes;
	private PersonajeDAO personajeDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonajeController() {
		super();
		// TODO Auto-generated constructor stub
		personaje = new Personaje();
		personajes = new ArrayList<Personaje>();
		personajeDAO = new PersonajeDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			
			personaje.setPosicion_actual(request.getParameter("posicion_actual"));
			personaje.setVelocidad(request.getParameter("velocidad"));
			personaje.setEstado(request.getParameter("estado"));
			if (personaje.getId() == 0L) {
				personajeDAO.createPersonaje(personaje);

			} else {
				personajeDAO.updatePersonaje(personaje);

			}
			personajes = personajeDAO.readAllPersonajes();
			request.setAttribute("personajes", personajes);
			request.getRequestDispatcher("personaje_list.jsp").forward(request, response);

		} else if (request.getParameter("btn_new") != null) {
			personaje = new Personaje();
			request.getRequestDispatcher("personaje_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_edit") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				personaje = personajeDAO.readPersonaje(id);
			} catch (IndexOutOfBoundsException e) {
				personaje = new Personaje();
			}
			request.setAttribute("personaje", personaje);
			request.getRequestDispatcher("personaje_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_delete") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				personajeDAO.deletePersonaje(id);
				personajes = personajeDAO.readAllPersonajes();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("personajes", personajes);
			request.getRequestDispatcher("personaje_list.jsp").forward(request, response);
		} else {
			personajes = personajeDAO.readAllPersonajes();
			request.setAttribute("personajes", personajes);
			request.getRequestDispatcher("personaje_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
