package com.ahderom.smerle.user;

import java.util.Date;

import android.graphics.Bitmap;

public class Profile {
	
	private String firstName = null;
	private String lastName = null;
	private String phone = null;
	private String email = null;
	private String password = null;
	private String userType = null;
	protected String userName = null;
	
	protected String organizationID = null;
	protected String organizationName = null;
	protected String organizationQuote = null;
	protected String userID = null;
	protected Date memberSince = null;
	protected Bitmap badge = null;
	protected String badgeName = null;
	protected String twitterName = null;
	protected Bitmap profilePic = null;
	protected Integer points = null;
	protected Integer prizes = null;
	protected String userRole = null;
	
	public Profile(String email, String password)
	{
		this.email = email;
		this.password = password;
	}
	
	public Profile(String firstName, String lastName, String email, String password, String phone, String userType, String userName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.userType = userType;
		this.userName = userName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public String getUserType()
	{
		return this.userType;
	}
	
	
	
	///////////////////
	
	
	public String getOrganizationID()
	{
		return this.organizationID;
	}
	
	
	public String getOrganizationName()
	{
		return this.organizationName;
	}
	
	public String getOrganizationQuote()
	{
		return this.organizationQuote;
	}
	
	public String getUserID()
	{
		return this.userID;
	}
	
	public Date getMemberSince()
	{
		return this.memberSince;
	}
	
	public Bitmap getBadge()
	{
		return this.badge;
	}
	
	public String getBadgeName()
	{
		return this.badgeName;
	}
	
	public String getTwitterName()
	{
		return this.twitterName;
	}
	
	public Bitmap getProfilePic()
	{
		return this.profilePic;
	}
	
	public Integer getPoints()
	{
		return this.points;
	}
	
	
	public Integer getPrizes()
	{
		return this.prizes;
	}
	
	public String getUserRole()
	{
		return this.userRole;
	}
}
