package fr.benjixxx.vinyl;





import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView  home( Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public ModelAndView  profil( Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profil");
		return mv;
	}
}
