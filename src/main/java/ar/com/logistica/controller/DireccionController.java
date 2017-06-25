package ar.com.logistica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * Muestro una lista de direcciones.
	 */
	@RequestMapping(value = { "/listaDirecciones" }, method = RequestMethod.GET)
	public String listDirecciones(ModelMap model) {

		List<Direccion> direcciones = direccionService.findAllDirecciones();
		model.addAttribute("direcciones", direcciones);
		return "direcciones";
	}

	/**
	 * Agrego una direccion.
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
	 * Este metodo se llama cuando hago submit, maneja el POST request para
	 * guardar la direccion en la base. Tambien valida lo que ingresa el usuario
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
	
	/**
     * Modifico una direccion.
     */
    @RequestMapping(value = { "/edit-direccion-{idDireccion}" }, method = RequestMethod.GET)
    public String editDireccion(@PathVariable long idDireccion, ModelMap model) {
    	Direccion direccion = direccionService.findById(idDireccion);
    	List<Localidad> localidades = localidadService.findAllLocalidades();
        model.addAttribute("direccion", direccion);
        model.addAttribute("localidades", localidades);
        model.addAttribute("edit", true);
        return "altaDireccion";
    }
     
    /**
     * Este metodo se llama cuando hago submit, maneja el POST request para
	 * guardar la direccion en la base. Tambien valida lo que ingresa el usuario
     */
    @RequestMapping(value = { "/edit-direccion-{idDireccion}" }, method = RequestMethod.POST)
    public String updateDireccion(@Valid Direccion direccion, BindingResult result,
            ModelMap model, @PathVariable long idDireccion) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        direccionService.updateDireccion(direccion);
 
        model.addAttribute("success", "La dirección " + direccion.getCalle() + " " + direccion.getNumero() + " fue modificada con exito");
        return "altaSuccess";
    }
    
    /**
     * Elimino una direccion
     */
    @RequestMapping(value = { "/delete-direccion-{calle}" }, method = RequestMethod.GET)
    public String deleteDireccion(@PathVariable String calle) {
    	direccionService.deleteByCalle(calle);
        return "redirect:/listaDirecciones";
    }

}
