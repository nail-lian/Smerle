package com.ahderom.smerle.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class Loader {

	public static String Load(String url) throws IOException
	{
		StringBuilder response = null;

		URL pageURL = new URL(url);
		
		HttpURLConnection connection = (HttpURLConnection)pageURL.openConnection();
		
		if(connection.getResponseCode() == HttpURLConnection.HTTP_OK)
		{
			BufferedReader reader = new BufferedReader(new 
					InputStreamReader(connection.getInputStream()));
			
			response = new StringBuilder();
			
			String line = null;
			while((line = reader.readLine()) != null)
			{
				response.append(line);
			}
		}
		
		else
		{
			throw new IOException();
		}
		
		return response.toString();
	}
	
	public static Bitmap LoadPicture(String url) throws Exception
	{	
		Bitmap  bitmap= null;
		bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).openConnection().getInputStream());
		return bitmap;
	}
}
