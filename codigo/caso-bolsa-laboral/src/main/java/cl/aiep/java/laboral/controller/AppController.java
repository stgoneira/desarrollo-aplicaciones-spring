package cl.aiep.java.laboral.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/otra")
	public String otra(Principal principal, Authentication authentication, Model model) {
		model.addAttribute("usuario", authentication);
		System.out.println( principal.getName() );
		System.out.println( authentication.getAuthorities() );
		return "otra";
	}
	
	@GetMapping("/otro2")
	@Secured({"ROLE_ADMIN"})
	public String otro(Principal principal, Authentication authentication, Model model) {
		System.out.println( principal.getName() );
		System.out.println( authentication.getAuthorities() );
		return "otra";
	}
	
}
