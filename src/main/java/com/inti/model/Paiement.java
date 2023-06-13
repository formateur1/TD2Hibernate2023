package com.inti.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
//@Table
//@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
//@DiscriminatorColumn( name="discriminator", discriminatorType = DiscriminatorType.INTEGER )
//@DiscriminatorValue("0")
//@Entity
//@Table
//@Inheritance( strategy = InheritanceType.JOINED )
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class Paiement {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	protected int id;
	protected double montant;
	protected LocalDate dateP;
	
	public Paiement() {
		super();
	}

	public Paiement(double montant, LocalDate dateP) {
		super();
		this.montant = montant;
		this.dateP = dateP;
	}

	public Paiement(int id, double montant, LocalDate dateP) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateP = dateP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalDate getDateP() {
		return dateP;
	}

	public void setDateP(LocalDate dateP) {
		this.dateP = dateP;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", montant=" + montant + ", dateP=" + dateP + "]";
	}
	
	

}
