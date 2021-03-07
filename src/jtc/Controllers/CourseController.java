package jtc.Controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtc.Course.JtcCourse;
import jtc.Course.JtcCourseDAO;
import jtc.Course.JtcCourseDAOImpl;

@WebServlet(urlPatterns = { "/jtc_get_course", "/jtc_set_course", "/jtc_delete_course", "/jtc_update_course" })

public class CourseController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.endsWith("jtc_get_course")) {
			JtcCourseDAO dao = new JtcCourseDAOImpl();
			List<JtcCourse> list = dao.getAllCourse();
			Iterator<JtcCourse> iterator = list.iterator();
			System.out.println("Courses Are = ");
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} else if (url.endsWith("jtc_set_course")) {
			JtcCourseDAO dao = new JtcCourseDAOImpl();
			JtcCourse course = new JtcCourse();
			course.setJtc_course_category_id(1);
			course.setJtc_course_Discription("Testing...");
			course.setJtc_course_duration_in_hrs("45 hrs");
			course.setJtc_course_modes("Classroom training");
			course.setJtc_course_name("Core Java");
			course.setJtc_course_price(85);
			course.setJtc_upcoming_batch_details_id(1);
			int status = dao.saveJtcCourse(course);
			System.out.println("Course Saved Status = " + status);

		} else if (url.endsWith("jtc_delete_course")) {
			JtcCourseDAO dao = new JtcCourseDAOImpl();
			int status = dao.deleteCourse(1);
			System.out.println("Course Deleation status = " + status);
		} else if (url.endsWith("jtc_update_course")) {
			JtcCourse course = new JtcCourse();
			course.setJtc_course_category_id(1);
			course.setJtc_course_Discription("Testing...Update");
			course.setJtc_course_duration_in_hrs("45 hrs");
			course.setJtc_course_modes("Classroom training");
			course.setJtc_course_name("Core Java Update");
			course.setJtc_course_price(85);
			course.setJtc_upcoming_batch_details_id(1);
			course.setJtc_course_id(2);
			JtcCourseDAO dao = new JtcCourseDAOImpl();
			int status = dao.updateCourse(course, course.getJtc_course_id());
			System.out.println("Course Updation status = " + status);
		}
	}
}
