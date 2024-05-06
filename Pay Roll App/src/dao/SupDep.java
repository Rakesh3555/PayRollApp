package dao;

import java.util.Scanner;

import model.PayPojo;

public class SupDep {
	PayPojo pp = new PayPojo();
	Scanner pps = new Scanner(System.in);
	
	public void supDepPay (){
		String VallogInUser = "[a-zA-Z]{4,16}";
		System.out.println("Enter Username : ");
		String userName = pps.next();
		System.out.println("Enter Password :");
		String passWord = pps.next();
		
	while(PayRollMethods.read(userName, passWord)) {
	
		if(PayRollMethods.read(userName, passWord)) {

			System.out.println("Our Services \n 1. Payroll Calci \n 2. NetPay Calci ");
			char pa = pps.next().charAt(0);
			switch(pa) {
			case'1':
				int payHour = 3000 ;
				/*
				 * while(true) { System.out.println("Enter Pay/Day :"); payHour = pps.nextInt();
				 * if(payHour >= 0 ) {
				 * 
				 * break; } System.out.println("Enter valid pay Hour !"); }
				 */
				pp.setPayHour(payHour);

				int totalHrWorked;
				while(true) {
					System.out.println("Enter Total Hours worked :");
					totalHrWorked = pps.nextInt();
					if(totalHrWorked >= 0 ) {
						pp.setTotalHrWorked(totalHrWorked);
						break;
					}
					System.out.println("Enter valid totalHrWorked !");
				}

				int overTime = 1500;
				/*
				 * while(true) { System.out.println("Enter overTime Pay/day  :"); overTime =
				 * pps.nextInt(); if(overTime >= 0 ) {
				 * 
				 * break; } System.out.println("Enter valid over Time !"); }
				 */
				pp.setOverTime(overTime);

				int totalOrTime;
				while(true) {
					System.out.println("Enter Total over time : :");
					totalOrTime = pps.nextInt();
					if(totalOrTime >= 0 ) {
						pp.setTotalOrTime(totalOrTime);
						grossPayOutN();
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
				if(grossPayN < 25000) {
					dedection = (grossPayN * 0.02);
					pp.setDedection(dedection);
					pF = dedection / 2;
					pp.setpF(pF);
					insurance = pF / 2;
					pp.setInsurance(insurance);
					allowance = insurance;
					pp.setAllowance(allowance);
				}else if(grossPayN > 25000) {
					dedection = (grossPayN * 0.05);
					pp.setDedection(dedection);
					pF = dedection / 2;
					pp.setpF(pF);
					insurance = pF / 2;
					pp.setInsurance(insurance);
					allowance = insurance;
					pp.setAllowance(allowance);
				}else if(grossPayN > 50000) {
					dedection = (grossPayN * 0.08);
					pp.setDedection(dedection);
					pF = dedection / 2;
					pp.setpF(pF);
					insurance = pF / 2;
					pp.setInsurance(insurance);
					allowance = insurance;
					pp.setAllowance(allowance);
				}else if(grossPayN > 100000) {
					dedection = (grossPayN * 0.1);
					pp.setDedection(dedection);
					pF = dedection / 2;
					pp.setpF(pF);
					insurance = pF / 2;
					pp.setInsurance(insurance);
					allowance = insurance;
					pp.setAllowance(allowance);
				}else if(grossPayN > 150000) {
					dedection = (grossPayN * 0.13);
					pp.setDedection(dedection);
					pF = dedection / 2;
					pp.setpF(pF);
					insurance = dedection / 3;
					pp.setInsurance(insurance);
					allowance = dedection / 4;
					pp.setAllowance(allowance);
				}else if(grossPayN > 200000) {
					dedection = (grossPayN * 0.20);
					pp.setDedection(dedection);
					pF = dedection / 2;
					pp.setpF(pF);
					insurance = pF / 2;
					pp.setInsurance(insurance);
					allowance = insurance;
					pp.setAllowance(allowance);
				}else {
					System.out.println("Invalid entery");
				}
				netPayOut();
				return;
			
			}
			
			
		}
		else {
			System.out.println("Invalid user");
			
		}
	
		
	}
	
		while(!PayRollMethods.read(userName, passWord))
		{
			supDepPay();
		}
	
}
	    	public void grossPayOutN() {
	    		float GrossPay = pp.getPayHour() * pp.getTotalHrWorked() + pp.getOverTime() * pp.getTotalOrTime();
	    		System.out.println("Your GrossPay : "+GrossPay);
	    		pp.setGrossPayCalci(GrossPay);
	    	}
	    	
	    	public void netPayOut() {
	    		
	    		double netPay = pp.getGrossPayCalci()-pp.getDedection();
	    		pp.setNetPayCalci(netPay);
	    		System.out.println("Provident Fund(PF) :"+pp.getpF());
	    		System.out.println("Insurance amount :"+pp.getInsurance());
	    		System.out.println("Allowance :"+pp.getAllowance());
	    		System.out.println("------------------");
	    		System.out.println("Total dedection :"+pp.getDedection());
	    	}
}
