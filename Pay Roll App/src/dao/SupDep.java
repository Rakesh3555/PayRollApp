package dao;

import java.sql.SQLException;
import java.util.Scanner;

import model.PayPojo;
import util.payRollDb;

public class SupDep {
static Scanner pps = new Scanner(System.in);
	
	public static void SupDepPay(PayPojo p) throws ClassNotFoundException, SQLException{
		System.out.println("Enter Username : ");
		String userName = pps.next();
		p.setUserName(userName);
		System.out.println("Enter Password :");
		String passWord = pps.next();
		p.setPassword(passWord);
		try {
			Validate.validUser(p);
		}
		catch(logUserValExp e)
		{
			while(!payRollDb.readLogin(p))
			{
				System.out.println(e);
				System.out.println("Enter Username : ");
				userName = pps.next();
				p.setUserName(userName);
				System.out.println("Enter Password :");
				passWord = pps.next();
				p.setPassword(passWord);
			}
			SupDep.SupCalci(p);
		}
	}
	public static void SupCalci(PayPojo p) throws ClassNotFoundException, SQLException {
while(payRollDb.readLogin(p)) {
	
		if(payRollDb.readLogin(p)) {

			System.out.println("Our Services \n 1. Payroll Calci \n 2. NetPay Calci ");
			char pa = pps.next().charAt(0);
			switch(pa) {
			case'1':
				int payHour = 50000;
				/*
				 * while(true) { System.out.println("Enter Pay/Day :"); payHour = pps.nextInt();
				 * if(payHour >= 0 ) {
				 * 
				 * break; } System.out.println("Enter valid pay Hour !"); }
				 */
				p.setPayHour(payHour);

				int totalHrWorked;
				while(true) {
					System.out.println("Enter Total Hours worked :");
					totalHrWorked = pps.nextInt();
					if(totalHrWorked >= 0 ) {
						p.setTotalHrWorked(totalHrWorked);
						break;
					}
					System.out.println("Enter valid totalHrWorked !");
				}

				int overTime = 2500;
				/*
				 * while(true) { System.out.println("Enter overTime Pay/day  :"); overTime =
				 * pps.nextInt(); if(overTime >= 0 ) {
				 * 
				 * break; } System.out.println("Enter valid over Time !"); }
				 */
				p.setOverTime(overTime);

				int totalOrTime;
				while(true) {
					System.out.println("Enter Total over time : :");
					totalOrTime = pps.nextInt();
					if(totalOrTime >= 0 ) {
						p.setTotalOrTime(totalOrTime);
						grossPayOutN(p);
						break;
					}
					System.out.println("Enter valid total over Time !");
				}
				break;

			case '2':
				double grossPayN;
				double dedection = 0;
				double pF;
				double insurance;
				double allowance;
				System.out.println("Enter Your GrossPay :");
				grossPayN = pps.nextDouble();
				p.setGrossPayDisplay(grossPayN);
				if(grossPayN < 25000) {
					dedection = (grossPayN * 0.02);
					p.setDedection(dedection);
					pF = dedection / 2;
					p.setpF(pF);
					insurance = pF / 2;
					p.setInsurance(insurance);
					allowance = insurance;
					p.setAllowance(allowance);
				}else if(grossPayN > 25000) {
					dedection = (grossPayN * 0.05);
					p.setDedection(dedection);
					pF = dedection / 2;
					p.setpF(pF);
					insurance = pF / 2;
					p.setInsurance(insurance);
					allowance = insurance;
					p.setAllowance(allowance);
				}else if(grossPayN > 50000) {
					dedection = (grossPayN * 0.08);
					p.setDedection(dedection);
					pF = dedection / 2;
					p.setpF(pF);
					insurance = pF / 2;
					p.setInsurance(insurance);
					allowance = insurance;
					p.setAllowance(allowance);
				}else if(grossPayN > 100000) {
					dedection = (grossPayN * 0.1);
					p.setDedection(dedection);
					pF = dedection / 2;
					p.setpF(pF);
					insurance = pF / 2;
					p.setInsurance(insurance);
					allowance = insurance;
					p.setAllowance(allowance);
				}else if(grossPayN > 150000) {
					dedection = (grossPayN * 0.13);
					p.setDedection(dedection);
					pF = dedection / 2;
					p.setpF(pF);
					insurance = dedection / 3;
					p.setInsurance(insurance);
					allowance = dedection / 4;
					p.setAllowance(allowance);
				}else if(grossPayN > 200000) {
					dedection = (grossPayN * 0.20);
					p.setDedection(dedection);
					pF = dedection / 2;
					p.setpF(pF);
					insurance = pF / 2;
					p.setInsurance(insurance);
					allowance = insurance;
					p.setAllowance(allowance);
				}else {
					System.out.println("Invalid entery");
				}
				netPayOut(p);
				return;
			
			}
			
			
		}
		else {
			System.out.println("Invalid user");
			SupDepPay(p);
			
		}
	
		
	}
	
}
	    	public static void grossPayOutN(PayPojo p) {
	    		float GrossPay = p.getPayHour() * p.getTotalHrWorked() + p.getOverTime() * p.getTotalOrTime();
	    		System.out.println("Your GrossPay : "+GrossPay);
	    		p.setGrossPayCalci(GrossPay);
	    	}
	    	
	    	public static void netPayOut(PayPojo p) {
	    		
	    		double netPay = p.getGrossPayCalci()-p.getDedection();
	    		p.setNetPayCalci(netPay);
	    		ViewPay vp = new ViewPay();
		  

	    		System.out.println("Provident Fund(PF) :"+p.getpF());
	    		System.out.println("Insurance amount :"+p.getInsurance());
	    		System.out.println("Allowance :"+p.getAllowance());
	    		System.out.println("------------------");
	    		System.out.println("Total dedection :"+p.getDedection());
	    		vp.yourPaySlip(p);
	    	}
	    	
}
