package com.ahderom.smerle.message;

import java.util.Date;

public class Message {

	private String messageID = null;
	private String messageName = null;
	private String messageBody = null; 
	private String messageLink = null;
	private String messageType = null; 
	private String messageReward = null; 
	private String messageCustomization = null; 
	private String messageState = null; 
	private Date messageDate = null; 
	private String messageTracker = null; 
	private String encodedLink = null;
	private Integer messagePoints = null;
	
	public Message(String id)
	{
		this.messageID = id;
	}
	
	public void setMessageID(String messageID)
	{
		this.messageID = messageID;
	}
	
	public String getMessageID()
	{
		return this.messageID;
	}
	
	public void setMessageName(String messageName)
	{
		this.messageName = messageName;
	}
	
	public String getMessageName()
	{
		return this.messageName;
	}
	
	public void setMessageBody(String messageBody)
	{
		this.messageBody = messageBody;
	}
	
	public String getMessageBody()
	{
		return this.messageBody;
	}
	
	public void setMessageLink(String messageLink)
	{
		this.messageLink = messageLink;
	}
	
	public String getMessageLink()
	{
		return this.messageLink;
	}
	
	public void setMessageType(String messageType)
	{
		this.messageType = messageType;
	}
	
	public String getMessageType()
	{
		return this.messageType;
	}
	
	public void setMessageReward(String messageReward)
	{
		this.messageReward = messageReward;
	}
	
	public String getMessageReward()
	{
		return this.messageReward;
	}
	
	public void setMessageCustomization(String messageCustomization)
	{
		this.messageCustomization = messageCustomization;
	}
	
	public String getMessageCustomization()
	{
		return this.messageCustomization;
	}
	
	public void setMessageState(String messageState)
	{
		this.messageState = messageState;
	}
	
	public String getMessageState()
	{
		return this.messageState;
	}
	
	public void setMessageDate(Date messageDate)
	{
		this.messageDate = messageDate;
	}
	
	public Date getMessageDate()
	{
		return this.messageDate;
	}
	
	public void setMessageTracker(String messageTracker)
	{
		this.messageTracker = messageTracker;
	}
	
	public String getMessageTracker()
	{
		return this.messageTracker;
	}
	
	public void setEncodedLink(String encodedLink)
	{
		this.encodedLink = encodedLink;
	}
	
	public String getEncodedLink()
	{
		return this.encodedLink;
	}
	
	public void setMessagePoints(Integer messagePoints)
	{
		this.messagePoints = messagePoints;
	}
	
	public Integer getMessagePoints()
	{
		return this.messagePoints;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message ["
				+ (messageName != null ? "messageName=" + messageName + ", "
						: "")
				+ (messageBody != null ? "messageBody=" + messageBody + ", "
						: "")
				+ (messageLink != null ? "messageLink=" + messageLink + ", "
						: "")
				+ (messageDate != null ? "messageDate=" + messageDate + ", "
						: "")
				+ (encodedLink != null ? "encodedLink=" + encodedLink + ", "
						: "")
				+ (messagePoints != null ? "messagePoints=" + messagePoints
						: "") + "]";
	}
}
