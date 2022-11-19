package com.edix.rolcliente.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.rolcliente.modelo.beans.Evento;
import com.edix.rolcliente.modelo.repository.IntEventoDao;

@Controller
@RequestMapping("/cliente")
public class EventController {

	
	@Autowired
	private IntEventoDao eDao;
	
	//Obtengo el listado de TODOS los eventos ACTIVOS que existen y se muestran en el JSP "inicio"
	@GetMapping("/activos")
	public String mostrarActivos(Model model) {
		List<Evento> activos = eDao.buscarActivos();
		model.addAttribute("eventos", activos);
		model.addAttribute("mensaje", "Eventos activos");
		return "inicio";
	}
	//Obtengo el listado de TODOS los eventos que existen y se muestran en el JSP "inicio"
	@GetMapping("/todos")
	public String mostrarTodos(Model model) {
		List<Evento> todos = eDao.buscarTodos();
		model.addAttribute("eventos", todos);
		model.addAttribute("mensaje", "Todos los eventos");
		return "inicio";
	}
	//Obtengo el listado de TODOS los eventos DESTACADOS que existen y se muestran en el JSP "inicio"
	@GetMapping("/destacados")
	public String mostrarDestacados(Model model) {
		List<Evento> destacados = eDao.buscarDestacados();
		model.addAttribute("eventos", destacados);
		model.addAttribute("mensaje", "Eventos destacados");
		return "inicio";
	}
	//Metodo que guarda el evento de la filla seleccionada en el detalle para llevarlo al JSP Detalle y poder ver sus detalles y hacer una reserva
	//en caso de que el cliente quiera
	@GetMapping("/detalle/{id}")
	public String mostrarDetalles(Model model,  @PathVariable("id") int idEvento) {
		Evento evento = eDao.buscarUno(idEvento);
		model.addAttribute("eventoDetalle", evento);
		return "detalle";
		
	}
	
	//Formateador para fechas 
		@InitBinder
		public void initBinder (WebDataBinder binder) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		}
}
