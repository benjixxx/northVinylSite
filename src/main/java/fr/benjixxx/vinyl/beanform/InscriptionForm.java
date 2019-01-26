package fr.benjixxx.vinyl.beanform;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InscriptionForm {

	@NotEmpty
	@Size(min = 2, max = 50)
	private String prenom;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String nom;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String nomUtilisateur;

	@NotEmpty
	@Size(min = 4, max = 50)
	private String motDePasse;

	@NotEmpty
	@Size(min = 4, max = 50)
	private String confirmationMotDePasse;

	@NotEmpty
	@Pattern(regexp = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", message = "l'email n'est pas valide ")
	private String email;

	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}

	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
