package ar.com.logistica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.logistica.entity.Direccion;
import ar.com.logistica.entity.Envio;
import ar.com.logistica.entity.Localidad;
import ar.com.logistica.service.CategoriaPaqueteService;
import ar.com.logistica.service.DireccionService;
import ar.com.logistica.service.EnvioService;
import ar.com.logistica.service.LocalidadService;
import ar.com.logistica.service.PaqueteService;
import ar.com.logistica.service.TipoPaqueteService;

@Controller
public class EnvioController {
	
	@Autowired
	EnvioService envioService;
	
	@Autowired
	DireccionService direccionService;
	
	@Autowired
	LocalidadService localidadService;
	
	@Autowired
	PaqueteService paqueteService;
	
	@Autowired
	CategoriaPaqueteService categoriaPaqueteService;
	
	@Autowired
	TipoPaqueteService tipoPaqueteService;
	
	@RequestMapping(value = { "/listaEnvios" }, method = RequestMethod.GET)
	public String listaEnvios(ModelMap model) {

		List<Envio> envios = envioService.findAllEnvios();
		model.addAttribute("envios", envios);
		return "envios";
	}
	
	@RequestMapping(value = { "/nuevoEnvio" }, method = RequestMethod.GET)
	public String newEnvio(ModelMap model) {
		Envio envio = new Envio();
		List<Localidad> localidades = localidadService.findAllLocalidades();
		model.addAttribute("envio", envio);
		model.addAttribute("localidades", localidades);
		model.addAttribute("edit", false);
		return "altaEnvio";
	}


//	@RequestMapping(value = { "/nuevoEnvio" }, method = RequestMethod.POST)
//	public String saveEnvio(@Valid Envio envio, BindingResult result, ModelMap model) {
//
//		if (result.hasErrors()) {
//			return "altaDireccion";
//		}
//
//		if (!direccionService.isCalleDireccionUnique(direccion.getIdDireccion(), direccion.getCalle())) {
//			return "altaDireccion";
//		}
//		
//		direccionService.save(direccion);
//
//		model.addAttribute("success",
//				"La dirección " + direccion.getCalle() + " " + direccion.getNumero() + " fue registrada correctamente");
//		return "altaSuccess";
//	}

}
