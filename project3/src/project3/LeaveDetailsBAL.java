package project3;

import java.util.Date;
import java.util.List;

public class LeaveDetailsBAL {

	static StringBuilder sb = new StringBuilder();
	
	static LeaveDetailsDAO leaveDetailsDao;
	
	static {
		leaveDetailsDao = new LeaveDetailsDAO();
	}
	
	public LeaveDetails searchLeaveBal(int leaveId) {
		return leaveDetailsDao.searchLeaveDao(leaveId);
	}
	
	public List<LeaveDetails> showLeaveBal() {
		return leaveDetailsDao.showLeaveDetailsDao();
	}

	
	public String addLeaveBal(LeaveDetails leaveDetails) throws LeaveDetailsException {
		if (isValid(leaveDetails)==true) {
			return leaveDetailsDao.addLeaveDetailsDao(leaveDetails);			
		} else {
			throw new LeaveDetailsException(sb.toString());
		}
	}

	
	public boolean isValid(LeaveDetails leaveDetails) {
		boolean isValid=true;
		Date today = new Date();
		long ms = leaveDetails.getLeaveEndDate().getTime() - 
				leaveDetails.getLeaveStartDate().getTime();

		long d = (ms /(1000*60*60*24));
		int days = (int)d;
		days++;
		if(days <= 0) {
			isValid=false;
			sb.append("Leave Start Date Cannot be Greater Than Leave End Date\n");
		}
		
		ms = leaveDetails.getLeaveStartDate().getTime() - today.getTime();
		d = (ms /(1000*60*60*24));
		days = (int)d;
		days++;
		if (days <= 0) {
			isValid=false;
			sb.append("Leave Start Date Cannot be Less Than Today's Date...\n");
		}
		ms = leaveDetails.getLeaveEndDate().getTime() - today.getTime();
		d = (ms /(1000*60*60*24));
		days = (int)d;
		days++;
		
		ms = leaveDetails.getLeaveEndDate().getTime() - today.getTime();
		d = (ms /(1000*60*60*24));
		days = (int)d;
		days++;
		if (days <= 0) {
			isValid=false;
			sb.append("Leave End Date Cannot be Less than today's Date...\n");
		}
		return  isValid;
	}
}
