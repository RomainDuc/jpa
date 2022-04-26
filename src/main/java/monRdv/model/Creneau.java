package monRdv.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "slot")
public class Creneau {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_slot")
	private Date dateCreneau;
	@Temporal(TemporalType.TIME)
	@Column(name = "time_slot")
	private Date heureCreneau;
	@Column(name = "duration")
	private int duree;
	@Column(name = "availability")
	private boolean dispo = true;
	@ManyToOne
	@JoinColumn(name = "practitioner_id")
	private Praticien praticien;
	@ManyToOne
	@JoinColumn(name = "place_id")
	private Lieu lieu;
	@ManyToOne
	@JoinColumn(name = "appointment_id")
	private RendezVous rendezVous;

	public Creneau() {
		super();
	}

	public Creneau(Date dateCreneau, Date heureCreneau, int duree) {
		super();
		this.dateCreneau = dateCreneau;
		this.heureCreneau = heureCreneau;
		this.duree = duree;
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

	public Date getDateCreneau() {
		return dateCreneau;
	}

	public void setDateCreneau(Date dateCreneau) {
		this.dateCreneau = dateCreneau;
	}

	public Date getHeureCreneau() {
		return heureCreneau;
	}

	public void setHeureCreneau(Date heureCreneau) {
		this.heureCreneau = heureCreneau;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

}
