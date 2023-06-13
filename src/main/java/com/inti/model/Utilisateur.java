package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Classe utilisateur...
 * 
 * Mon commentaire : HA
 * Commentaire
 * 
 * @author Me
 *
 */
@Entity
@Table
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String mdp;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUD")
	private UtilisateurDetails utilisateurDetails;
	
	// Ajout de commentaire pour github : HA
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Commande> listeCommandes;
	
	@ManyToMany
	@JoinTable(name = "utilisateur_role",
			joinColumns = @JoinColumn(name = "idUtilisateur"),
			inverseJoinColumns = @JoinColumn(name = "idRole"))
	private List<Role> listeRoles;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public Utilisateur(int id, String login, String mdp) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	// Ajout de commentaire pour github : HA
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public UtilisateurDetails getUtilisateurDetails() {
		return utilisateurDetails;
	}

	public void setUtilisateurDetails(UtilisateurDetails utilisateurDetails) {
		this.utilisateurDetails = utilisateurDetails;
	}

	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	public List<Role> getListeRoles() {
		return listeRoles;
	}

	public void setListeRoles(List<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", mdp=" + mdp + "]";
	}
	
	/*
	 * fin du fichier : HA !
	 */
	
}
