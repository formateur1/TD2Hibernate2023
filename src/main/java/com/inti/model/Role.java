package com.inti.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany
	@JoinTable(name = "utilisateur_role",
		joinColumns = @JoinColumn(name = "idRole"),
		inverseJoinColumns = @JoinColumn(name = "idUtilisateur"))
	List<Utilisateur> listeUtilisateurs;
	
	public Role() {
		super();
	}
	
	public Role(String nom) {
		super();
		this.nom = nom;
	}
	
	public Role(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	

}
