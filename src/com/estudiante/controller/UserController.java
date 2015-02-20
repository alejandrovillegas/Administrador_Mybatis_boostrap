package com.estudiante.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import com.estudiante.dao.UserDao;
import com.estudiante.model.user;
import map.EstudiantesMapper;
import model.Estudiantes;
import com.estudiante.dao.DaoEstudiantes;

;

@SuppressWarnings({ "serial", "unused" })
public class UserController extends HttpServlet {

	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_ESTUDIANTES = "/listUser.jsp";

	private UserDao dao;

	String forward;

	DaoEstudiantes daoEstudiante; // EstudiantesDao estudiantesDAO
	UserDao UserDao; // UserDao userDao

	public UserController() {
		super();
		daoEstudiante = new UserDao();
		UserDao = new UserDao();

		// ApplicationContext beanFactoryMyBatis = new
		// ClassPathXmlApplicationContext(
		// new String[] {"/Spring-config.xml"});

		// EstudiantesMapper tuMapper = (EstudiantesMapper)
		// beanFactoryMyBatis.getBean("EstudiantesMapper");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("listUser")) {
			forward = LIST_ESTUDIANTES;
			List<Estudiantes> list = daoEstudiante.getAllEmployees();
			request.setAttribute("estudiantes", list);
			request.setAttribute("searchmessage", "");
		} else if (action.equals("edit")) {
			forward = INSERT_OR_EDIT;
			String id = request.getParameter("id");
			Estudiantes estudiante = daoEstudiante.getEmployeeById(Integer.parseInt(id));
			request.setAttribute("estudiantes", estudiante);
		} else if (action.equalsIgnoreCase("delete")) {
			forward = LIST_ESTUDIANTES;
			String id = request.getParameter("id");
			Estudiantes estudiante = new Estudiantes();
			estudiante.setId(Integer.valueOf(id));
			daoEstudiante.deleteEmployee(estudiante);
			List<Estudiantes> list = daoEstudiante.getAllEmployees();
			request.setAttribute("estudiantes", list);
			request.setAttribute("searchmessage", "");
		} else if (action.equalsIgnoreCase("Consultar")) {
			forward = LIST_ESTUDIANTES;
			String id = request.getParameter("id");
			if (id == null || id.trim().isEmpty()){
				request.setAttribute("searchmessage",
						"Dato No valido");
					List<Estudiantes> list = daoEstudiante.getAllEmployees();
					request.setAttribute("estudiantes", list);
			}else{
				
				Estudiantes estudiante = new Estudiantes();
				estudiante.setId(Integer.valueOf(id));
				List<Estudiantes> estudlist = daoEstudiante
						.getAllestudiantesById(Integer.parseInt(id));
				if (estudlist.isEmpty()) {
					request.setAttribute("estudiantes",
							daoEstudiante.getAllEmployees());
					request.setAttribute("searchmessage",
							"El estudiante buscado no ha sido encontrado");
				} else {
					request.setAttribute("estudiantes",
							daoEstudiante.getAllestudiantes(Integer.valueOf(id)));
					request.setAttribute("searchmessage", "");
				}
			}

		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Estudiantes estudiante = new Estudiantes();
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		
			estudiante.setNombre(request.getParameter("nombre"));
			estudiante.setN1(new BigDecimal(request.getParameter("n1")));
			estudiante.setN2(new BigDecimal(request.getParameter("n2")));
			estudiante.setN3(new BigDecimal(request.getParameter("n3")));
			estudiante.setN4(new BigDecimal(request.getParameter("n4")));

			int idInt = 0;
			try {
				idInt = Integer
						.parseInt(id == null || id.equals("") ? "0" : id);
			} catch (Exception e) {
				System.out.println("error:" + e);
			}
			estudiante.setId(idInt);

			try {
				if (idInt == 0) {
					daoEstudiante.addEmployee(estudiante);
				} else {
					daoEstudiante.updateEmployee(estudiante);
				}

			} catch (Exception e) {
				System.out.println("error:" + e);
			}

			RequestDispatcher view = request
					.getRequestDispatcher("listUser.jsp");
			List<Estudiantes> list = daoEstudiante.getAllEmployees();
			request.setAttribute("estudiantes", list);
			view.forward(request, response);
	}
}
