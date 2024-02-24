package com.telusko.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.dao.ITouristRepo;
import com.telusko.exception.TouristNotFoundException;
import com.telusko.pojo.Tourist;

@Service
public class TouristMangementImpl implements ITouristMangement
{
	@Autowired
	ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) 
	{
		Integer id = repo.save(tourist).getId();
		return "Tourist data Stored with id : "+id;
	}

	@Override
	public Tourist fetchTouristById(Integer id) 
	{
		
		return repo.findById(id).orElseThrow(
				()->new TouristNotFoundException("Tourist with id "+id+" not found!"));
	
	}

	@Override
	public List<Tourist> fetchAllTourists() 
	{
		
		return repo.findAll();
	}

	@Override
	public String updateTouristData(Tourist tourist) 
	{
		Integer id=tourist.getId();
		Optional optional = repo.findById(id);
		if(optional.isPresent())
		{
			repo.save(tourist);
			return "Tourist with id "+tourist.getId()+" is updated!!";
		}
		
		else
		{
			//return "Tourist with id "+tourist.getId()+" is not found to updated!!";
			throw new TouristNotFoundException("Tourist with id "+tourist.getId()+" is not found to updated!!");
			
		}
	}

	@Override
	public String updateTouristDataById(Integer id, Double budget) 
	{
		Optional<Tourist> optional = repo.findById(id);
		
		if(optional.isPresent())
		{
			Tourist tourist=optional.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "Tourist with id "+tourist.getId()+" is updated!!";
		}
		
		else
		{
			//return "Tourist with id "+tourist.getId()+" is not found to updated!!";
			throw new TouristNotFoundException("Tourist with id "+id+" is not found to updated!!");
			
		}
		
	}

	@Override
	public String deleteTouristById(Integer id)
	{
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
		{
//			Tourist tourist=optional.get();
//			repo.delete(tourist);
			repo.delete(optional.get());
			return "Tourist with id "+id+" is deleted!!";
		}
		else
		{
			//return "Tourist with id "+tourist.getId()+" is not found to updated!!";
			throw new TouristNotFoundException("Tourist with id "+id+" is not found to updated!!");
			
		}
	}


}
