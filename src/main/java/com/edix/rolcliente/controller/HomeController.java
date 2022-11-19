package com.edix.rolcliente.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.rolcliente.modelo.beans.Evento;
import com.edix.rolcliente.modelo.repository.IntEventoDao;

@RequestMapping("/cliente")
@Controller
public class HomeController {
	
	@Autowired
	private IntEventoDao eDao;
	//Controlador de inicio. Se encarga de comprobar si existe un usuario en sesión y enviarlo a la pantalla correspondiente
	//Si no existe usuario, la pantalla que se mostrará será la de login a pesar de que la direccion sea la de inicio. En caso de que haya usuario
	//la pantalla sera la que le corresponde, la de inicio. Y se mostrará el NOMBRE del usuario, que no el username
	@GetMapping("/inicio")
public String procesarInicio(Model model, HttpSession misession) {
		if(misession.getAttribute("miCliente")!= null) {
			List <Evento> lista = eDao.buscarTodos();
			if(model.getAttribute("mensaje")==null) {
				model.addAttribute("mensaje", "Bienvenido");
			}
			model.addAttribute("eventos", lista);
			return "/inicio";
		}else {
			return "redirect:/cliente/login";
		}
	
	}
}
