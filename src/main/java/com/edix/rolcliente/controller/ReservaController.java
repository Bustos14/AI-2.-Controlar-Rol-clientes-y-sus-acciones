package com.edix.rolcliente.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.rolcliente.modelo.beans.Cliente;
import com.edix.rolcliente.modelo.beans.Evento;
import com.edix.rolcliente.modelo.beans.Reserva;
import com.edix.rolcliente.modelo.repository.EventoDaoImpl;
import com.edix.rolcliente.modelo.repository.ReservaDaoImpl;


@Controller
public class ReservaController {
	@Autowired
	ReservaDaoImpl rDao;
	@Autowired
	EventoDaoImpl eDao;
	//Controlador para las reservas, se encarga de mandar el formulario una vez se le da al boton enviar.
	//Recibe valores del JSP necesarios por el usuario. Obtiene el evento por ID y el cliente por sesión
	//Se identifica el buen funcionamiento en el mensaje que se muestra al redirigir la página
	@PostMapping("/cliente/reserva/{id}")
	public String nuevaReserva (Model model, RedirectAttributes redirectAttr,HttpSession misession,@RequestParam("observaciones") String observaciones,@RequestParam("cantidad") int cantidad
			, @PathVariable("id") int idEvento, @RequestParam("precioUnitario") int precio) {
		Evento evento = eDao.buscarUno(idEvento);
		Cliente cliente = (Cliente) misession.getAttribute("miCliente");
		int idReserva = rDao.comprobarIdReserva();
		if(observaciones== null) {
			observaciones = "";
		}
		Reserva r = new Reserva(idReserva, evento, cliente, precio,observaciones, cantidad); 
		if(rDao.nuevaReserva(r)==1) {
			redirectAttr.addFlashAttribute("mensaje", "Todo correcto, reserva realizada.");
			System.out.println("Todo correcto, reserva realizada.");
		}else {
			redirectAttr.addFlashAttribute("mensaje", "Problemas al dar de alta, reserva no realizada.");
			System.out.println("Problemas al dar de alta, reserva no realizada.");
		}
		return "redirect:/cliente/inicio";
	}
	
}
