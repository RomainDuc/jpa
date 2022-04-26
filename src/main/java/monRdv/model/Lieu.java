package monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "place")
public class Lieu {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "name", length = 100)
	private String nom;
	@Column(name = "number", length = 4)
	private String numero;
	@Column(name = "street", length = 255)
	private String voie;
	@Column(length = 1000)
	private String complement;
	@Column(name = "zipcode", length = 10)
	private String codePostal;
	@Column(name = "city", length = 100)
	private String ville;
	@Column(name = "comments", length = 4000)
	private String commentaires;
	@ManyToMany(mappedBy = "lieux", fetch = FetchType.EAGER)
	private List<Praticien> praticiens = new ArrayList<Praticien>();
	@OneToMany(mappedBy = "lieu")
	private List<Creneau> creneaux = new ArrayList<Creneau>();

	public Lieu() {
		super();
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

	public Lieu(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public List<Praticien> getPraticiens() {
		return praticiens;
	}

	public void setPraticiens(List<Praticien> praticiens) {
		this.praticiens = praticiens;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

}
