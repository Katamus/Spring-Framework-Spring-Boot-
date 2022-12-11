package com.bolsadeideas.springboot.di.app.models.services;

//@Component("miServicioSimple")
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante Simple";
	}
	
	

}
