package jtc.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jtc.DBConfuration.DBConfiguration;

public class JtcCourseDAOImpl implements JtcCourseDAO {
	private Connection connection = null;

	@Override
	public int saveJtcCourse(JtcCourse course) {
		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into jtc_course_master values(?,?,?,?,?,?,?,?)");
			Statement statement2 = connection.createStatement();
			ResultSet resultSet = statement2.executeQuery("select max(course_id) from jtc_course_master");
			int count = 0;
			int cid = 0;
			while (resultSet.next()) {
				count++;
				cid = resultSet.getInt(1);
			}
			if (count == 0) {
				statement.setInt(1, cid);
			} else {
				statement.setInt(1, cid + 1);
			}
			statement.setString(2, course.getJtc_course_name());
			statement.setString(3, course.getJtc_course_Discription());
			statement.setString(4, course.getJtc_course_modes());
			statement.setInt(5, course.getJtc_upcoming_batch_details_id());
			statement.setDouble(6, course.getJtc_course_price());
			statement.setString(7, course.getJtc_course_duration_in_hrs());
			statement.setInt(8, course.getJtc_course_category_id());
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<JtcCourse> getAllCourse() {
		List<JtcCourse> list = new ArrayList<JtcCourse>();
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from jtc_course_master");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				JtcCourse course = new JtcCourse();
				course.setJtc_course_id(resultSet.getInt(1));
				course.setJtc_course_name(resultSet.getString(2));
				course.setJtc_course_Discription(resultSet.getString(3));
				course.setJtc_course_modes(resultSet.getString(4));
				course.setJtc_upcoming_batch_details_id(resultSet.getInt(5));
				course.setJtc_course_price(resultSet.getDouble(6));
				course.setJtc_course_duration_in_hrs(resultSet.getString(7));
				course.setJtc_course_category_id(resultSet.getInt(8));
				list.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public JtcCourse getCourseById(int course_id) {
		JtcCourse course = null;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from jtc_course_master where course_id = ?");
			statement.setInt(1, course_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				course = new JtcCourse();
				course.setJtc_course_id(resultSet.getInt(1));
				course.setJtc_course_name(resultSet.getString(2));
				course.setJtc_course_Discription(resultSet.getString(3));
				course.setJtc_course_modes(resultSet.getString(4));
				course.setJtc_upcoming_batch_details_id(resultSet.getInt(5));
				course.setJtc_course_price(resultSet.getDouble(6));
				course.setJtc_course_duration_in_hrs(resultSet.getString(7));
				course.setJtc_course_category_id(resultSet.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public List<JtcCourse> getCourseByCategory(int course_category_id) {
		List<JtcCourse> list = new ArrayList<JtcCourse>();
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from jtc_course_master where course_category_id = ?");
			statement.setInt(1, course_category_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				JtcCourse course = new JtcCourse();
				course.setJtc_course_id(resultSet.getInt(1));
				course.setJtc_course_name(resultSet.getString(2));
				course.setJtc_course_Discription(resultSet.getString(3));
				course.setJtc_course_modes(resultSet.getString(4));
				course.setJtc_upcoming_batch_details_id(resultSet.getInt(5));
				course.setJtc_course_price(resultSet.getDouble(6));
				course.setJtc_course_duration_in_hrs(resultSet.getString(7));
				course.setJtc_course_category_id(resultSet.getInt(8));
				list.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteCourse(int course_id) {
		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("delete from jtc_course_master where course_id = ?");
			statement.setInt(1, course_id);
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int updateCourse(JtcCourse course, int course_id) {
		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update jtc_course_master set COURSE_NAME = ?, COURSE_DISCRIPTION = ?,COURSE_MODE = ?, JTC_UPCOMING_BATCH_DETAILS_ID = ?,COURSE_PRICE = ?, COURSE_DURATION = ?, COURSE_CATEGORY_ID = ? where COURSE_ID = ?");
			statement.setString(1, course.getJtc_course_name());
			statement.setString(2, course.getJtc_course_Discription());
			statement.setString(3, course.getJtc_course_modes());
			statement.setInt(4, course.getJtc_upcoming_batch_details_id());
			statement.setDouble(5, course.getJtc_course_price());
			statement.setString(6, course.getJtc_course_duration_in_hrs());
			statement.setInt(7, course.getJtc_course_category_id());
			statement.setInt(8, course.getJtc_course_id());
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
