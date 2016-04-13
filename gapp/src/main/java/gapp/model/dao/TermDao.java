package gapp.model.dao;

import java.util.List;
import gapp.model.Term;

public interface TermDao
{
	Term getTerm(Integer id);
	
	List<Term> getAllTerms();
	
	List<Term> getActiveTerms();
	
	List<Term> getDeletedTerms();
	
	Term setTerm(Term term);
}
