package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante Complejo";
	}
	
	

}
