package com.ciberfarma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciberfarma.models.OrdenCompra;
import com.ciberfarma.repositories.IOrdenCompraRepository;
import com.ciberfarma.repositories.IProveedorRepository;
import com.ciberfarma.utils.Alert;

@Controller
public class ProyectoController {

	@Autowired
	private IOrdenCompraRepository _ordenCompraRepository;
	
	@Autowired
	private IProveedorRepository _proveedorRepository;
	
	@GetMapping("/listado")
	public String listado(Model model) {
		List<OrdenCompra> lstOrdenCompra = _ordenCompraRepository.findAllByOrderByNroOrdenDesc();
		model.addAttribute("lstOrdenCompra", lstOrdenCompra);
		return "listadoCorzo";
	}
	

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		model.addAttribute("ordenCompra", new OrdenCompra());
		return "nuevoCorzo";
	}
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute OrdenCompra ordenCompra, Model model, RedirectAttributes flash) {
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		
		OrdenCompra registrado = _ordenCompraRepository.save(ordenCompra);
		String mensaje = Alert.sweetAlertSuccess("Orden de Compra número "+ registrado.getNroOrden()+ " registrado.");
		flash.addFlashAttribute("alert", mensaje);
		return "redirect:/listado";
	}
	
	@GetMapping("/edicion/{id}")
	public String edicion(@PathVariable Integer id , Model model) {
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		
		OrdenCompra ordenCompra = _ordenCompraRepository.findById(id).orElseThrow();
	    model.addAttribute("ordenCompra", ordenCompra); 
		return "edicionCorzo";
	}
	
	@PostMapping("/actualizar")
	public String guardar(@ModelAttribute OrdenCompra ordenCompra, Model model, RedirectAttributes flash) {
		model.addAttribute("proveedores", _proveedorRepository.findAll());

		OrdenCompra registrado = _ordenCompraRepository.save(ordenCompra);
		String mensaje = Alert.sweetAlertSuccess("Orden de Compra número "+ registrado.getNroOrden()+ " actualizado.");
		flash.addFlashAttribute("alert", mensaje);
		return "redirect:/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id, RedirectAttributes flash) {
		_ordenCompraRepository.deleteById(id);
		String mensaje = Alert.sweetAlertSuccess("Orden de Compra número " + id + " eliminado.");
		flash.addFlashAttribute("alert", mensaje);

		return "redirect:/listado";
	}
}
