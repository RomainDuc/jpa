package monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "users")
public class Utilisateur {
	@Id
	@Column(name = "login", length = 100)
	private String identifiant;
	@Version
	private int version;
	@Column(name = "password", length = 100)
	private String motDePasse;
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Role role;
	@Column(length = 255)
	private String email;
	@Column(name = "phonenumber", length = 20)
	private String telephone;
	@OneToOne(mappedBy = "utilisateur")
	private Praticien praticien = null;
	@OneToMany(mappedBy = "utilisateur")
	private List<Patient> patients = new ArrayList<Patient>();

	public Utilisateur() {
		super();
	}

	public Utilisateur(String identifiant, String motDePasse, Role role) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
