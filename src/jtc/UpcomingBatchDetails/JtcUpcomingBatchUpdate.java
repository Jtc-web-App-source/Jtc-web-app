package jtc.UpcomingBatchDetails;

public class JtcUpcomingBatchUpdate {
	private int jtc_upcoming_batch_update_id;
	private String batch_date;
	private String batch_time;
	private String batch_mode;
	private String batch_type;
	private int course_id;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getJtc_upcoming_batch_update_id() {
		return jtc_upcoming_batch_update_id;
	}

	public void setJtc_upcoming_batch_update_id(int jtc_upcoming_batch_update_id) {
		this.jtc_upcoming_batch_update_id = jtc_upcoming_batch_update_id;
	}

	public String getBatch_date() {
		return batch_date;
	}

	public void setBatch_date(String batch_date) {
		this.batch_date = batch_date;
	}

	public String getBatch_time() {
		return batch_time;
	}

	public void setBatch_time(String batch_time) {
		this.batch_time = batch_time;
	}

	public String getBatch_mode() {
		return batch_mode;
	}

	public void setBatch_mode(String batch_mode) {
		this.batch_mode = batch_mode;
	}

	public String getBatch_type() {
		return batch_type;
	}

	public void setBatch_type(String batch_type) {
		this.batch_type = batch_type;
	}

	@Override
	public String toString() {
		return "JtcUpcomingBatchUpdate [jtc_upcoming_batch_update_id=" + jtc_upcoming_batch_update_id + ", batch_date="
				+ batch_date + ", batch_time=" + batch_time + ", batch_mode=" + batch_mode + ", batch_type="
				+ batch_type + ", course_id=" + course_id + "]";
	}

}
