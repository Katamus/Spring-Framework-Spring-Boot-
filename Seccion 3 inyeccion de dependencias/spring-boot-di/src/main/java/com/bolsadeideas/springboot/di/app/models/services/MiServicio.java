package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.stereotype.Component;

@Component
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante...";
	}

}
