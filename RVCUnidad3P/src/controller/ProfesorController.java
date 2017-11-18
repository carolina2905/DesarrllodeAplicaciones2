package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfesorDAO;
import dao.ProfesorDAOImpl;
import model.Profesor;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ProfesorController")
public class ProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Profesor profesor;
	private List<Profesor> profesores;
	private ProfesorDAO profesorDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfesorController() {
		super();
		// TODO Auto-generated constructor stub
		profesor = new Profesor();
		profesores = new ArrayList<Profesor>();
		profesorDAO = new ProfesorDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			profesor.setCve_prof(request.getParameter("cve_prof"));
			profesor.setNombre(request.getParameter("nombre"));
			profesor.setFecha_registro(request.getParameter("fecha_registro"));
			if (profesor.getId_profesor() == 0L) {
				profesorDAO.createProfesor(profesor);

			} else {
				profesorDAO.updateProfesor(profesor);

			}
			profesores = profesorDAO.readAllProfesores();
			request.setAttribute("profesores", profesores);
			request.getRequestDispatcher("profesor_list.jsp").forward(request, response);

		} else if (request.getParameter("btn_new") != null) {
			profesor = new Profesor();
			request.getRequestDispatcher("profesor_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_edit") != null) {
			try {
				Long idProfesor = Long.parseLong(request.getParameter("id_profesor"));
				profesor = profesorDAO.readProfesor(idProfesor);
			} catch (IndexOutOfBoundsException e) {
				profesor = new Profesor();
			}
			request.setAttribute("profesor", profesor);
			request.getRequestDispatcher("profesor_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_delete") != null) {
			try {
				Long idProfesor = Long.parseLong(request.getParameter("id_profesor"));
				profesorDAO.deleteProfesor(idProfesor);
				profesores = profesorDAO.readAllProfesores();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("profesores", profesores);
			request.getRequestDispatcher("profesor_list.jsp").forward(request, response);
		} else {
			profesores = profesorDAO.readAllProfesores();
			request.setAttribute("profesores", profesores);
			request.getRequestDispatcher("profesor_list.jsp").forward(request, response);
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
