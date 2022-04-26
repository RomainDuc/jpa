package monRdv;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import monRdv.repository.ICreneauRepository;
import monRdv.repository.ILieuRepository;
import monRdv.repository.IMotifRepository;
import monRdv.repository.IPatientRepository;
import monRdv.repository.IPraticienRepository;
import monRdv.repository.IRendezVousRepository;
import monRdv.repository.ISpecialiteRepository;
import monRdv.repository.IUtilisateurRepository;
import monRdv.repository.jpa.CreneauRepositoryJpa;
import monRdv.repository.jpa.LieuRepositoryJpa;
import monRdv.repository.jpa.MotifRepositoryJpa;
import monRdv.repository.jpa.PatientRepositoryJpa;
import monRdv.repository.jpa.PraticienRepositoryJpa;
import monRdv.repository.jpa.RendezVousRepositoryJpa;
import monRdv.repository.jpa.SpecialiteRepositoryJpa;
import monRdv.repository.jpa.UtilisateurRepositoryJpa;

public final class Application {

	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mon-rdv");

	private final ICreneauRepository creneauRepository = new CreneauRepositoryJpa();
	private final ILieuRepository lieuRepository = new LieuRepositoryJpa();
	private final IMotifRepository motifRepository = new MotifRepositoryJpa();
	private final IPatientRepository patientRepository = new PatientRepositoryJpa();
	private final IPraticienRepository praticienRepository = new PraticienRepositoryJpa();
	private final IRendezVousRepository rendezVousRepository = new RendezVousRepositoryJpa();
	private final ISpecialiteRepository specialiteRepository = new SpecialiteRepositoryJpa();
	private final IUtilisateurRepository utilisateurRepository = new UtilisateurRepositoryJpa();

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public ICreneauRepository getCreneauRepository() {
		return creneauRepository;
	}

	public ILieuRepository getLieuRepository() {
		return lieuRepository;
	}

	public IMotifRepository getMotifRepository() {
		return motifRepository;
	}

	public IPatientRepository getPatientRepository() {
		return patientRepository;
	}

	public IPraticienRepository getPraticienRepository() {
		return praticienRepository;
	}

	public IRendezVousRepository getRendezVousRepository() {
		return rendezVousRepository;
	}

	public ISpecialiteRepository getSpecialiteRepository() {
		return specialiteRepository;
	}

	public IUtilisateurRepository getUtilisateurRepository() {
		return utilisateurRepository;
	}

}
