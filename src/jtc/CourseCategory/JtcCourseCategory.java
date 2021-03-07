package jtc.CourseCategory;

import java.sql.Date;

public class JtcCourseCategory {
	private int course_category_id;
	private String course_category_name;
	private String launch_date;

	public int getCourse_category_id() {
		return course_category_id;
	}

	public void setCourse_category_id(int course_category_id) {
		this.course_category_id = course_category_id;
	}

	public String getCourse_category_name() {
		return course_category_name;
	}

	public void setCourse_category_name(String course_category_name) {
		this.course_category_name = course_category_name;
	}

	public String getLaunch_date() {
		return launch_date;
	}

	public void setLaunch_date(String launch_date) {
		this.launch_date = launch_date;
	}

	@Override
	public String toString() {
		return "JtcCourseCategory [course_category_id=" + course_category_id + ", course_category_name="
				+ course_category_name + ", launch_date=" + launch_date + "]";
	}

}
