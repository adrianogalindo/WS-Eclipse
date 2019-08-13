package main;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pack.Cours;
import pack.Eleve;
import pack.Inscription;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Fazer um programa para fazer a inscricao de um aluno em um ou mais cursos
		// Fazer um programa para fazer a remocao de um aluno em um ou mais cursos

		List<Eleve> catalogoEleves = new ArrayList<Eleve>();
		List<Cours> catalogoCours = new ArrayList<Cours>();

		catalogoEleves.add(new Eleve(1, "Coutinho", "Antonio"));
		catalogoEleves.add(new Eleve(2, "Costa", "Gabriel"));
		catalogoEleves.add(new Eleve(3, "Kieling", "Thiago"));
		catalogoEleves.add(new Eleve(4, "Holanda", "Mirela"));
		catalogoEleves.add(new Eleve(5, "Urias", "Ana"));

		catalogoCours.add(new Cours(1, "POO", 5));
		catalogoCours.add(new Cours(2, "PBD", 3));
		catalogoCours.add(new Cours(3, "Mat", 5));
		catalogoCours.add(new Cours(4, "CQ", 8));
		catalogoCours.add(new Cours(5, "SU", 10));
		catalogoCours.add(new Cours(6, "LQ", 10));

		catalogoCours.get(0).inscrire(catalogoEleves.get(0));
		catalogoCours.get(1).inscrire(catalogoEleves.get(0));

		catalogoCours.get(0).inscrire(catalogoEleves.get(1));

		System.out.println("Eleves: " + catalogoEleves.get(0).getPrenom() + " " + catalogoEleves.get(0).getNom()
				+ " - Inscrire aux cours:");

		for (Inscription i : catalogoEleves.get(0).getMesInscriptions()) {
			System.out.println(i.getTitreDuCours());
		}

		System.out.println();

		System.out.println("Cours: " + catalogoCours.get(0).getTitre() + " possede les eleves: ");

		for (Eleve e : catalogoCours.get(0).getEleves()) {
			System.out.println(e.getPrenom() + " " + e.getNom());
		}

	}

}