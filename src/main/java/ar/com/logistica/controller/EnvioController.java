package ar.com.logistica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.logistica.entity.CategoriaPaquete;
import ar.com.logistica.entity.Envio;
import ar.com.logistica.entity.Localidad;
import ar.com.logistica.entity.TipoPaquete;
import ar.com.logistica.entity.Transporte;
import ar.com.logistica.service.CategoriaPaqueteService;
import ar.com.logistica.service.EnvioService;
import ar.com.logistica.service.LocalidadService;
import ar.com.logistica.service.TipoPaqueteService;
import ar.com.logistica.service.TransporteService;

@Controller
public class EnvioController {
	
	@Autowired
	EnvioService envioService;
	@Autowired
	LocalidadService localidadService;
	@Autowired
	CategoriaPaqueteService categoriaPaqueteService;
	@Autowired
	TipoPaqueteService tipoPaqueteService;
	@Autowired
	TransporteService transporteService;
	
	
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
		List<CategoriaPaquete> categoriasPaquete = categoriaPaqueteService.findAllCategoriasPaquete();
		List<TipoPaquete> tiposPaquete = tipoPaqueteService.findAllTiposPaquete();
		List<Transporte> transportes = transporteService.findAlltransportes();
		
		model.addAttribute("envio", envio);
		model.addAttribute("localidades", localidades);
		model.addAttribute("categoriasPaquete", categoriasPaquete);
		model.addAttribute("tiposPaquete", tiposPaquete);
		model.addAttribute("transportes", transportes);
		model.addAttribute("edit", false);
		
		return "altaEnvio";
	}


	@RequestMapping(value = { "/nuevoEnvio" }, method = RequestMethod.POST)
	public String saveEnvio(@Valid Envio envio, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaEnvio";
		}

		if (!envioService.isNroEnvioUnique(envio.getNumeroEnvio())) {
			return "altaEnvio";
		}

		envioService.save(envio);

		model.addAttribute("success",
				"El envio " + envio.getNumeroEnvio() + " fue registrado con exito");
		
		return "altaSuccess";
	}
	
	@RequestMapping(value = { "/edit-envio-{numeroEnvio}" }, method = RequestMethod.GET)
	public String editEnvio(@PathVariable long numeroEnvio, ModelMap model) {
		Envio envio = envioService.findByNroEnvio(numeroEnvio);
		
		List<Localidad> localidades = localidadService.findAllLocalidades();
		List<CategoriaPaquete> categoriasPaquete = categoriaPaqueteService.findAllCategoriasPaquete();
		List<TipoPaquete> tiposPaquete = tipoPaqueteService.findAllTiposPaquete();
		List<Transporte> transportes = transporteService.findAlltransportes();
		
		model.addAttribute("envio", envio);
		model.addAttribute("localidades", localidades);
		model.addAttribute("categoriasPaquete", categoriasPaquete);
		model.addAttribute("tiposPaquete", tiposPaquete);
		model.addAttribute("transportes", transportes);
		model.addAttribute("edit", true);
		
		return "altaEnvio";
	}
	 
	@RequestMapping(value = { "/edit-envio-{numeroEnvio}" }, method = RequestMethod.POST)
	public String updateEnvio(@Valid Envio envio, BindingResult result, ModelMap model,
			@PathVariable long numeroEnvio) {

		if (result.hasErrors()) {
			return "altaEnvio";
		}

		envioService.updateEnvio(envio);

		model.addAttribute("success",
				"El plan de envio " + envio.getNumeroEnvio() + " fue modificado con exito");
		
		return "altaSuccess";
	}
	
	
	@RequestMapping(value = { "/delete-envio-{numeroEnvio}" }, method = RequestMethod.GET)
    public String deleteEnvio(@PathVariable long numeroEnvio) {
		envioService.deleteByNroEnvio(numeroEnvio);
        return "redirect:/listaEnvios";
    }

}
