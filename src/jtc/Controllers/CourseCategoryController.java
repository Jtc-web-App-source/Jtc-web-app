package jtc.Controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jtc.Course.JtcCourseDAOImpl;
import jtc.CourseCategory.CourseCategoryDAO;
import jtc.CourseCategory.CourseCategoryImpl;
import jtc.CourseCategory.JtcCourseCategory;

@WebServlet(urlPatterns = { "/jtc_get_course_category", "/jtc_set_course_category", "/jtc_delete_course_category",
		"/jtc_update_course_category", "/get_course_category" })

public class CourseCategoryController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.endsWith("jtc_set_course_category")) {
			CourseCategoryDAO categoryDAO = new CourseCategoryImpl();
			// Dummy Data...
			JtcCourseCategory category = new JtcCourseCategory();
			category.setCourse_category_name("Programming And Framework");
			SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");
			category.setLaunch_date(formatter.format(new java.util.Date()));
			try {
				categoryDAO.saveCourseCategory(category);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.endsWith("/jtc_get_course_category")) {
			CourseCategoryDAO categoryDAO = new CourseCategoryImpl();
			List<JtcCourseCategory> category = categoryDAO.getCourseCategory();
			System.out.println("Course Category Data :- ");
			Iterator<JtcCourseCategory> iterator = category.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} else if (uri.endsWith("/jtc_delete_course_category")) {
			CourseCategoryDAO categoryDAO = new CourseCategoryImpl();
			JtcCourseCategory category = new JtcCourseCategory();
			category.setCourse_category_id(1);
			System.out.println("Delete Status = " + categoryDAO.deleteCourseCategory(category));
		} else if (uri.endsWith("jtc_update_course_category")) {
			JtcCourseCategory category = new JtcCourseCategory();
			category.setCourse_category_name("Python and Framework");
			category.setCourse_category_id(3);
			CourseCategoryDAO categoryDAO = new CourseCategoryImpl();
			System.out.println(categoryDAO.updateCourseCategory(category, category.getCourse_category_id()));
		} else if (uri.endsWith("/get_course_category")) {
			CourseCategoryDAO dao = new CourseCategoryImpl();
			List<JtcCourseCategory> list = dao.getCourseCategory();
			Gson gson = new Gson();
			response.getWriter().print(gson.toJson(list));
		}
	}
}
