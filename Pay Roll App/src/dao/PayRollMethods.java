package dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayRollMethods {
	public static void write(String userName, String password) {
		try {
			FileWriter writer = new FileWriter("C:\\Users\\rake3555\\git\\repository\\demo\\src\\Payroll\\UserData.txt",true);
			
			String str = userName + " " + password + "\n";
			
			writer.write(str);
			writer.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static boolean read(String userName , String passWord) {
		try {
			FileReader reader = new FileReader("C:\\Users\\rake3555\\git\\repository\\demo\\src\\Payroll\\UserData.txt");
			Scanner re = new Scanner(reader);
			while(re.hasNextLine()){
			String fileScanner = re.nextLine();
			String[] splitData = fileScanner.split(" ");
			
			if(splitData[0].equals(userName) && splitData[1].equals(passWord))
			{
				return true;
			}
			
			}
			reader.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
