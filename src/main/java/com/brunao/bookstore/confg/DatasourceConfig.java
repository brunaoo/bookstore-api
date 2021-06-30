package com.brunao.bookstore.confg;

import org.springframework.context.annotation.Bean;

public interface DatasourceConfig {
	
	@Bean
	public void setup();

}
