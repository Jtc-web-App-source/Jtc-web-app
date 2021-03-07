package jtc.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		RequestDispatcher dispatcher = null;
		if (url.endsWith("jtc_set_courseCategory.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_set_course_category");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_get_courseCategory.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_get_course_category");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_delete_course_category.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_delete_course_category");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_update_course_category.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_update_course_category");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_get_course.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_get_course");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_set_course.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_set_course");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_delete_course.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_delete_course");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_update_course.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_update_course");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_set_batch.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_set_batch");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_get_batch.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_get_batch");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_delete_batch.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_delete_batch");
			dispatcher.forward(request, response);
		} else if (url.endsWith("jtc_update_batch.jtc")) {
			dispatcher = request.getRequestDispatcher("/jtc_update_batch");
			dispatcher.forward(request, response);
		}
	}
}
