package by.mapsoft.qa.les6;

import java.util.Random;

public class UserData {
	Random r = new Random();
	String e1,e2,e3;
	String firstname,lastname,address1,postcode,city,country,email,phone,password,confirm_password;

	UserData(){
		firstname = "Test_First_Name";
		lastname = "Test_Last_Name";
		address1 = "Test_Address_1_1";
		postcode = "000001";
		city = "Test_City";
		country = "Belarus";
		email = "11@11.11";
		phone = "123456789";
		password = "Test";
		confirm_password = "Test";
	}
	protected void getNewMail(){
		e1 = String.valueOf(r.nextInt(100));
		e2 = String.valueOf(r.nextInt(100));
		e3 = String.valueOf(r.nextInt(100));
		email = e1+"@"+e2+"."+e3;
	}
}
