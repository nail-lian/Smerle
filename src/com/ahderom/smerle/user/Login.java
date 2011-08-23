package com.ahderom.smerle.user;

import java.io.IOException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;

import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.listeners.LoadProfile;
import com.ahderom.smerle.listeners.Picture;
import com.ahderom.smerle.loader.Loader;

public class Login extends Profile {
	
	private Picture profilePic = null;
	private JSONObject profile_data = null;
	
	LoadProfile loadProfile;
	
	public Login(String email, String password)
	{
		//this initializes the profile with the required auth
		super(email, password);
	}
	
	public void setProfilePicture(Picture profilePic)
	{
		this.profilePic = profilePic;
	}
	
	public void setLoadProfile(LoadProfile loadProfile)
	{
		this.loadProfile = loadProfile;
	}
	
	public void signIn() throws IOException
	{
		String profile = Loader.Load(Constants.LOGIN_BASE_URL + Constants.EMAIL + "=" + getEmail() + "&" + Constants.PASSWORD + "=" + getPassword());
		extractProfile(profile);
	}
	
	public void extractProfile(String response)
	{
		try
		{
			JSONObject wholeResonse = new JSONObject(response);
			JSONArray result = wholeResonse.getJSONArray("rows");
			profile_data = result.getJSONObject(0);
			
			//
			setOrganizationID(profile_data.getString(Constants.ORGANIZATIONID));
			setOrganizationName(profile_data.getString(Constants.ORGANIZATIONName));
			setOrganizationQuote(profile_data.getString(Constants.ORGANIZATIONQUOTE));
			setUserID(profile_data.getString(Constants.USERID));
			setMemberSince(new Date(profile_data.getString(Constants.MEMBERSINCE)));
			setUserName(profile_data.getString(Constants.USERNAME));
			
			//should be done on another thread
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					try
					{
						setProfilePic(DownloadPicture(profile_data.getString(Constants.PROFILEPIC)));
						profilePic.ProfilePictureFinishedLoading(true);
					}
					catch(Exception e)
					{
						profilePic.ProfilePictureFinishedLoading(false);
					}
				}
			}).start();
			
			setBadgeName(profile_data.getString(Constants.BADGENAME));
			setTwitterName(profile_data.getString(Constants.TWITTERNAME));
			
			//should be done on another thread
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					try
					{
						setBadge(DownloadPicture(profile_data.getString(Constants.BADGE)));
						profilePic.BadgePictureFinishedLoading(true);
					}
					catch(Exception e)
					{
						profilePic.BadgePictureFinishedLoading(false);
					}
				}
			}).start();
			
			
			setPoints(new Integer(profile_data.getString(Constants.POINTS)));
			setUserRole(profile_data.getString(Constants.USERROLE));
			setPrizes(new Integer(profile_data.getString(Constants.PRIZES)));
			
			loadProfile.ProfileFinishedLoading(true);
			
		}
		catch(JSONException e)
		{
			//failed to extract profile elements!
			loadProfile.ProfileFinishedLoading(false);
			e.printStackTrace();
			
		}
		
		
	}
	
	private Bitmap DownloadPicture(String url) throws Exception
	{
		Bitmap bitmapToReturn = null;
		bitmapToReturn = Loader.LoadPicture(url);
		return bitmapToReturn;
	}
	
	private void setOrganizationID(String id)
	{
		super.organizationID = id;
	}
	
	private void setOrganizationName(String name)
	{
		super.organizationID = name;
	}
	
	private void setOrganizationQuote(String quote)
	{
		super.organizationQuote = quote;
	}
	
	private void setUserID(String id)
	{
		super.userID = id;
	}
	
	private void setUserName(String userName)
	{
		super.userName = userName;
	}
	
	private void setMemberSince(Date date)
	{
		super.memberSince = date;
	}
	
	private void setBadge(Bitmap badge)
	{
		super.badge = badge;
	}
	
	private void setBadgeName(String badgeName)
	{
		super.badgeName = badgeName;
	}
	
	private void setTwitterName(String twitterUserName)
	{
		super.twitterName = twitterUserName;
	}
	
	private void setProfilePic(Bitmap picture)
	{
		super.profilePic = picture;
	}
	
	private void setPoints(Integer points)
	{
		super.points = points;
	}
	
	private void setUserRole(String userRole)
	{
		super.userRole = userRole;
	}
	
	private void setPrizes(Integer prizes)
	{
		super.prizes = prizes;
	}
}
