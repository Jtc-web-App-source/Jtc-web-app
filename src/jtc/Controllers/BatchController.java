package jtc.Controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtc.UpcomingBatchDetails.JtcUpcomingBatchDetailsDAO;
import jtc.UpcomingBatchDetails.JtcUpcomingBatchDetailsDAOImpl;
import jtc.UpcomingBatchDetails.JtcUpcomingBatchUpdate;

@WebServlet(urlPatterns = { "/jtc_get_batch", "/jtc_set_batch", "/jtc_delete_batch", "/jtc_update_batch" })

public class BatchController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Url = request.getRequestURI();
		if (Url.endsWith("jtc_get_batch")) {
			JtcUpcomingBatchDetailsDAO dao = new JtcUpcomingBatchDetailsDAOImpl();
			List<JtcUpcomingBatchUpdate> list = dao.getAllBatchUpdateByCourseId(2);
			Iterator<JtcUpcomingBatchUpdate> iterator = list.iterator();
			System.out.println("Batch Data Are = ");
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} else if (Url.endsWith("jtc_set_batch")) {
			JtcUpcomingBatchDetailsDAO dao = new JtcUpcomingBatchDetailsDAOImpl();
			JtcUpcomingBatchUpdate batchUpdate = new JtcUpcomingBatchUpdate();
			batchUpdate.setBatch_date("24-feb");
			batchUpdate.setBatch_mode("Classroom Training");
			batchUpdate.setBatch_time("10 AM");
			batchUpdate.setBatch_type("Weekdays");
			batchUpdate.setCourse_id(2);
			int status = dao.saveBatchDetails(batchUpdate);
			System.out.println("Batch Saved Status = " + status);
		} else if (Url.endsWith("jtc_delete_batch")) {
			JtcUpcomingBatchDetailsDAO dao = new JtcUpcomingBatchDetailsDAOImpl();
			int status = dao.deleteBatchDetails(1);
			System.out.println("Delete Batch Status = " + status);
		} else if (Url.endsWith("jtc_update_batch")) {
			JtcUpcomingBatchUpdate batchUpdate = new JtcUpcomingBatchUpdate();
			JtcUpcomingBatchDetailsDAO dao = new JtcUpcomingBatchDetailsDAOImpl();
			batchUpdate.setBatch_date("Testing");
			batchUpdate.setJtc_upcoming_batch_update_id(1);
			;
			batchUpdate.setBatch_mode("Classroom Training");
			batchUpdate.setBatch_time("10 AM");
			batchUpdate.setBatch_type("Weekdays Updated");
			batchUpdate.setJtc_upcoming_batch_update_id(2);
			int status = dao.updateBatchDetails(batchUpdate, batchUpdate.getJtc_upcoming_batch_update_id());
			System.out.println("Batch Updated status = " + status);
		}
	}
}
