package monRdv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "last_name", length = 100)
	private String nom;
	@Column(name = "first_name", length = 100)
	private String prenom;
	private boolean principal;
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	private Date dateNaissance;
	@ManyToOne
	@JoinColumn(name = "users_login")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "patient")
	private List<RendezVous> rendezVous = new ArrayList<RendezVous>();

	public Patient() {
		super();
	}

	public Patient(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

}
