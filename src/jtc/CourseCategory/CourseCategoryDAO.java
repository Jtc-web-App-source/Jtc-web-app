package jtc.CourseCategory;

import java.util.List;

public interface CourseCategoryDAO {
	public int saveCourseCategory(JtcCourseCategory category) throws Exception;

	public List<JtcCourseCategory> getCourseCategory();

	public int deleteCourseCategory(JtcCourseCategory category);

	public int updateCourseCategory(JtcCourseCategory category,int courseCategoryId);
}
