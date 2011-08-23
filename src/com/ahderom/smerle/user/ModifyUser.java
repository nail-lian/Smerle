package com.ahderom.smerle.user;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.loader.Loader;

public class ModifyUser {

	private Profile profile;
	private JSONObject profile_data = null;
	private ArrayList<String> tempProfile;
	
	
	public ModifyUser(Profile profile)
	{
		this.profile = profile;
	}
	
	public boolean edit(String password) throws IOException
	{
		String response = Loader.Load(Constants.EDIT_PROFILE + Constants.FIRSTNAME + "=" + tempProfile.get(1) + "&" + Constants.LASTNAME + "=" + tempProfile.get(2) + "&" + "password=" + password + "&" + Constants.USERID + "=" +tempProfile.get(0));
		
		if(response != null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public ArrayList<String> getCurrentProfile() throws IOException
	{
		String response = Loader.Load(Constants.GET_CURRENT_PROFILE + Constants.USERID  + "=" +profile.getUserID());
		return extractCurrentProfile(response);
	}
	
	private ArrayList<String> extractCurrentProfile(String response)
	{
		try
		{
			JSONObject wholeResonse = new JSONObject(response);
			JSONArray result = wholeResonse.getJSONArray("rows");
			profile_data = result.getJSONObject(0);
			
			String id = profile_data.getString(Constants.USERID);
			String firstName = profile_data.getString(Constants.FIRSTNAME);
			String lastName = profile_data.getString(Constants.LASTNAME);
			
			tempProfile = new ArrayList<String>();
			tempProfile.add(id);
			tempProfile.add(firstName);
			tempProfile.add(lastName);
		}
		
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return tempProfile;
	}
	
	
	public Profile getProfile()
	{
		return this.profile;
	}
}
