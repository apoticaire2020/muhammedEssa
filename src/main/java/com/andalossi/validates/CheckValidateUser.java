package com.andalossi.validates;

public class CheckValidateUser {
	
	public boolean checkValidate(String n , String p) {
		if(n.equals("ahmed") && p.equals("123"))
		{
			return true;
		}
		else {
			return false;
		}
	}
}
