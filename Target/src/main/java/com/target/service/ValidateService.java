package com.target.service;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

@Configuration
@PropertySource(value="classpath:application.properties")
@Service
public class ValidateService implements IValidateService {

	@Value("#{'${my.list.of.strings}'.split(',')}") 
	private List<String> abusiveWords;
	
	@Override
	public boolean IsAbusiveWordsUsed(String comment) {
		
		Iterator<String> wordsIteator = abusiveWords.iterator();
		while (wordsIteator.hasNext()) {
			if (comment.toLowerCase().contains(wordsIteator.next().toLowerCase()))
				return false;
		}
		return true;
	}
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}


}
