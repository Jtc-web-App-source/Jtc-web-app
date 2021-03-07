package jtc.UpcomingBatchDetails;

import java.util.List;

public interface JtcUpcomingBatchDetailsDAO {
	public int saveBatchDetails(JtcUpcomingBatchUpdate batchUpdate);

	public List<JtcUpcomingBatchUpdate> getAllBatchUpdateByCourseId(int course_Id);

	public int deleteBatchDetails(int batch_id);

	public int updateBatchDetails(JtcUpcomingBatchUpdate batchUpdate, int batch_id);
}
