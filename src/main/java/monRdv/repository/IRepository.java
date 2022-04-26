package monRdv.repository;

import java.util.List;

public interface IRepository<T,PK> {
	List<T> findAll();
	T findBydId(PK id);
	T save(T obj);
	void remove(T obj);
}
