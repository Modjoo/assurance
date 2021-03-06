package com.es.assurance.model;
// Generated 8 nov. 2015 22:21:35 by Hibernate Tools 4.3.1.Final

/**
 * Couvertures generated by hbm2java
 */
public class Couvertures implements java.io.Serializable {

	private Integer id;
	private Assurances assurances;
	private Frais frais;
	private int couverture;

	public Couvertures() {
	}

	public Couvertures(Assurances assurances, Frais frais, int couverture) {
		this.assurances = assurances;
		this.frais = frais;
		this.couverture = couverture;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Assurances getAssurances() {
		return this.assurances;
	}

	public void setAssurances(Assurances assurances) {
		this.assurances = assurances;
	}

	public Frais getFrais() {
		return this.frais;
	}

	public void setFrais(Frais frais) {
		this.frais = frais;
	}

	public int getCouverture() {
		return this.couverture;
	}

	public void setCouverture(int couverture) {
		this.couverture = couverture;
	}

}
