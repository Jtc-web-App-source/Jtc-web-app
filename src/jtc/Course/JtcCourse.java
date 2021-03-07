package jtc.Course;

import java.util.Map;

public class JtcCourse {
	private int jtc_course_id;
	private String jtc_course_name;
	private String jtc_course_Discription;
	private String jtc_course_modes;
	private int jtc_upcoming_batch_details_id;
	private double jtc_course_price;
	private String jtc_course_duration_in_hrs;
	private int jtc_course_category_id;

	public int getJtc_course_category_id() {
		return jtc_course_category_id;
	}

	public void setJtc_course_category_id(int jtc_course_category_id) {
		this.jtc_course_category_id = jtc_course_category_id;
	}

	public int getJtc_course_id() {
		return jtc_course_id;
	}

	public void setJtc_course_id(int jtc_course_id) {
		this.jtc_course_id = jtc_course_id;
	}

	public String getJtc_course_name() {
		return jtc_course_name;
	}

	public void setJtc_course_name(String jtc_course_name) {
		this.jtc_course_name = jtc_course_name;
	}

	public String getJtc_course_Discription() {
		return jtc_course_Discription;
	}

	public void setJtc_course_Discription(String jtc_course_Discription) {
		this.jtc_course_Discription = jtc_course_Discription;
	}

	public String getJtc_course_modes() {
		return jtc_course_modes;
	}

	public void setJtc_course_modes(String jtc_course_modes) {
		this.jtc_course_modes = jtc_course_modes;
	}

	
	public int getJtc_upcoming_batch_details_id() {
		return jtc_upcoming_batch_details_id;
	}

	public void setJtc_upcoming_batch_details_id(int jtc_upcoming_batch_details_id) {
		this.jtc_upcoming_batch_details_id = jtc_upcoming_batch_details_id;
	}

	public double getJtc_course_price() {
		return jtc_course_price;
	}

	public void setJtc_course_price(double jtc_course_price) {
		this.jtc_course_price = jtc_course_price;
	}

	public String getJtc_course_duration_in_hrs() {
		return jtc_course_duration_in_hrs;
	}

	public void setJtc_course_duration_in_hrs(String jtc_course_duration_in_hrs) {
		this.jtc_course_duration_in_hrs = jtc_course_duration_in_hrs;
	}

	@Override
	public String toString() {
		return "JtcCourse [jtc_course_id=" + jtc_course_id + ", jtc_course_name=" + jtc_course_name
				+ ", jtc_course_Discription=" + jtc_course_Discription + ", jtc_course_modes=" + jtc_course_modes
				+ ", jtc_upcoming_batch_details_id=" + jtc_upcoming_batch_details_id + ", jtc_course_price="
				+ jtc_course_price + ", jtc_course_duration_in_hrs=" + jtc_course_duration_in_hrs
				+ ", jtc_course_category_id=" + jtc_course_category_id + "]";
	}

}
