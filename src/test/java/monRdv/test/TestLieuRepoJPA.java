package monRdv.test;

import java.util.List;

import monRdv.Application;
import monRdv.model.Lieu;
import monRdv.repository.ILieuRepository;

public class TestLieuRepoJPA {

	public static void main(String[] args) {
		ILieuRepository lieuRepo = Application.getInstance().getLieuRepository();

		Lieu cabinetDupont = new Lieu("Cabinet");
		cabinetDupont.setNumero("5");
		cabinetDupont.setVoie("rue de Toulouse");
		cabinetDupont.setComplement("1er étage");
		cabinetDupont.setCodePostal("75008");
		cabinetDupont.setVille("Paris");
		cabinetDupont.setCommentaires("code porte : 0325A");

		cabinetDupont = lieuRepo.save(cabinetDupont);

		cabinetDupont.setCommentaires("etage 5"); // detached

		cabinetDupont = lieuRepo.save(cabinetDupont);

		Lieu cabinetDupontFind = lieuRepo.findBydId(cabinetDupont.getId());

		System.out.println(cabinetDupontFind.getNom());

		List<Lieu> lieux = lieuRepo.findAll();
		
		System.out.println(lieux.size());
		
		lieuRepo.remove(cabinetDupontFind);
		
		lieux = lieuRepo.findAll();
		
		System.out.println(lieux.size());
	}

}
