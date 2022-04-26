package monRdv.test;

import monRdv.Application;
import monRdv.model.Convention;
import monRdv.model.Lieu;
import monRdv.model.Praticien;
import monRdv.model.Specialite;
import monRdv.repository.ILieuRepository;
import monRdv.repository.IPraticienRepository;
import monRdv.repository.ISpecialiteRepository;

public class TestRepoJPA {
	public static void main(String[] args) {
		
		ILieuRepository lieuRepo = Application.getInstance().getLieuRepository();
		IPraticienRepository praticienRepo = Application.getInstance().getPraticienRepository();
		ISpecialiteRepository specialiteRepo = Application.getInstance().getSpecialiteRepository();
		
		Lieu cabinetDupont = new Lieu("Cabinet");
		cabinetDupont.setNumero("5");
		cabinetDupont.setVoie("rue de Toulouse");
		cabinetDupont.setComplement("1er étage");
		cabinetDupont.setCodePostal("75008");
		cabinetDupont.setVille("Paris");
		cabinetDupont.setCommentaires("code porte : 0325A");
		
		cabinetDupont = lieuRepo.save(cabinetDupont);

		Praticien dupont = new Praticien("DUPONT", "Pierre");
		dupont.setDureeCreneau(15);
		dupont.setConvention(Convention.SECTEUR_2);
		dupont.setCheque(true);
		dupont.setEspece(true);
		dupont.setCarteBancaire(false);
		
		dupont.getLieux().add(cabinetDupont);
		cabinetDupont.getPraticiens().add(dupont); // ne sert à rien pour JPA
		
		dupont = praticienRepo.save(dupont);

		Specialite dupontGeneraliste = new Specialite();
		dupontGeneraliste.setNom("Généraliste");
		dupontGeneraliste.setDescription("Médecine Générale");
		dupontGeneraliste.setPraticien(dupont);
		
		dupontGeneraliste = specialiteRepo.save(dupontGeneraliste);
		
		System.out.println("##########");
		
		cabinetDupont = lieuRepo.findBydId(cabinetDupont.getId()); // refresh via find du lieu avec les praticiens (problème LAZY loading)
		
		for(Praticien praticien : cabinetDupont.getPraticiens()) {
			System.out.println(praticien.getNom());
		}
		
	}
}
