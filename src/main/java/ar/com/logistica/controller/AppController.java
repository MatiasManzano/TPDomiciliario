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

import ar.com.logistica.entity.Transporte;
import ar.com.logistica.service.TransporteService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	TransporteService transporteService;

	/**
	 * This method will list all existing transports.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listTransportes(ModelMap model) {

		List<Transporte> transportes = transporteService.findAlltransportes();
		model.addAttribute("transportes", transportes);
		return "transportes";
	}

	/**
	 * This method will provide the medium to add a new transport.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newTransporte(ModelMap model) {
		Transporte transporte = new Transporte();
		model.addAttribute("transporte", transporte);
		model.addAttribute("edit", false);
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveTransporte(@Valid Transporte transporte, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be
		 * implementing custom @Unique annotation and applying it on field [sso]
		 * of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the
		 * 
		 * validation framework as well while still using internationalized
		 * messages.
		 * 
		 */
		if (!transporteService.isTransportePatenteUnique(transporte.getIdTransporte(), transporte.getPatente())) {
			return "registration";
		}

		transporteService.save(transporte);

		model.addAttribute("success", "El transporte " + transporte.getPatente() + " " + transporte.getModelo() + " fue registrado correctamente");
		// return "success";
		return "registrationsuccess";
	}
	
	/**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{patente}" }, method = RequestMethod.GET)
    public String editTransporte(@PathVariable String patente, ModelMap model) {
    	Transporte transporte = transporteService.findByPatente(patente);
        model.addAttribute("transporte", transporte);
        model.addAttribute("edit", true);
        return "registration";
    }
    
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-user-{patente}" }, method = RequestMethod.POST)
    public String updateUser(@Valid Transporte transporte, BindingResult result,
            ModelMap model, @PathVariable String patente) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new 
 
String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }*/
 
        transporteService.updateTransporte(transporte);
 
        model.addAttribute("success", "Transporte " + transporte.getPatente() + " "+ transporte.getModelo() + " updated successfully");
        return "registrationsuccess";
    }
    
    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = { "/delete-user-{patente}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String patente) {
    	transporteService.deleteByPatente(patente);
        return "redirect:/list";
    }

}
