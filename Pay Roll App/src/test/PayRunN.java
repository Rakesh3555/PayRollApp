package test;

import java.sql.SQLException;

import dao.DepartPaySel;
import model.PayPojo;

public class PayRunN {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		PayPojo p = new PayPojo();
		DepartPaySel dps = new DepartPaySel();
		dps.department(p);
	}

}
