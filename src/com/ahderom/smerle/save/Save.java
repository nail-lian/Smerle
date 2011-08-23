package com.ahderom.smerle.save;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.loader.Loader;
import com.ahderom.smerle.user.Profile;

public class Save {

	private Profile profile = null;
	private ArrayList<Friend> friends = null;
	
	public Save(Profile profile)
	{
		this.profile = profile;
	}
	
	public ArrayList<Friend> getFriendList(String friends)
	{
		try {
			
			JSONObject response = new JSONObject(friends);
			JSONArray friendsArray = response.getJSONArray("friends");
			
			this.friends = new ArrayList<Friend>();
			
			for(int i=0; i<friendsArray.length(); i++)
			{
				Friend friend;
				JSONObject userFriend = friendsArray.getJSONObject(i);
				friend = new Friend(getValueFromJSONKey(userFriend, "UID"));
				friend.setFirstName(getValueFromJSONKey(userFriend, "firstName"));
				friend.setLastName(getValueFromJSONKey(userFriend, "lastName"));
				friend.setGender(getValueFromJSONKey(userFriend, "gender"));
				friend.setProfileURL(getValueFromJSONKey(userFriend, "profileURL"));
				friend.setIsSiteUser(userFriend.getBoolean("isSiteUser"));
				friend.setIsSiteUID(userFriend.getBoolean("isSiteUID"));
				friend.setNickname(getValueFromJSONKey(userFriend, "nickname"));
				friend.setPhotoURL(getValueFromJSONKey(userFriend, "photoURL"));
				friend.setThumbnailURL(getValueFromJSONKey(userFriend, "thumbnailURL"));
				
				JSONArray identities = userFriend.getJSONArray("identities");
				JSONObject id = identities.getJSONObject(0);
				friend.setProvider(getValueFromJSONKey(id, "provider"));
				friend.setProviderUID(getValueFromJSONKey(id, "providerUID"));
				friend.setIsLoginIdentity(id.getBoolean("isLoginIdentity"));
				
				//finally
				this.friends.add(friend);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.friends;
		
	}
	
	private String getValueFromJSONKey(JSONObject object, String key)
	{
		String temp = "";
		
		try
		{
			return object.getString(key);
		}
		catch(Exception e)
		{
			//this key does not exist!
			e.printStackTrace();
		}
		
		return temp;
		
	}
	
	public boolean SavaFriend(Friend friend) throws IOException
	{
		boolean status = false;
		//pre-conditions
		if(friend.getFirstName() == null) { friend.setFirstName(friend.getNickName()); }
		if(friend.getLastName() == null) { friend.setLastName(""); }
		if(friend.getGender() == null) { friend.setGender(""); }
		if(friend.getKscore() == null) { friend.setKscore(""); }
		if(friend.getState() == null){ friend.setState(""); }
		if(friend.getCountry() == null) { friend.setCountry(""); }
		
		String params = "firstname=" + friend.getFirstName() + 
		"&lastname=" + friend.getLastName() + "&uid=" + URLEncoder.encode(friend.getUID()) + 
		"&gender=" + friend.getGender() + "&nickname=" + URLEncoder.encode(friend.getNickName()) + 
		"&photourl=" + URLEncoder.encode(friend.getPhotoURL()) + "&profileurl=" + URLEncoder.encode(friend.getProfileURL()) +
		"&thumbnailurl=" + URLEncoder.encode(friend.getThumbnailURL()) + "&provider=" + URLEncoder.encode(friend.getProvider()) + 
		"&providerid=" + friend.getProviderUID() + "&state=" + friend.getState() + 
		"&country=" + friend.getCountry() + "&userid=" + profile.getUserID() + "&kscore=" + friend.getKscore();
		
		String response = Loader.Load(Constants.LINK_SAVE + params);
		
		if(response !=null)
		{
			status = true;
		}
		
		return status;
	}
	
	public boolean sync() throws IOException
	{
		boolean status = false;
		
		String response = Loader.Load(Constants.SYNC + Constants.USERID + "=" + profile.getUserID());
		
		if(response != null)
		{
			status = true;
		}
		
		return status;
	}
	
	public ArrayList<Friend> getFriendsList()
	{
		return this.friends;
	}
	
	public Profile getProfile()
	{
		return this.profile;
	}
}
