package com.example.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.example.demo.enitities.Consumer;


@Mapper //ORM to database
public interface ConsumerDao {
	
	public boolean addConsumer(Consumer consumer);

	public Consumer findById(Long id);

	public List<Consumer> findAll();

}
