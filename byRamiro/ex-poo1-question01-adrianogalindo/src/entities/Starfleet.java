package entities;

import java.util.ArrayList;
import java.util.List;

import exceptions.NullListException;
import exceptions.WrongTypeException;

public class Starfleet {
	
	private static List<Capitaine> listCapitaine = new ArrayList<>();
	private static List<Batiment> listBatiment = new ArrayList<>();
	
	
	public Starfleet() {
	}
	
	public Starfleet(List<Capitaine> listCapitaine, List<Batiment> listBatiment) throws NullListException {
		super();
		if (listCapitaine == null || listBatiment == null) {
			throw new NullListException();
		}
		Starfleet.listCapitaine = listCapitaine;
		Starfleet.listBatiment = listBatiment;

	}

	static public class Capitaine{
		public String nom;
		public Batiment batiment;

		public Capitaine(String nom) {
			super();
			this.nom = nom;
			listCapitaine.add(this);
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public Batiment getBatiment() {
			return batiment;
		}

		public void setBatiment(Batiment batiment) {
			this.batiment = batiment;
		}
		
	}
	
	static public class Batiment{
		public String nom;
		public String type;
		public Capitaine capitaine;

		public Batiment(String nom, String type) throws WrongTypeException {
			super();
			this.nom = nom;
			if (type != "base stellaire" || type != "vaisseau") {
				throw new WrongTypeException();
			}
			this.type = type;
			listBatiment.add(this);
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Capitaine getCapitaine() {
			return capitaine;
		}

		public void setCapitaine(Capitaine capitaine) {
			this.capitaine = capitaine;
		}
		
		
	}
	
	public static Batiment assignerCaptaine(Capitaine capitaine_) throws WrongTypeException {
		Batiment batiment = new Batiment("Voyageur","vaisseau");
		batiment.capitaine = capitaine_;
		return batiment;
	}
	
	public static void retirerCapitaine(Capitaine capitaine) {
		for (Starfleet.Capitaine capitaines : listCapitaine) {
			if (capitaines == capitaine) {
				Starfleet.listCapitaine.remove(capitaines);
			}
		}
	}
	
	
}

