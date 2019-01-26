package fr.benjixxx.vinyl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "paris")
@Table(name = "Vinyl")
public class Vinyl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nomArtiste", nullable = false, length = 100)
	private String nomArtiste;

	@Column(name = "nomVinyl", nullable = false, length = 100)
	private String nomVinyl;

	@Column(name = "Catégories", nullable = false, length = 100)
	private String Categorie;

	@Column(name = "prix", nullable = false, length = 10)
	private double prix;

	@Column(name = "format", nullable = false, length = 10)
	private String format;

	@Column(name = "etat", nullable = false, length = 10)
	private String etat;

	public Vinyl() {
	}

	public Vinyl(Long id, String nomArtiste, String nomVinyl, String categorie, double prix, String format,
			String etat) {
		super();
		this.id = id;
		this.nomArtiste = nomArtiste;
		this.nomVinyl = nomVinyl;
		Categorie = categorie;
		this.prix = prix;
		this.format = format;
		this.etat = etat;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public String getNomVinyl() {
		return nomVinyl;
	}

	public void setNomVinyl(String nomVinyl) {
		this.nomVinyl = nomVinyl;
	}

	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String categorie) {
		Categorie = categorie;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
