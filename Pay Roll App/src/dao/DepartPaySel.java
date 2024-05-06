package dao;

import java.util.Scanner;

import model.PayPojo;

public class DepartPaySel {
	Scanner dps = new Scanner(System.in);
	TesDepPay pra = new TesDepPay();
	DevDep dd = new DevDep();
	SupDep sd = new SupDep();
	
	public void department(PayPojo p){
		
		System.out.println("Choose your Department :");
		System.out.println("1.Developer \n 2.Testing \n 3.Support ");
		char dc = dps.next().charAt(0);
		switch(dc) {
		case '1':
			p.setDepartment("developer");
			dd.devDepPay(p);
			break;
		case '2':
			//System.out.println("----");
			p.setDepartment("testing");
			pra.tesDepPay();
			
			break;
		case '3':
			p.setDepartment("support");
			sd.supDepPay();
			break;
		}
		
	}
}
