package fr.benjixxx.vinyl.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import fr.benjixxx.vinyl.bean.Utilisateur;


public class UtilisateurDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Utilisateur> findAll() {
		return (List<Utilisateur>) hibernateTemplate.find("FROM Utilisateur");
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Utilisateur> findAll(int start, int maxElts) {
		return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("FROM Utilisateur").setFirstResult(start)
				.setMaxResults(maxElts).list();
	}
	@Transactional(readOnly = true)
	public Utilisateur findById(long id) {
		return hibernateTemplate.get(Utilisateur.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Utilisateur findByEmail(String email) {
		List<Utilisateur> users = (List<Utilisateur>) hibernateTemplate.find("FROM Utilisateur u WHERE u.email= ?", email);
		if (users != null && users.size() > 0)
			return users.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Utilisateur> findAllByPseudo(String name) {
		List<Utilisateur> users = (List<Utilisateur>) hibernateTemplate.find("FROM Utilisateur u WHERE u.pseudo like ? ", name + "%");
		System.out.println("users size = " + users.size());
		return users;
	}
	
	@Transactional
	public void save(Utilisateur u) throws Exception {
		hibernateTemplate.save(u);
	}

	@Transactional
	public void update(Utilisateur u) {
		hibernateTemplate.saveOrUpdate(u);
	}

	@Transactional(readOnly = true)
	public long nbUsers() {
		return (Long) hibernateTemplate.find("SELECT COUNT(c.id) FROM Utilisateur c").get(0);
	}

}
