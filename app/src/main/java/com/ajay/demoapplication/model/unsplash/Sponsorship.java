package com.ajay.demoapplication.model.unsplash;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sponsorship{

	@SerializedName("sponsor")
	private Sponsor sponsor;

	@SerializedName("tagline_url")
	private String taglineUrl;

	@SerializedName("tagline")
	private String tagline;

	@SerializedName("impression_urls")
	private List<Object> impressionUrls;

	public void setSponsor(Sponsor sponsor){
		this.sponsor = sponsor;
	}

	public Sponsor getSponsor(){
		return sponsor;
	}

	public void setTaglineUrl(String taglineUrl){
		this.taglineUrl = taglineUrl;
	}

	public String getTaglineUrl(){
		return taglineUrl;
	}

	public void setTagline(String tagline){
		this.tagline = tagline;
	}

	public String getTagline(){
		return tagline;
	}

	public void setImpressionUrls(List<Object> impressionUrls){
		this.impressionUrls = impressionUrls;
	}

	public List<Object> getImpressionUrls(){
		return impressionUrls;
	}

	@Override
 	public String toString(){
		return 
			"Sponsorship{" + 
			"sponsor = '" + sponsor + '\'' + 
			",tagline_url = '" + taglineUrl + '\'' + 
			",tagline = '" + tagline + '\'' + 
			",impression_urls = '" + impressionUrls + '\'' + 
			"}";
		}
}