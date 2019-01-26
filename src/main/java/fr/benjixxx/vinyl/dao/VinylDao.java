package fr.benjixxx.vinyl.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import fr.benjixxx.vinyl.bean.Vinyl;

public class VinylDao {
   
	private HibernateTemplate hibernateTemplate;
    
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Vinyl> findAll() {
		return (List<Vinyl>) hibernateTemplate.find("FROM Vinyl");
	}
	
	
	
}
