package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Categorie;



public interface ICategorie {
	
	public int add(Categorie cat);
	public List<Categorie> lister();
	public int update(Categorie cat);
	public int delete(String ref);
	public Categorie get(String ref);
}
