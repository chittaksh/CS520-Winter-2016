package hw1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Application;
import models.status;

/**
 * Servlet implementation class AddApplication
 */
@WebServlet("/hw1/AddApplication")
public class AddApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		try {
			request.getRequestDispatcher("AddApplication.jsp").include(request, response);
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			request.getRequestDispatcher("AddApplication.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		try {
			String strName = request.getParameter("name").trim();
			String strDate = request.getParameter("date").trim();
			String strGPA = request.getParameter("gpa").trim();
			String strStatus = request.getParameter("status").trim();

			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			float b;
			if (strGPA.isEmpty()) {
				b = (float) 0.0;
			} else {
				b = Float.parseFloat(strGPA);
			}

			ArrayList<Application> Applications = (ArrayList<Application>) getServletContext()
					.getAttribute("Applications");

			Applications.add(new Application(Applications.size() + 1, strName, sdf.parse(strDate), b,
					status.getStatus(Integer.parseInt(strStatus))));

			response.sendRedirect("Main");

		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			request.getRequestDispatcher("AddApplication.jsp").include(request, response);
		}
	}

}
