package dao;

import java.sql.SQLException;

import model.PayPojo;
import util.payRollDb;

public class Validate {
		
		
		public static void validUser(PayPojo p) throws ClassNotFoundException, SQLException, logUserValExp {
			
			if(payRollDb.readLogin(p))
			{
				System.out.println("Valid UserName and Password");
				DevDep.DevCalci(p);
			}
			else
			{
				throw new logUserValExp("Correctah Enter panra");
			}
			
		
	}

}
