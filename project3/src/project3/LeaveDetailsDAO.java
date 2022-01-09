package project3;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveDetailsDAO {
	
static List<LeaveDetails> leaveDetailsList;
	
	static {
		leaveDetailsList = new ArrayList<LeaveDetails>();
	}
	
	public List<LeaveDetails> showLeaveDetailsDao() {
		return leaveDetailsList;
	}
	
	
	
	public LeaveDetails searchLeaveDao(int leaveId) {
		LeaveDetails leaveFound = null;
		for (LeaveDetails leaveDetails : leaveDetailsList) {
			if (leaveDetails.getLeaveId()==leaveId) {
				leaveFound = leaveDetails;
			}
		}
		return leaveFound;
	}
	
	public String addLeaveDetailsDao(LeaveDetails leaveDetails) {
		int leaveId=0;
		if (leaveDetailsList.size()==0) {
			leaveId=1;
		} else {
			LeaveDetails ld = leaveDetailsList.get(leaveDetailsList.size()-1);
			leaveId=ld.getLeaveId()+1;
		}
		long mseconds = leaveDetails.getLeaveEndDate().getTime() - 
				leaveDetails.getLeaveStartDate().getTime();
		long diff = mseconds/(1000*60*60*24);
		int days = (int)diff;
		days++;
		leaveDetails.setLeaveId(leaveId);
		leaveDetails.setNoOfDays(days);
		leaveDetails.setLeaveAppliedOn(new Date());
		leaveDetailsList.add(leaveDetails);
		return "Leave Applied Successfully...";
	}
}



