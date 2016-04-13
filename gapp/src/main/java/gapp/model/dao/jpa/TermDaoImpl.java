package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Term;
import gapp.model.dao.TermDao;

@Repository
public class TermDaoImpl implements TermDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Term getTerm(Integer id)
	{
		return entityManager.find(Term.class, id);
	}

	@Override
	public List<Term> getAllTerms()
	{
		return entityManager.createQuery("from Term order by id", Term.class).getResultList();
	}

	@Override
	public List<Term> getActiveTerms()
	{
		return entityManager.createQuery("from Term where deleted = false order by id", Term.class).getResultList();
	}

	@Override
	public List<Term> getDeletedTerms()
	{
		return entityManager.createQuery("from Term where deleted = true order by id", Term.class).getResultList();
	}

	@Override
	@Transactional
	public Term setTerm(Term term)
	{
		return entityManager.merge(term);
	}

}
