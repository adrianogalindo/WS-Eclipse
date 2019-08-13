package pack;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cours {

	private int idC;
	private String titre;
	private int unite;
	private List<Eleve> eleves = new ArrayList<Eleve>();

	public Cours(int idC, String titre, int unite) {
		this.idC = idC;
		this.titre = titre;
		this.unite = unite;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void inscrire(Eleve eleves) {
		this.eleves.add(eleves);
		eleves.addMesInscriptions(new Inscription(Date.from(Instant.now()), this));
	}

	public int getIdC() {
		return idC;
	}

	public int getUnite() {
		return unite;
	}

}
