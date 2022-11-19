package com.edix.rolcliente.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.rolcliente.modelo.beans.Cliente;
import com.edix.rolcliente.modelo.repository.ClienteDaoImpl;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteDaoImpl cDao;
	
	//Llama al jsp de login
	@GetMapping("/login")
	public String mostrarFormularioAlta(Model model){
		return "login";
	}
	//Envia el formulario de Login para comprobar si el cliente introducido existe o no en el array previamente cargado. Si los datos coinciden, manda a login, si no, el login
	//será erroneo
	@PostMapping("/login")
	public String procesarAlta(HttpSession misession,Cliente cliente, @RequestParam("username") String name,@RequestParam("password") String password, RedirectAttributes redirectAttr) {
		cliente = cDao.buscarUno(name, password);
		if(cliente!=null){
			redirectAttr.addFlashAttribute("mensaje", "Bienvenido");
			misession.setAttribute("miCliente", cliente);
			return "redirect:inicio";
		}else {
			redirectAttr.addFlashAttribute("mensaje", "Login Erroneo");
			return "redirect:login";
		}
	}
	//Controla el botón de cerrado de sesión. Comprueba si existe un cliente en sesión y si existe, lo elimina y manda al login nuevamente
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession misession) {
		if(misession.getAttribute("miCliente")!=null) {
			misession.removeAttribute("miCliente");
		}
		return "redirect:login";
		
	}
}
