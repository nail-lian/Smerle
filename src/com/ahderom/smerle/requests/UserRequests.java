package com.ahderom.smerle.requests;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ahderom.smerle.campaign.Campaign;
import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.loader.Loader;
import com.ahderom.smerle.user.Profile;

public class UserRequests {

	private Profile profile;
	
	
	public UserRequests(Profile profile)
	{
		this.profile = profile;
	}
	
	public ArrayList<Request> getRequests() throws Exception
	{
		ArrayList<Request> listToReturn = null;
		
		String response = Loader.Load(Constants.GET_REQUESTS_BASE_URL + Constants.USERID + "=" + profile.getUserID());
		listToReturn = extractRequests(response);
		
		return listToReturn;
	}
	
	
	private ArrayList<Request> extractRequests(String response)
	{
		ArrayList<Request> requestList= null;
		
		try
		{
			JSONObject wholeResonse = new JSONObject(response);
			JSONArray result = wholeResonse.getJSONArray("rows");
			
			requestList = new ArrayList<Request>();
			for(int i=0; i<result.length(); i++)
			{
				
				JSONObject row_request = result.getJSONObject(i);
				Request request = new Request(row_request.getString(Constants.SRID));
				request.setFromFirstName(row_request.getString(Constants.FROMFIRSTNAME));
			    request.setFromLastName(row_request.getString(Constants.FROMLASTNAME));
			    request.setToFirstName(row_request.getString(Constants.TOLASTNAME));
			    request.setToLastName(row_request.getString(Constants.TOLASTNAME));
			    Campaign camp = new Campaign(row_request.getString(Constants.CampaignID),row_request.getString(Constants.CampaignName), row_request.getString(Constants.SRID));
			    request.setCampaign(camp);

			    //finally add the request to the requestList
			    requestList.add(request);
				
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return requestList;
		
	}
}
