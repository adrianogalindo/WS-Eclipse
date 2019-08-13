package entities;

public class BasicDev implements Developpeur{
	
	private String nom;
	private String competence;
	
	
	public BasicDev(String nom) {
		super();
		this.nom = nom;
		this.competence = "";
	}

	public String getNom() {
		return this.nom;
	}
	
	public String getCompetence() {
		return this.competence;
	}
	
	
}
