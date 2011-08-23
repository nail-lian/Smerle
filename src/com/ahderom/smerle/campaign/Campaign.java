package com.ahderom.smerle.campaign;

public class Campaign {

	private String SRID = null;
	private String campaignID = null;
	private String campaignName = null;
	
	public Campaign(String campaignID, String campaignName, String SRID)
	{
		this.campaignID = campaignID;
		this.campaignName = campaignName;
		this.SRID = SRID;
	}
	
	public String getSRID()
	{
		return this.SRID;
	}
	
	public String getCampaignID()
	{
		return this.campaignID;
	}
	
	public String getCampaignName()
	{
		return this.campaignName;
	}
	
}
