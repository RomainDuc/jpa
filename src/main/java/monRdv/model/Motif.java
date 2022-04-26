package monRdv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "reason")
public class Motif {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "title", length = 255)
	private String intitule;
	@Column(name = "price")
	private double tarif;
	@Column(name = "slot_number")
	private int nbCreneau;
	@ManyToOne
	@JoinColumn(name = "practitioner_id")
	private Praticien praticien;

	public Motif() {
		super();
	}

	public Motif(String intitule, double tarif, int nbCreneau) {
		super();
		this.intitule = intitule;
		this.tarif = tarif;
		this.nbCreneau = nbCreneau;
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

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public int getNbCreneau() {
		return nbCreneau;
	}

	public void setNbCreneau(int nbCreneau) {
		this.nbCreneau = nbCreneau;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

}
