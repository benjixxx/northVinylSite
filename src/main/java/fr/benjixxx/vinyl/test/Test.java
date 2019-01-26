package fr.benjixxx.vinyl.test;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.benjixxx.vinyl.bean.Utilisateur;
import fr.benjixxx.vinyl.dao.UtilisateurDao;

public class Test {
 
	@Autowired
	private UtilisateurDao utilisateurDao;

	@RequestMapping(value = "/test-data", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	  Utilisateur u1 = new Utilisateur();
	  u1.setNom("dusse");
	  u1.setPrenom("Jean-calude");
	  u1.setEmail("jc@gmail.com");
	  try {
			utilisateurDao.save(u1);
		} catch (Exception e) {
			e.printStackTrace();
		}
       return "home";
	}
	
	
	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}


}
