package monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "practitioner")
public class Praticien {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "last_name")
	private String nom;
	@Column(name = "first_name")
	private String prenom;
	@Column(name = "duration_slot")
	private int dureeCreneau;
	@Enumerated(EnumType.STRING)
	@Column(name = "norm", length = 15)
	private Convention convention;
	@Column(name = "cmu")
	private boolean cmu;
	@Column(name = "cheque")
	private boolean cheque;
	@Column(name = "cash")
	private boolean espece;
	@Column(name = "creditcard")
	private boolean carteBancaire;
	@OneToOne
	@JoinColumn(name = "users_login")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "praticien")
	private List<Specialite> specialites = new ArrayList<Specialite>();
	@ManyToMany
	@JoinTable(name = "practitioner_place", joinColumns = @JoinColumn(name = "practitioner_id"), inverseJoinColumns = @JoinColumn(name = "place_id"))
	private List<Lieu> lieux = new ArrayList<Lieu>();
	@OneToMany(mappedBy = "praticien")
	private List<Creneau> creneaux = new ArrayList<Creneau>();
	@OneToMany(mappedBy = "praticien")
	private List<Motif> motifs = new ArrayList<Motif>();

	public Praticien() {
		super();
	}

	public Praticien(String nom, String prenom) {
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

	public int getDureeCreneau() {
		return dureeCreneau;
	}

	public void setDureeCreneau(int dureeCreneau) {
		this.dureeCreneau = dureeCreneau;
	}

	public Convention getConvention() {
		return convention;
	}

	public void setConvention(Convention convention) {
		this.convention = convention;
	}

	public boolean isCmu() {
		return cmu;
	}

	public void setCmu(boolean cmu) {
		this.cmu = cmu;
	}

	public boolean isCheque() {
		return cheque;
	}

	public void setCheque(boolean cheque) {
		this.cheque = cheque;
	}

	public boolean isEspece() {
		return espece;
	}

	public void setEspece(boolean espece) {
		this.espece = espece;
	}

	public boolean isCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(boolean carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	public List<Motif> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<Motif> motifs) {
		this.motifs = motifs;
	}

}
