package sn.isi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable {
	
	@Id
	private String ref;
	@Column(length=150)
	private String designation;
	@Column
	private double qtStock;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User id = new User();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Categorie categorie = new Categorie();
	
	public Produit() {
		super();
	}

	public Produit(String ref, String designation, double qtStock, User id) {
		super();
		this.ref = ref;
		this.designation = designation;
		this.qtStock = qtStock;
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getQtStock() {
		return qtStock;
	}

	public void setQtStock(double qtStock) {
		this.qtStock = qtStock;
	}


	public User getId() {
		return id;
	}

	public void setId(User idUser) {
		this.id = idUser;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	

}
