package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConsumerDao;
import com.example.demo.enitities.Consumer;
import com.example.demo.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	private ConsumerDao dao;
	
	@Override
	public boolean add(Consumer consumer)
	{
		return dao.addConsumer(consumer);
	}

	@Override
	public Consumer get(Long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<Consumer> list()
	{
		return dao.findAll();
	}
	

}
