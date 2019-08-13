package entities;

public class DevCSharp implements Developpeur{
	private Developpeur dev;
	private String competence;
	
	
	public DevCSharp(Developpeur dev) {
		this.dev=dev;
		this.competence = "C#";
	}

	public String getNom() {
		return dev.getNom();
	}
	
	public String getCompetence() {
		return this.competence + ", "+ dev.getCompetence();
	}
}
