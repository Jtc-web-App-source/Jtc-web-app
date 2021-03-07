package jtc.CourseCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jtc.DBConfuration.DBConfiguration;
import oracle.jdbc.driver.DBConversion;

public class CourseCategoryImpl implements CourseCategoryDAO {
	private Connection connection = null;
	private ResultSet resultset = null;

	@Override
	public int saveCourseCategory(JtcCourseCategory category) throws Exception {
		connection = DBConfiguration.getConnection();
		String sql = "insert into jtc_course_category values(?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		resultset = connection.createStatement()
				.executeQuery("select max(course_category_id) from jtc_course_category");
		int count = 0;
		int ccid = 1;
		while (resultset.next()) {
			count++;
			ccid = resultset.getInt(1);
			System.out.println("-----> " + ccid);
		}
		if (count == 0) {
			statement.setInt(1, ccid);
		} else {
			statement.setInt(1, ccid + 1);
		}
		statement.setString(2, category.getCourse_category_name());
		statement.setString(3, category.getLaunch_date());

		return statement.executeUpdate();
	}

	@Override
	public List<JtcCourseCategory> getCourseCategory() {
		List<JtcCourseCategory> list = new ArrayList<JtcCourseCategory>();
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from jtc_course_category");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				JtcCourseCategory category = new JtcCourseCategory();
				category.setCourse_category_id(resultSet.getInt(1));
				category.setCourse_category_name(resultSet.getString(2));
				category.setLaunch_date(resultSet.getString(3));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteCourseCategory(JtcCourseCategory category) {
		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("delete from jtc_course_category where COURSE_CATEGORY_ID = ?");
			statement.setInt(1, category.getCourse_category_id());
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateCourseCategory(JtcCourseCategory category, int courseCategoryId) {

		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update jtc_course_category set COURSE_CATEGORY_NAME = ? where COURSE_CATEGORY_ID = ?");
			statement.setString(1, category.getCourse_category_name());
			statement.setInt(2, courseCategoryId);
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
