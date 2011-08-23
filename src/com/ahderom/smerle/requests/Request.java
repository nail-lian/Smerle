package com.ahderom.smerle.requests;

import com.ahderom.smerle.campaign.Campaign;

public class Request {

	private String SRID = null;
	private String fromFirstName = null;
	private String fromLastName = null;
	private String toFirstName = null;
	private String toLastName = null;
	private Campaign campaign = null;
	
	public Request(String srid)
	{
		this.SRID = srid;
	}
	
	public String getSRID()
	{
		return this.SRID;
	}
	
	public void setFromFirstName(String fromFirstName)
	{
		this.fromFirstName = fromFirstName;
	}
	
	public String getFromFirstName()
	{
		return this.fromFirstName;
	}
	
	public void setFromLastName(String fromLastName)
	{
		this.fromLastName = fromLastName;
	}
	
	public String getFromLastName()
	{
		return this.fromLastName;
	}
	
	public void setToFirstName(String toFirstName)
	{
		this.toFirstName = toFirstName;
	}
	
	public String getToFirstName()
	{
		return this.toFirstName;
	}
	
	public void setToLastName(String toLastName)
	{
		this.toLastName = toLastName;
	}
	
	public String getToLastName()
	{
		return this.toLastName;
	}
	
	public void setCampaign(Campaign campaign)
	{
		this.campaign = campaign;
	}
	
	public Campaign getCampaign()
	{
		return this.campaign;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Request ["
				+ (fromFirstName != null ? "fromFirstName=" + fromFirstName
						+ ", " : "")
				+ (fromLastName != null ? "fromLastName=" + fromLastName + ", "
						: "")
				+ (toFirstName != null ? "toFirstName=" + toFirstName + ", "
						: "")
				+ (toLastName != null ? "toLastName=" + toLastName : "") + "]";
	}

}
