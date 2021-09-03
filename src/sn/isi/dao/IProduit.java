package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Produit;

public interface IProduit {

	public int add(Produit prod);
	public List<Produit> lister();
	public int update(Produit prod);
	public int delete(String ref);
	public Produit get(String ref);
}
