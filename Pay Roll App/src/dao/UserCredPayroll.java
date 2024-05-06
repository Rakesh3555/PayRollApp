package dao;

import java.util.Scanner;

import model.PayPojo;

public class UserCredPayroll {
	Scanner uc = new Scanner(System.in);
	 DepartPaySel dp=new  DepartPaySel();
	PayRollMethods prm = new PayRollMethods();
	String userPass;
	
	public void Registration(PayPojo p) {
		System.out.println("Log-In Portal: ");
		System.out.println("1. Log-in \n2. Sign-up ");
		System.out.println("If you have an account Log-in or choose 2 to Sign-up.");
		char up = uc.next().charAt(0);
		switch(up) {
		case '1':
			dp.department(p);
			break;
		
		case '2':
			while(true) {
				String gMail;
				String gMailVal = "[a-z@.]{4,16}";
				System.out.println("Enter e-mailId : ");
				gMail = uc.next();
				p.setMailId(gMail);
				if(gMail.matches(gMailVal)){
					String mailOtp="";
					String mailOtpVal = "[0-9]{4}";
					System.out.println("Enter otp : ");
					mailOtp = uc.next();
					
					while(mailOtp.length()!=4)
					{
						System.err.println("Invalid otp\nenter again :");
						mailOtp = uc.next();
					}
					while(mailOtp.length()==4) {
						
							String userName="";
							String userNameVal = "[a-zA-Z]{4,16}";
							System.out.println("Enter username  : ");
							userName = uc.next();
						
							while(!userName.matches(userNameVal))
							{
								System.err.println("Invalid Data\nenter it again: ");
								userName = uc.next();
							}
							while(userName.matches(userNameVal)) {
									p.setUserName(userName);
									String userPass="";
									String userPassVal = "[a-zA-Z0-9]{4,16}";
									System.out.println("Enter your password :");
									userPass = uc.next();
									while(!userPass.matches(userPassVal)) 
									{
										System.err.println("Invalid Data\nenter it again :");
										userPass = uc.next();
									}
									while(userPass.matches(userPassVal)) {
										p.setPassword(userPass);
											String reUserPass="";
											System.out.println("Re-enter password : ");
											reUserPass = uc.next();
											while(!reUserPass.equals(userPass)) 
											{
												System.err.println("Invalid data\nenter it again :");
												reUserPass = uc.next();
											}	
											while(reUserPass.equals(userPass)) {
													System.out.println("Sign-up Successfull !");
													prm.write(userName, reUserPass);
													
												
												
											break;	
											}
											
										
										break;
									}
									
								
	
								break;
							}
							break;
						
						
					}
					break;
				}
				break;
				
			}
			
			
			
		
break;
	}
		
		
	
		
		}
}
