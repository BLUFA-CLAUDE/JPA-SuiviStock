package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Categorie;


public class CategorieImpl implements ICategorie {

private EntityManager em;
	
	public CategorieImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuiviStockJPA");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Categorie cat) {
		try {
			em.getTransaction().begin();
			em.persist(cat);
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Categorie> lister() {
		try {
			return em.createQuery("SELECT c From Categorie c").getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Categorie cat) {
		try {
			em.getTransaction().begin();
			em.merge(cat);
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String ref) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Categorie.class, ref));
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Categorie get(String ref) {
		// TODO Auto-generated method stub
		return em.find(Categorie.class, ref);
	}


}
