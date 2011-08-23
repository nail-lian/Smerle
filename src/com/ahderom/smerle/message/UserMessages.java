package com.ahderom.smerle.message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.loader.Loader;
import com.ahderom.smerle.user.Profile;

public class UserMessages {

	private Profile profile;
	
	
	public UserMessages(Profile profile)
	{
		this.profile = profile;
	}
	
	public ArrayList<Message> getMessages(int page, int resultsPerPage) throws IOException
	{
		
		String response = Loader.Load(Constants.USER_MESSAGES + Constants.USERID + "=" + profile.getUserID() + "&" + Constants.PAGE + "=" + String.valueOf(page) + "&" + Constants.RECEIVE_PER_PAGE + "=" + String.valueOf(resultsPerPage));
		return extractRequests(response);
	}
	
	private ArrayList<Message> extractRequests(String response)
	{
		ArrayList<Message>  messageList = null;
		
		try
		{
			JSONObject wholeResonse = new JSONObject(response);
			JSONArray result = wholeResonse.getJSONArray("rows");
			
			messageList = new ArrayList<Message>();
			for(int i=0; i<result.length(); i++)
			{
			
				JSONObject row_message = result.getJSONObject(i);
				Message message = new Message(row_message.getString(Constants.MESSAGEID));
				message.setMessageName(row_message.getString(Constants.MESSAGENAME));
				message.setMessageLink(row_message.getString(Constants.MESSAGELINK));
				message.setMessageType(row_message.getString(Constants.MESSAGETYPE));
				message.setMessageBody(row_message.getString(Constants.MESSAGEBODY));
				message.setMessageReward(row_message.getString(Constants.MESSAGEREWARD));
				message.setMessageCustomization(row_message.getString(Constants.MESSAGECUSTOMIZATION));
				message.setMessageState(row_message.getString(Constants.MESSAGESTATE));
				message.setMessageDate(new Date(row_message.getString(Constants.MESSAGEDATE)));
				message.setMessageTracker(row_message.getString(Constants.MESSAGETRACKER));
				message.setEncodedLink(row_message.getString(Constants.ENCODEDLINK));
				message.setMessagePoints(new Integer(row_message.getString(Constants.MESSAGEPOINTS)));
				
				//add the message to the list
				messageList.add(message);
			}
			
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		
		return messageList;
		
	}
}
