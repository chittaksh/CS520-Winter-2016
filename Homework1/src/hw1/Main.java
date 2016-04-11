package hw1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Application;
import models.status;

/**
 * Servlet implementation class Main
 */
@WebServlet("/hw1/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			super.init(config);

			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			ArrayList<Application> Applications = new ArrayList<Application>();

			Applications.add(new Application(1, "John Doe", sdf.parse("10/21/2015"), (float) 3.1, status.Review));
			Applications.add(new Application(2, "Jane Doe", sdf.parse("03/20/2015"), 0, status.Incomplete));
			Applications.add(new Application(3, "Amy Smith", sdf.parse("03/01/2015"), (float) 3.3, status.Accepted));

			getServletContext().setAttribute("Applications", Applications);
			getServletContext().setAttribute("status", status.values());
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			ArrayList<Application> Applications = (ArrayList<Application>) getServletContext()
					.getAttribute("Applications");

			if (request.getParameter("SortBy") != null) {
				switch (request.getParameter("SortBy")) {

				case "name":
					Collections.sort(Applications, Application.sortByName);
					break;

				case "date":
					Collections.sort(Applications, Application.sortByDate);
					break;

				case "gpa":
					Collections.sort(Applications, Application.sortByGpa);
					break;

				case "status":
					Collections.sort(Applications, Application.sortByStatus);
					break;

				default:
					Collections.sort(Applications, Application.sortByDate);
					break;
				}
			} else {
				Collections.sort(Applications, Application.sortByDate);
			}

			response.sendRedirect("Main.jsp");
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			request.getRequestDispatcher("Main.jsp").include(request, response);
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
	}

}
