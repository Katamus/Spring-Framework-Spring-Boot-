package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index","","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework con model!");
		return "index";
	}
	
	@RequestMapping(value = "/perfil" , method = RequestMethod.GET )
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Guzmán");
		usuario.setEmail("andres@correo.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping(value = "/listar" , method = RequestMethod.GET )
	public String listar(Model model) {
		List<Usuario> usuarios = Arrays.asList(
					new Usuario("Andres","Guzman","andres@correo.com"),
					new Usuario("Jhon","Guzman","andres@correo.com"),
					new Usuario("Jay","Guzman","andres@correo.com"),
					new Usuario("Tornado","Roe","andres@correo.com"));
		
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}

}
