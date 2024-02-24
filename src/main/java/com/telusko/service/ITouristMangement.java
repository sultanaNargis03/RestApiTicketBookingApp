package com.telusko.service;

import java.util.List;

import com.telusko.pojo.Tourist;

public interface ITouristMangement 
{
	public String registerTourist(Tourist tourist);
	public Tourist fetchTouristById(Integer id);
	public List<Tourist> fetchAllTourists();
	public String updateTouristData(Tourist tourist);
	public String updateTouristDataById(Integer id,Double budget);
	public String deleteTouristById(Integer id);
	
}	

