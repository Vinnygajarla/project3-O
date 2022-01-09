package project3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class LeaveDetailsMain {

		static Scanner sc = new Scanner(System.in);
		
		static LeaveDetailsBAL leaveDetailsBal = new LeaveDetailsBAL();

		public static void searchLeaveDetails() {
			int leaveId;
			System.out.println("Enter Leave Id  ");
			leaveId = sc.nextInt();
			LeaveDetails leaveDetails = leaveDetailsBal.searchLeaveBal(leaveId);
			if (leaveDetails!=null) {
				System.out.println(leaveDetails);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		}

		
		public static void showLeaveDetails() {
			List<LeaveDetails> leaveDetails = leaveDetailsBal.showLeaveBal();
			for (LeaveDetails ld : leaveDetails) {
				System.out.println(ld);
			}
		}
		
		public static void addLeaveDetails() throws ParseException, LeaveDetailsException {
			LeaveDetails leaveDetails = new LeaveDetails();
			System.out.println("Enter Employ Id   ");
			leaveDetails.setEmpId(sc.nextInt());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("Enter Leave Start-Date (yyyy-MM-dd)  ");
			String sdate = sc.next();
			leaveDetails.setLeaveStartDate(sdf.parse(sdate));
			System.out.println("Enter Leave End-Date (yyyy-MM-dd)   ");
			String endDate =  sc.next();
			leaveDetails.setLeaveEndDate(sdf.parse(endDate));
			System.out.println("Enter Leave Reason  ");
			leaveDetails.setLeaveReason(sc.next());
			System.out.println(leaveDetailsBal.addLeaveBal(leaveDetails));
		}

		public static void main(String[] args) {
			int choice;
			do {
				System.out.println(" O P T I O N S");
				System.out.println("---------------");
				System.out.println("1. Add Leave  ");
				System.out.println("2. Show Leave");
				System.out.println("3. Search Leave");
				System.out.println("4. Exit");
				System.out.println("Enter Your Choice   ");
				choice = sc.nextInt();
				switch(choice) {
				case 1 : 
					try {
						addLeaveDetails();
					} catch (ParseException | LeaveDetailsException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 2 : 
					showLeaveDetails();
					break;
				case 3 : 
					searchLeaveDetails();
					break;
				case 4 :
					return;
				}
			} while(choice!=4);

		}
	}
		
		
					

	
	 
			
			