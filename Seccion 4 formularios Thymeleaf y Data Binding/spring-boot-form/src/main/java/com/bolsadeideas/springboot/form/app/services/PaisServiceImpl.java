package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		return lista.stream().filter(data-> id.equals(data.getId())).toList().get(0) ;
	}

	private List<Pais> lista;
	
	public PaisServiceImpl() {
		this.lista =  Arrays.asList(
				new Pais(1, "ES", "España"), new Pais(2, "MX", "Mexico"), new Pais(3, "CL", "Chile"),
				new Pais(4, "AR", "Argenteina"), new Pais(5, "PE", "Perú"), new Pais(6, "CO", "Colombia"),
				new Pais(7, "VE", "Venezuela")
		);
	}

	
}
