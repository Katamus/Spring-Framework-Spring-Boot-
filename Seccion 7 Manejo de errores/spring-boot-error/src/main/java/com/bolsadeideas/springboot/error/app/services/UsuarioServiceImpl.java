package com.bolsadeideas.springboot.error.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		lista = Arrays.asList(
				new Usuario(1,"a1","b1"),
				new Usuario(2,"a2","b2"),
				new Usuario(3,"a3","b3"),
				new Usuario(4,"a4","b4"),
				new Usuario(5,"a5","b5"),
				new Usuario(6,"a6","b6"),
				new Usuario(7,"a7","b7"),
				new Usuario(8,"a8","b8")
				);
	}

	@Override
	public List<Usuario> listar() {
		return lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario usuario = null;
		for (Usuario item : lista) {
			if(id.equals(item.getId())) {
				usuario = item; 
				break;
			}
		}
		return usuario;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
