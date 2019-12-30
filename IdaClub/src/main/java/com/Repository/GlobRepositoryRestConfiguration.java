package com.Repository;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.model.Session;
import com.model.User;


@Configuration
public class GlobRepositoryRestConfiguration  extends RepositoryRestConfigurerAdapter  {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		  config.exposeIdsFor(User.class, Session.class);
		  config.setReturnBodyOnCreate(true);
		    config.setReturnBodyOnUpdate(true);
		    config.getCorsRegistry()
		    .addMapping("/**")
		    .allowedOrigins("http://localhost:4200")
		    .allowedHeaders("*")
		    .allowedMethods("OPIIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
		
	}

}
