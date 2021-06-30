package com.brunao.bookstore.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brunao.bookstore.service.DBService;

@Configuration
@Profile("dev")
public class DatasourceConfigDev implements DatasourceConfig {

	@Autowired
	DBService dbService;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategyDll;

	@Bean
	@Override
	public void setup() {
		if (strategyDll.equals("create")) {
			dbService.initDbTest();
		}

	}

}
