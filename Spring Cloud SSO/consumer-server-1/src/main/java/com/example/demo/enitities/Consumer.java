package com.example.demo.enitities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors(chain = true)

public class Consumer implements Serializable{

	private Long consumer_no; // Primary Key
    private String cname; // consumer name
    private String db_source;// database source/name, micro service could be in different nodes
    
	public Consumer(Long consumer_no, String cname, String db_source) {
		super();
		this.consumer_no = consumer_no;
		this.cname = cname;
		this.db_source = db_source;
	}
    
	
}
