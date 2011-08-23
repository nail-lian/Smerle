package com.ahderom.smerle.user;

import java.io.IOException;

import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.loader.Loader;

public class CreateUser extends Profile {

	public CreateUser(String firstName, String lastName, String email, String password, String phone, String userType, String userName)
	{
		super(firstName,lastName, email, password, phone, userType, userName);
	}
	
	public boolean createAccount() throws IOException
	{
		String signin_response = Loader.Load(Constants.SIGN_IN_BASE_URL + Constants.NAME + "=" + this.getFirstName() + "&" + Constants.LASTNAME + "=" + this.getLastName() + "&" + Constants.EMAIL + "=" + this.getEmail() + "&" + Constants.PASSWORD + "=" + this.getPassword() + "&" + Constants.PHONE + "=" + this.getPhone() + "&" + Constants.ORG + "=" + Constants.ORGID + "&" + Constants.USERTYPE + "=" + this.getUserType() +"&" + Constants.USERNAME + "=" + this.getUserName());
		if(!signin_response.equals(new String("Error creating User!")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
