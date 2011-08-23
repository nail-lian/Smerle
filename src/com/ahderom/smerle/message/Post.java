package com.ahderom.smerle.message;

import java.io.IOException;

import com.ahderom.smerle.constants.Constants;

import com.ahderom.smerle.loader.Loader;
import com.ahderom.smerle.user.Profile;

public class Post {

	private Profile profile;
	private Message message;
	
	public Post(Profile profile, Message message)
	{
		this.profile = profile;
		this.message = message;
	}
	
	public boolean postMessage() throws IOException
	{
		boolean status = false;
		
		String response = Loader.Load(Constants.POST_MESSAGE + Constants.USERID + "=" + profile.getUserID() + "&" + Constants.MESSAGEID + "=" + message.getMessageID());
		if(response != null && !response.contains("Error"))
		{
			 status = true;
		}
		else
		{
			status = false;
		}
		
		return status;
	}
}
