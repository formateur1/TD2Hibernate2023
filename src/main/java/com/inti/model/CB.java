package com.inti.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * commentaire pour test
 */
/**
 * Classe pour le paiement en CB
 * 
 * @author Me
 *
 */

/**
 * Test Merge2
 * @author shiki
 *
 */
//@Entity
//@Table
//@PrimaryKeyJoinColumn( name = "idPaiement" )
@Entity
@Table
public class CB extends Paiement {
	/**
	 * Commentaire de Daenrya blablabla
	 */	
	private long numeroCB;
	private LocalDate dateE;
	
	public CB() {
		super();
	}

	public CB(double montant, LocalDate dateP, long numero, LocalDate dateE) {
		super(montant, dateP);
		this.numeroCB = numero;
		this.dateE = dateE;
	}

	public CB(int id, double montant, LocalDate dateP, long numero, LocalDate dateE) {
		super(id, montant, dateP);
		this.numeroCB = numero;
		this.dateE = dateE;
	}

	public long getNumeroCB() {
		return numeroCB;
	}

	public void setNumeroCB(long numeroCB) {
		this.numeroCB = numeroCB;
	}

	public LocalDate getDateE() {
		return dateE;
	}

	public void setDateE(LocalDate dateE) {
		this.dateE = dateE;
	}

	@Override
	public String toString() {
		return "CB [numero=" + numeroCB + ", dateE=" + dateE + ", id=" + id + ", montant=" + montant + ", dateP=" + dateP
				+ "]";
	}
	
	

}
