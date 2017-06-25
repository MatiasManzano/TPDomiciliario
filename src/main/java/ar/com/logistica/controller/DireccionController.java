package ar.com.logistica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.logistica.entity.Direccion;
import ar.com.logistica.entity.Localidad;
import ar.com.logistica.service.DireccionService;
import ar.com.logistica.service.LocalidadService;

@Controller
public class DireccionController {

	@Autowired
	DireccionService direccionService;
	
	@Autowired
	LocalidadService localidadService;

	/**
	 * This method will list all existing transports.
	 */
	@RequestMapping(value = { "/listaDirecciones" }, method = RequestMethod.GET)
	public String listDirecciones(ModelMap model) {

		List<Direccion> direcciones = direccionService.findAllDirecciones();
		model.addAttribute("direcciones", direcciones);
		return "direcciones";
	}

	/**
	 * This method will provide the medium to add a new transport.
	 */
	@RequestMapping(value = { "/nuevaDireccion" }, method = RequestMethod.GET)
	public String newDireccion(ModelMap model) {
		Direccion direccion = new Direccion();
		List<Localidad> localidades = localidadService.findAllLocalidades();
		model.addAttribute("direccion", direccion);
		model.addAttribute("localidades", localidades);
		model.addAttribute("edit", false);
		return "altaDireccion";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/nuevaDireccion" }, method = RequestMethod.POST)
	public String saveDireccion(@Valid Direccion direccion, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaDireccion";
		}

		if (!direccionService.isCalleDireccionUnique(direccion.getIdDireccion(), direccion.getCalle())) {
			return "altaDireccion";
		}
		
		direccionService.save(direccion);

		model.addAttribute("success",
				"La dirección " + direccion.getCalle() + " " + direccion.getNumero() + " fue registrada correctamente");
		return "altaSuccess";
	}

}
