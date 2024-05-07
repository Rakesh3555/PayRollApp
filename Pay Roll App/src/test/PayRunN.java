package test;

import java.sql.SQLException;

import dao.DepartPaySel;
import dao.DevDep;
import dao.ViewPay;
import model.PayPojo;
import util.payRollDb;

public class PayRunN {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		PayPojo p = new PayPojo();
		DepartPaySel dps = new DepartPaySel();
		dps.department(p);
	}

}
