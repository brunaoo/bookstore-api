package com.brunao.bookstore.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brunao.bookstore.service.DBService;

@Configuration
@Profile("test")
public class DatasourceConfigTest implements DatasourceConfig{
	
	@Autowired
	DBService dbService;
	
	@Bean
	@Override
	public void setup() {
		dbService.initDbTest();
	}

}
