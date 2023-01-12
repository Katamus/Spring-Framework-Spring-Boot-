package com.bolsadeideas.springboot.app.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAutorityMixin {

	@JsonCreator
	public SimpleGrantedAutorityMixin(@JsonProperty("authority") String role) {
		
	}
	
	

}
