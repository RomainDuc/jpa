package monRdv.repository;

import java.util.List;

import monRdv.model.Lieu;

public interface ILieuRepository extends IRepository<Lieu, Long> {
	List<Lieu> findAllByVille(String ville);
}
