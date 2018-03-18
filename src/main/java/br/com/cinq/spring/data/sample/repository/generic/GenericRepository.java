package br.com.cinq.spring.data.sample.repository.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericRepository<T> {

	@PersistenceContext
	EntityManager em;
	private final Class<T> persistedClass;

	protected GenericRepository(Class<T> persistedClass) {
		this.persistedClass = persistedClass;
	}

	public T findById(Long id) {
		return em.find(persistedClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT T FROM ");
		sb.append(persistedClass.getSimpleName());
		sb.append(" T ");
		return em.createQuery(sb.toString(), persistedClass).getResultList();
	}

	protected EntityManager getEm() {
		return em;
	}

	protected void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional(rollbackOn = Throwable.class)
	public void insert(T entity) {
		em.persist(entity);
	}

	@Transactional(rollbackOn = Throwable.class)
	public void insert(List<T> entities) {
		entities.forEach(entity -> em.persist(entity));
	}

}
