package com.inti.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
//@DiscriminatorValue("1")
//@Entity
//@Table
//@PrimaryKeyJoinColumn( name = "idPaiement" )
@Entity
@Table
public class Paypal extends Paiement {

	private int numero;

	public Paypal() {
		super();
	}

	public Paypal(double montant, LocalDate dateP, int numero) {
		super(montant, dateP);
		this.numero = numero;
	}

	public Paypal(int id, double montant, LocalDate dateP, int numero) {
		super(id, montant, dateP);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Paypal [numero=" + numero + ", id=" + id + ", montant=" + montant + ", dateP=" + dateP + "]";
	}
	
	
}
