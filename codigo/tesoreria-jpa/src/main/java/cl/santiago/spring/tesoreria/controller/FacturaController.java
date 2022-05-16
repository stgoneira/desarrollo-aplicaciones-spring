package cl.santiago.spring.tesoreria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.santiago.spring.tesoreria.model.Factura;
import cl.santiago.spring.tesoreria.repository.FacturaRepository;
import cl.santiago.spring.tesoreria.repository.ProveedorRepository;

@RequestMapping("/factura")
@Controller
public class FacturaController {

	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	@PostMapping("/procesar")
	public String procesar(@Valid Factura factura, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) return "proveedor/form"; 
		
		facturaRepository.saveAndFlush( factura );
		return "redirect:/factura/listado";
	}
	
	@GetMapping("/nueva")
	public String nuevo(Factura factura, Model modelo) {
		modelo.addAttribute("proveedores", proveedorRepository.findAll());
		return "factura/form";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(name = "id") Factura factura, Model modelo) {
		modelo.addAttribute("proveedores", proveedorRepository.findAll());
		modelo.addAttribute("factura", factura);
		return "factura/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		facturaRepository.deleteById(id);
		return "redirect:/factura/listado";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		List<Factura> facturas = facturaRepository.findAll();
		modelo.addAttribute("facturas", facturas);
		return "factura/listado";
	}
	
}
