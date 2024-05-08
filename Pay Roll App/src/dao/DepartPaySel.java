package dao;

import java.sql.SQLException;
import java.util.Scanner;

import model.PayPojo;

public class DepartPaySel {
	Scanner dps = new Scanner(System.in);
	TesDepPay pra = new TesDepPay();
	
	SupDep sd = new SupDep();
	
	public void department(PayPojo p) throws ClassNotFoundException, SQLException{
		System.out.println("-----Employee PaySlip Generator-----");
		System.out.println("Choose your Department :");
		System.out.println("1.Developer \n2.Testing \n3.Support ");
		char dc = dps.next().charAt(0);
		switch(dc) {
		case '1':
			p.setDepartment("developer");
			DevDep.devDepPay(p);
			break;
		case '2':
			//System.out.println("----");
			p.setDepartment("testing");
			pra.TestDepPay(p);
			
			break;
		case '3':
			p.setDepartment("support");
			sd.SupDepPay(p);
			break;
		}
		
	}
}
