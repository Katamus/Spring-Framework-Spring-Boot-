package com.bolsadeideas.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editors.NombreEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, "nombre", new NombreEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreEditor());
	}

	@GetMapping("/form")
	public String form(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Jhon");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-k");
		model.addAttribute("titulo", "Formulario usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		// validador.validate(usuario, result);
		model.addAttribute("titulo", "Resultado del formulario");
		if (result.hasErrors()) {
			return "form";
		}
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("España", "Mexico", "Chile", "Argenteina", "Perú", "Colombia", "Venezuela");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<>();
		paises.put("ES", "España");
		paises.put("MX", "Mexico");
		paises.put("CL", "Chile");
		paises.put("AR", "Argenteina");
		paises.put("PE", "Perú");
		paises.put("CO", "Colombia");
		paises.put("VE", "Venezuela");
		return paises;
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {

		return Arrays.asList(
				new Pais(1, "ES", "España"), new Pais(2, "MX", "Mexico"), new Pais(3, "CL", "Chile"),
				new Pais(4, "AR", "Argenteina"), new Pais(5, "PE", "Perú"), new Pais(6, "CO", "Colombia"),
				new Pais(7, "VE", "Venezuela")
		);

	}

}
