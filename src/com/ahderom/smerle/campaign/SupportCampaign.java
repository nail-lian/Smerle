package com.ahderom.smerle.campaign;

import java.io.IOException;

import com.ahderom.smerle.constants.Constants;
import com.ahderom.smerle.loader.Loader;
import com.ahderom.smerle.user.Profile;

public class SupportCampaign {

	private Profile profile;
	private Campaign campaign;
	
	
	public SupportCampaign(Profile profile, Campaign campaign)
	{
		this.profile = profile;
		this.campaign = campaign;
	}
	
	public boolean support() throws IOException
	{
		boolean status = false;
		
		//make the call
		String response = Loader.Load(Constants.SUPPORT_CAMPAIGN + Constants.USERID + "=" + profile.getUserID() + "&" + Constants.SRID + "=" + campaign.getSRID());
		if(response != null && response != "")
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
