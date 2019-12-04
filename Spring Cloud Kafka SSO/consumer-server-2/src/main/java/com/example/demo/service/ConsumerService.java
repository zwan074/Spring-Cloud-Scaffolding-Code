package com.example.demo.service;

import java.util.List;
import com.example.demo.enitities.Consumer;

public interface ConsumerService {
	
	public boolean add(Consumer consumer);

	public Consumer get(Long id);

	public List<Consumer> list();
	
}
