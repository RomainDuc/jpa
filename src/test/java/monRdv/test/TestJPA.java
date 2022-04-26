package monRdv.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import monRdv.Application;
import monRdv.model.Convention;
import monRdv.model.Lieu;
import monRdv.model.Praticien;

public class TestJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Application.getInstance().getEmf();
		
		Praticien dupont = null;
		Long idLieu = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			
			Lieu cabinetDupont = new Lieu("Cabinet"); // new
			cabinetDupont.setNumero("5");
			cabinetDupont.setVoie("rue de Toulouse");
			cabinetDupont.setComplement("1er étage");
			cabinetDupont.setCodePostal("75008");
			cabinetDupont.setVille("Paris");
			cabinetDupont.setCommentaires("code porte : 0325A");
			
			em.persist(cabinetDupont); // managed
			
			System.out.println(cabinetDupont.getId());
			
			idLieu = cabinetDupont.getId();
			
			cabinetDupont.setCodePostal("75014"); // synchro automatique [dirty checking]
			
			dupont = new Praticien("DUPONT", "Pierre"); // new
			dupont.setDureeCreneau(15);
			dupont.setConvention(Convention.SECTEUR_2);
			dupont.setCheque(true);
			dupont.setEspece(true);
			dupont.setCarteBancaire(false);
			
			em.persist(dupont); // managed
			
			em.flush();
			
			em.refresh(cabinetDupont);
			
			
		
			tx.commit(); // em.flush();
		} catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if(em != null) {
				em.close();
			}
		}
	
		
		dupont.setCarteBancaire(true); // detached
		
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			
			Praticien dupontCopy = em.merge(dupont); // dupont => detached et dupontCopy => managed
			
			dupontCopy.setCmu(false); // managed
			
			
			
			Lieu lieu = em.find(Lieu.class, idLieu); // managed
			
			
			
			lieu.setCodePostal("75008"); // synchro auto
			
			
			em.remove(lieu); // removed
		
			tx.commit(); // em.flush();
		} catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if(em != null) {
				em.close();
			}
		}
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Praticien> query = em.createQuery("from Praticien p where p.dureeCreneau = :duree", Praticien.class); // SELECT * FROM practitioner WHERE duration_slot = ?
			
			query.setParameter("duree", 15);
			
			List<Praticien> praticiens = query.getResultList(); // managed
			
			for(Praticien praticien : praticiens) {
				praticien.setCarteBancaire(true);
			}
			
			tx.commit(); // em.flush();
		} catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if(em != null) {
				em.close();
			}
		}
		
	
		

		emf.close();
	}

}
