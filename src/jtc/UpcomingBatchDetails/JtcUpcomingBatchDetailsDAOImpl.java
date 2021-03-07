package jtc.UpcomingBatchDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jtc.DBConfuration.DBConfiguration;

public class JtcUpcomingBatchDetailsDAOImpl implements JtcUpcomingBatchDetailsDAO {
	private Connection connection = null;

	@Override
	public int saveBatchDetails(JtcUpcomingBatchUpdate batchUpdate) {
		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into jtc_upcoming_batch_details values (?,?,?,?,?,?)");
			Statement statement2 = connection.createStatement();
			ResultSet resultSet = statement2
					.executeQuery("select max(JTC_UPCOMING_BATCH_DETAILS_ID) from jtc_upcoming_batch_details");
			int count = 0;
			int batch_id = 0;
			while (resultSet.next()) {   
				count++;
				batch_id = resultSet.getInt(1);
			}
			if (count == 0) {

			} else {
				statement.setInt(1, batch_id + 1);
			}
			statement.setString(2, batchUpdate.getBatch_date());
			statement.setString(3, batchUpdate.getBatch_time());
			statement.setString(4, batchUpdate.getBatch_mode());
			statement.setString(5, batchUpdate.getBatch_type());
			statement.setInt(6, batchUpdate.getCourse_id());
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<JtcUpcomingBatchUpdate> getAllBatchUpdateByCourseId(int course_Id) {
		List<JtcUpcomingBatchUpdate> list = new ArrayList<JtcUpcomingBatchUpdate>();
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from jtc_upcoming_batch_details where course_id = ?");
			statement.setInt(1, course_Id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				JtcUpcomingBatchUpdate batchUpdate = new JtcUpcomingBatchUpdate();
				batchUpdate.setJtc_upcoming_batch_update_id(resultSet.getInt(1));
				batchUpdate.setBatch_date(resultSet.getString(2));
				batchUpdate.setBatch_time(resultSet.getString(3));
				batchUpdate.setBatch_mode(resultSet.getString(4));
				batchUpdate.setBatch_type(resultSet.getString(5));
				batchUpdate.setCourse_id(resultSet.getInt(6));
				list.add(batchUpdate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteBatchDetails(int batch_id) {
		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("delete from jtc_upcoming_batch_details where JTC_UPCOMING_BATCH_DETAILS_ID = ?");
			statement.setInt(1, batch_id);
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateBatchDetails(JtcUpcomingBatchUpdate batchUpdate, int batch_id) {
		int status = 0;
		try {
			connection = DBConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update jtc_upcoming_batch_details set BATCH_DATE = ?, BATCH_TIME = ?,BATCH_MODE =?,BATCH_TYPE=? where JTC_UPCOMING_BATCH_DETAILS_ID =?");
			statement.setString(1, batchUpdate.getBatch_date());
			statement.setString(2, batchUpdate.getBatch_time());
			statement.setString(3, batchUpdate.getBatch_mode());
			statement.setString(4, batchUpdate.getBatch_type());
			statement.setInt(5, batch_id);
			status = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
