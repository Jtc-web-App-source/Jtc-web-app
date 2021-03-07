package jtc.Course;

import java.util.List;

import jtc.CourseCategory.JtcCourseCategory;

public interface JtcCourseDAO {
	public int saveJtcCourse(JtcCourse course);

	public List<JtcCourse> getAllCourse();

	public JtcCourse getCourseById(int course_id);

	public List<JtcCourse> getCourseByCategory(int course_category_id);

	public int deleteCourse(int course_id);

	public int updateCourse(JtcCourse course, int course_id);
	
}
