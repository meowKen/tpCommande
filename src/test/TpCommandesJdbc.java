package test;

import java.sql.*;
import java.util.Scanner;

import metier.*;

public class TpCommandesJdbc {

	public static void main(String[] args) throws SQLException {
		boolean run = true;
		int choixMenu = -1;
		Scanner in = new Scanner(System.in);
		Catalogue cat = new Catalogue();
		Executeur exec = new Executeur();
		
		System.out.println("--------------LOGICIEL DE SAISIE CLIENT/COMMANDE--------------");
		while(run) {
			while(choixMenu < 0 || choixMenu > 3) {
				System.out.println("---------------VEUILLEZ CHOISIR UN MENU---------------");
				System.out.println("0.quitter l'application");
				System.out.println("1.entrez un article dans la base");
				System.out.println("2.afficher le catalogue des articles");
				System.out.println("3.rechercher un article dans le catalogue");
				choixMenu = in.nextInt();
			}
			
			Scanner st = new Scanner(System.in);
			
			switch(choixMenu) {
			case 0 :
				run = false;
				break;
			case 1 : 
				cat.searchAndAdd(exec.addArticleToArticles("tpcomm").getRef());
				System.out.println("retour au menu 1, quitter l'application 0 : ");
				String s1 = st.nextLine();
				if(Integer.parseInt(s1) == 0) {run = false; break;}
				choixMenu = 0;
				break;

			case 2 : 
				System.out.println(cat);
				System.out.println("retour au menu 1, quitter l'application 0 : ");
				String s2 = st.nextLine();
				if(Integer.parseInt(s2) == 0) {run = false; break;}
				choixMenu = 0;
				break;

			case 3 :
				System.out.println(exec.searchArticleByName("tpcomm", cat));
				System.out.println("retour au menu 1, quitter l'application 0 : ");
				String s3 = st.nextLine();
				if(Integer.parseInt(s3) == 0) {run = false; break;}

				choixMenu = 0;
				break;

			default : 
				choixMenu = 0;
			}
			

		}
		System.out.println("FERMETURE DE L'APPLICATION");

	}

}
