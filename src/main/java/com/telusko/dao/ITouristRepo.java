package com.telusko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.pojo.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
