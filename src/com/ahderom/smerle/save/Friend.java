package com.ahderom.smerle.save;

public class Friend {

	private String UID = null;
	private boolean isSiteUser = false;
	private boolean isSiteUID = false;
	private String provider = null;
	private String providerUID = null;
	private boolean isLoginIdentity = false;
	private String firstName = null;
	private String lastName = null;
	private String gender = null;
	private String state = null;
	private String country = null;
	private String nickname = null;
	private String photoURL = null;
	private String profileURL = null;
	private String thumbnailURL = null;
	private String kscore = null;
	
	public Friend(String uid)
	{
		this.UID = uid;
	}
	
	public String getUID()
	{
		return this.UID;
	}
	
	public void setIsSiteUser(boolean isSiteUser)
	{
		this.isSiteUser = isSiteUser;
	}
	
	public boolean getIsSiteUser()
	{
		return this.isSiteUser;
	}
	
	public void setIsSiteUID(boolean isSiteUID)
	{
		this.isSiteUID = isSiteUID;
	}
	
	public boolean getIsSiteUID()
	{
		return this.isSiteUID;
	}
	
	public void setProvider(String provider)
	{
		this.provider = provider;
	}
	
	public String getProvider()
	{
		return this.provider;
	}
	
	public void setProviderUID(String providerUID)
	{
		this.providerUID = providerUID;
	}
	
	public String getProviderUID()
	{
		return this.providerUID;
	}
	
	public void setIsLoginIdentity(boolean isLoginIdentity)
	{
		this.isLoginIdentity = isLoginIdentity;
	}
	
	public boolean getIsLoginIdentity()
	{
		return this.isLoginIdentity;
	}
	
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getNickName()
	{
		return this.nickname;
	}
	
	public void setPhotoURL(String photoURL)
	{
		this.photoURL = photoURL;
	}
	
	public String getPhotoURL()
	{
		return this.photoURL;
	}
	
	public void setThumbnailURL(String thumbnailURL)
	{
		this.thumbnailURL = thumbnailURL;
	}
	
	public String getThumbnailURL()
	{
		return this.thumbnailURL;
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

	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getState()
	{
		return this.state;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getCountry()
	{
		return this.country;
	}
	
	public void setKscore(String kscore)
	{
		this.kscore = kscore;
	}
	
	public String getKscore()
	{
		return this.kscore;
	}
	
	public void setProfileURL(String profileURL)
	{
		this.profileURL = profileURL;
	}
	
	public String getProfileURL()
	{
		return this.profileURL;
	}
}
