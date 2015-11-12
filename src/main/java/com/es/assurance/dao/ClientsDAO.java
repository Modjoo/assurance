package com.es.assurance.dao;

/**
 * Created by Christophe.KALMAN on 06.11.2015.
 */
public interface ClientsDAO {

	public final static String NOMBRE_ENFANT = "SELECT COUNT(`clients`.id) FROM `clients`"
			+ "INNER JOIN `polices_assurance` ON `polices_assurance`.client_id = `clients`.id"
			+ "INNER JOIN `types_personne` ON `types_personne`.id = `polices_assurance`.type_personne_id"
			+ "WHERE `polices_assurance`.annee = 2014" + "AND `polices_assurance`.famille_id = 1"
			+ "AND `types_personne`.type = \"enfant";
	
	public static String LISTER_MEMBRE_FAMILLE = "Select clients.nom, clients.prenom, typesPersonne.type FROM Clients clients"
			+ " JOIN clients.policesAssurances polices_assurance"
			+ " JOIN polices_assurance.familles  familles"
			+ " JOIN polices_assurance.typesPersonne typesPersonne"
			+ " WHERE polices_assurance.annee=:annee" 
			+ " AND familles.id=:familleId"
			+ " GROUP BY clients.id";

}
