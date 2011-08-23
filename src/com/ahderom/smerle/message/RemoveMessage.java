package com.ahderom.smerle.message;

import java.io.IOException;

import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.loader.Loader;
import com.ahderom.smerle.user.Profile;

public class RemoveMessage {

	private Profile profile = null;
	private Message message = null;
	
	public RemoveMessage(Profile profile, Message message)
	{
		this.profile = profile;
		this.message = message;
	}
	
	public boolean remove() throws IOException
	{
		boolean status = false;
		String response = Loader.Load(Constants.REMOVE_MESSAGE + Constants.USERID + "=" + profile.getUserID() + "&"  + Constants.MESSAGEID + "=" + message.getMessageID());
		
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
