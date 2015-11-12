package com.es.assurance;

import java.util.List;
import java.util.Scanner;

import com.es.assurance.model.Clients;

public class AffichageGUIManager {
	
	public static int menuPrincipal(){
	    // Display menu graphics
	    System.out.println("=======================================================");
	    System.out.println("|                 MENU PRINCIPALE                     |");
	    System.out.println("=======================================================");
	    System.out.println("| Options:                 		                      |");
	    System.out.println("|        1. Lister tous les clients                   |");
	    System.out.println("|        2. Ajouter un client                         |");
	    System.out.println("|        3. Selectionner un client pour plus d'option |");
	    System.out.println("|        4. Exit                                      |");
	    System.out.println("=======================================================");
	    String value = question(" Select option: ");
	    return testIntValue(value);
	}
	
	public static int menuClient(){
	    // Display menu graphics
	    System.out.println("=======================================================");
	    System.out.println("|                 MENU Client                         |");
	    System.out.println("=======================================================");
	    System.out.println("| Options:                 		                      |");
	    System.out.println("|        1. Lister les membres de la meme famille     |");
	    System.out.println("|        2. Est éligible au rabais de 50%             |");
	    System.out.println("|        3. Lister toutes les polices d'assurance     |");
	    System.out.println("|        4. Exit                                      |");
	    System.out.println("=======================================================");
	    String value = question(" Select option: ");
	    return testIntValue(value);
	}
	
	
	public static Clients selectionClients(List<Clients> clients){
		Clients.afficher(clients);
		String rep = question("Veuillez insérer l'id du client choisi");
		int id = testIntValue(rep);
		if(id > 0){
			for (Clients clients2 : clients) {
				if(clients2.getId() == id) return clients2;
			}
		}		
		return null;		
	}
	
	
	/**
	 * Poser une question
	 * @param question
	 * @return
	 */
	public static String question(String question) {
		Scanner reader = new Scanner(System.in);
		System.out.println(question);
		return reader.next();
	}
	
	private static int testIntValue(String str){
		int i = -1;
		try{
	    	i = Integer.valueOf(str);
	    }catch (Exception e){
	    	// Void ... bad ...
	    }
		return i;
	}
}
