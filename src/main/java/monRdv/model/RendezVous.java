package monRdv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "appointment")
public class RendezVous {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 15)
	private Statut statut;
	@Temporal(TemporalType.DATE)
	@Column(name = "appointement_date")
	private Date dtPriseRdv;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@OneToOne
	@JoinColumn(name = "reason_id")
	private Motif motif;
	@OneToMany(mappedBy = "rendezVous")
	private List<Creneau> creneaux = new ArrayList<Creneau>();

	public RendezVous() {
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

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Date getDtPriseRdv() {
		return dtPriseRdv;
	}

	public void setDtPriseRdv(Date dtPriseRdv) {
		this.dtPriseRdv = dtPriseRdv;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

}
