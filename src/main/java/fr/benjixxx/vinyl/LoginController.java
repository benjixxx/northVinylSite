package fr.benjixxx.vinyl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.benjixxx.vinyl.bean.Utilisateur;
import fr.benjixxx.vinyl.beanform.InscriptionForm;
import fr.benjixxx.vinyl.beanform.LoginForm;
import fr.benjixxx.vinyl.dao.UtilisateurDao;

@Controller
public class LoginController {

	@Autowired
	private UtilisateurDao utilisateurDao;

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public ModelAndView inscription(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		InscriptionForm form = new InscriptionForm();
		model.put("inscription-form", form);
		return new ModelAndView("inscription", model);
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ModelAndView checkInscription(HttpServletRequest request,
			@Valid @ModelAttribute("inscription-form") InscriptionForm form, BindingResult result) {
		Map<String, Object> model = new HashMap<>();
		if (result.hasErrors()) {
			model.put("errors", result);
			model.put("inscription-form", form);
			return new ModelAndView("inscription", model);
		}
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPrenom(form.getPrenom());
		utilisateur.setNom(form.getNom());
		utilisateur.setPseudo(form.getNomUtilisateur());
		utilisateur.setEmail(form.getEmail());
		utilisateur.setMotDePasse(form.getMotDePasse());
		utilisateur.setConfirmationMotDePasse(form.getConfirmationMotDePasse());

		try {
			utilisateurDao.save(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
			model.put("msg", "Erreur lors de l'enregistrement, veuillez réessayer");
			model.put("errors", result);
			return new ModelAndView("redirect:/inscription", model);

		}
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public ModelAndView connexion(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		LoginForm lf = new LoginForm("", "");
		model.put("connexion-form", lf);
		return new ModelAndView("connexion", model);
	}

	@RequestMapping(value = "connexion", method = RequestMethod.POST)
	public ModelAndView checkConnexion(HttpServletRequest request,
			@Valid @ModelAttribute("connexion-form") LoginForm form, BindingResult result) {
		Map<String, Object> model = new HashMap<>();
		if (result.hasErrors()) {
			model.put("errors", result);
			model.put("connexion-form", form);
			return new ModelAndView("connexion", model);
		}
		Utilisateur u = utilisateurDao.findByEmail(form.getNomUtilisateur());
		if (u != null && u.getMotDePasse().equals(form.getMotDePasse())) {
			request.getSession().setAttribute("user_id", u.getId());
			request.getSession().setAttribute("user_name", u.getPseudo());
			System.out.println(u.getNom() + " " + u.getPrenom());
			return new ModelAndView("redirect:/profil");
		} else {
			model.put("connexion-form", form);
			model.put("msg", "Error : incorrect login or password !");
			return new ModelAndView("connexion", model);
		}
	}

	@RequestMapping("/deconnexion")
	public ModelAndView deconnexion(HttpServletRequest request) {
		request.getSession().removeAttribute("user_name");
		request.getSession().removeAttribute("user_id");
		return new ModelAndView("redirect:/home");
	}

	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

}
