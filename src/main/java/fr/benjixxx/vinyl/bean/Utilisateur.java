package fr.benjixxx.vinyl.bean;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "paris")
@Table(name = "Utilisateur")
public class Utilisateur {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom", nullable =false, length=100)
	private String nom;
	
	@Column(name="prenom", nullable =false, length=100)
	private String prenom;
	
	@Column(name="email", nullable =false, length=100)
	private String email;
	
	@Column(name="pseudo", nullable =false, length=100)
	private String pseudo ;
	
	@Column(name="motDePasse", nullable =false, length=100)
	private String motDePasse ;
	
	@Column(name="ConfirmationMotDePasse", nullable =false, length=100)
	private String confirmationMotDePasse ;
	
//	@OneToMany
//	@JoinColumn(name="id_vinyl")
    private ArrayList<Vinyl> vinyls = new ArrayList<>();
   
	@Version
    private Long version;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	
	public Utilisateur() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Vinyl> getVinyls() {
		return vinyls;
	}

	public void setVinyls(ArrayList<Vinyl> vinyls) {
		this.vinyls = vinyls;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}

	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}
}
