package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.User;

public class UserImpl implements IUser {

	private EntityManager em;
	
	public UserImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuiviStockJPA");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> lister() {
		try {
			return em.createQuery("SELECT u From User u").getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(User user) {
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(User.class, id));
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public User get(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User logon(String email, String password) {
		try {
			return (User)em.createQuery("SELECT u FROM User u WHERE u.email = :em AND u.password = :pass")
					.setParameter("em", email)
					.setParameter("pass", password)
					.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	
		
}
