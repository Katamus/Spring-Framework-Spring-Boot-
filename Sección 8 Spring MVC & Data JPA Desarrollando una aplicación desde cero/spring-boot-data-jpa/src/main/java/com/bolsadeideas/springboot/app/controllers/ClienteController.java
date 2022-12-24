package com.bolsadeideas.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.services.IClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = {"/listar","","/"}, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Litado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Formulario del cliente");
		return "form";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id ,Model model) {
		Cliente cliente = null;
		if(id>0) {
			 cliente = clienteService.findOne(id);
		}else {
			return "redirect:listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar el cliente");
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Litado de clientes");
			return "form";
		}
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:listar";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id ) {
		if(id > 0) {
			clienteService.delete(id);
		}
		return "redirect:/listar";
	}

}
