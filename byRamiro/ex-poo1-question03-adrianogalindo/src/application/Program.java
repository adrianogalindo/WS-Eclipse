package application;

import entities.BasicDev;
import entities.DevCPP;
import entities.DevCSharp;
import entities.DevJava;
import entities.DevPython;
import entities.DevWeb;
import entities.Developpeur;

public class Program {
	public static void main(String[] args) {
		Developpeur d = new BasicDev("Adriano");
		Developpeur d2 = new DevJava(new DevCPP(new DevCSharp(new DevPython(new DevWeb(d)))));
		System.out.println(d2.getCompetence());
	}
}
