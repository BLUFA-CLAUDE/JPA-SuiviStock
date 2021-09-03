package test;

import sn.isi.dao.IProduit;
import sn.isi.dao.ProduitImpl;
import sn.isi.entities.Produit;


public class Test {

	public static void main(String[] args) {
		
		IProduit produitdao = new ProduitImpl();
		
		Produit produit = new Produit();
		produit.setDesignation("Ordinateur");
		produit.setQtStock(12);
		
		int ok = produitdao.add(produit);
		System.out.println(ok);

	}

}
