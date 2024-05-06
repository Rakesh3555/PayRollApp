package test;

import java.sql.SQLException;

import dao.DevDep;
import dao.UserCredPayroll;
import dao.ViewPay;
import model.PayPojo;
import util.payRollDb;

public class PayRunN {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		PayPojo p = new PayPojo();
//		PayrollApp pra = new PayrollApp();
//		pra.payRollCalci(); 
		PayPojo pp = new PayPojo();
		UserCredPayroll ucp = new UserCredPayroll();
		ViewPay vp = new ViewPay();
		payRollDb prd = new payRollDb();
		ucp.Registration(p);
//		prd.payRollData(pp);
		 DevDep dd = new DevDep(); 
		 dd.devDepPay(p);
    	vp.yourPaySlip(pp);
		prd.payRollData(p);
		
	}

}
