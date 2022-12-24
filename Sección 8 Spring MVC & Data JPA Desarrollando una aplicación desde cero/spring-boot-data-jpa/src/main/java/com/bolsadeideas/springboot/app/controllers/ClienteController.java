package com.bolsadeideas.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.services.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = {"/listar","","/"}, method = RequestMethod.GET)
	public String listar(@RequestParam(name="page",defaultValue = "0") int page,Model model) {
		Pageable pageable = PageRequest.of(page, 4);
		Page<Cliente> clientes = clienteService.findAll(pageable);
		model.addAttribute("titulo", "Litado de clientes");
		model.addAttribute("clientes", clientes);
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
	public String editar(@PathVariable(value = "id") Long id ,Model model,RedirectAttributes flash) {
		Cliente cliente = null;
		if(id>0) {
			flash.addFlashAttribute("error", "El id del Cliente no puede ser 0");
			cliente = clienteService.findOne(id);
		}
		
		if(cliente == null){
			flash.addFlashAttribute("error", "El id del Cliente no existe en la BBDD");
			return "redirect:/listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar el cliente");
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash,SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Litado de clientes");
			return "form";
		}
		clienteService.save(cliente);
		status.setComplete();
		String mensaje = cliente.getId() != null ?  "Cliente Editado con exíto" : "Cliente Creado con exíto";
		flash.addFlashAttribute("success", mensaje);
		return "redirect:listar";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id,RedirectAttributes flash ) {
		if(id > 0) {
			clienteService.delete(id);
		}
		flash.addFlashAttribute("danger", "Cliente Eliminado con exíto");
		return "redirect:/listar";
	}

}
