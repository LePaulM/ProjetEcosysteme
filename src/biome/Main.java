package biome;

import java.util.Arrays;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		//ca laisse, regarde plus bas
		/*
		Grille gr=new Savane(30);
		gr.creationBuisson(1);
		gr.creationArbre(1);
		gr.creationSable();
		gr.afficher();*/
		/*
		int[] coord = new int[2];
		coord[0]=0;
		coord[1]=2;
		Buisson buissone = new Buisson(coord);
		gr.getGrille().get(0).set(2,buissone);
		gr.afficher();*/

		/*
		gr.creationMontagne();
		gr.creationNeige(160);
		gr.creationArbre(30);
		gr.creationBuisson(70);
		gr.creationSable();
		gr.creationEau();
		//gr.afficher();

		Siberie siberie = new Siberie(60);
		siberie.creationNeige(500);
		//siberie.creationEau();	
		siberie.afficher();

		Savane sav = new Savane(60);
		sav.creationArbre(30);
		sav.creationBuisson(70);
		sav.creationSable();
		sav.creationEau();
		sav.afficher();

		Steppe steppe = new Steppe(60);
		steppe.creationEau();	
		steppe.afficher();
		 */



		// c'est ca que tu peut ''activer'' pour afficher les grilles, n'en affiche en qu'une a la fois /!\,

		MassifMontagneux massif = new MassifMontagneux(70);
		massif.creationGrille();

		//Savane sav=new Savane(60);
		//sav.creationGrille();

		//Syberie sib = new Syberie(30);
		//sib.creationGrille();

		//Jungle jun = new Jungle(60);
		//jun.creationGrille();

		//Steppe steppe = new Steppe (60);
		//steppe.creationGrille();
		/*
		int[] tab = new int[2];
		tab[0]=500;
		tab[1]=200;
		Herbe herbe = new Herbe(tab);
		System.out.println(herbe.getEstVide());
		 */
	}
}
