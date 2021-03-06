package com.es.assurance.model;
// Generated 8 nov. 2015 22:21:35 by Hibernate Tools 4.3.1.Final

/**
 * MedicamentListeMedicament generated by hbm2java
 */
public class MedicamentListeMedicament implements java.io.Serializable {

	private Integer id;
	private ListesMedicament listesMedicament;
	private Medicaments medicaments;
	private int pourcentageRemboursement;

	public MedicamentListeMedicament() {
	}

	public MedicamentListeMedicament(ListesMedicament listesMedicament, Medicaments medicaments,
			int pourcentageRemboursement) {
		this.listesMedicament = listesMedicament;
		this.medicaments = medicaments;
		this.pourcentageRemboursement = pourcentageRemboursement;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ListesMedicament getListesMedicament() {
		return this.listesMedicament;
	}

	public void setListesMedicament(ListesMedicament listesMedicament) {
		this.listesMedicament = listesMedicament;
	}

	public Medicaments getMedicaments() {
		return this.medicaments;
	}

	public void setMedicaments(Medicaments medicaments) {
		this.medicaments = medicaments;
	}

	public int getPourcentageRemboursement() {
		return this.pourcentageRemboursement;
	}

	public void setPourcentageRemboursement(int pourcentageRemboursement) {
		this.pourcentageRemboursement = pourcentageRemboursement;
	}

}
