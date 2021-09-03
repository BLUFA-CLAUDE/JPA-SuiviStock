package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Produit;

public class ProduitImpl implements IProduit {

	private EntityManager em;
	
	public ProduitImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuiviStockJPA");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Produit prod) {
		try {
			em.getTransaction().begin();
			em.persist(prod);
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Produit> lister() {
		try {
			return em.createQuery("SELECT p From Produit p").getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Produit prod) {
		try {
			em.getTransaction().begin();
			em.merge(prod);
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
			em.remove(em.find(Produit.class, ref));
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Produit get(String ref) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, ref);
	}

}
