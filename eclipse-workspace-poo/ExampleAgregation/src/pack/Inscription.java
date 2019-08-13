package pack;

import java.util.Date;

public class Inscription {

	private Date date;
	private Double nf = null;
	private Cours cours;

	Inscription(Date date, Cours cours) {
		this.date = date;
		this.cours = cours;
	}

	public Double getNf() {
		return nf;
	}

	public void setNf(Double nf) {
		this.nf = nf;
	}

	public Date getDate() {
		return date;
	}

	public Cours getCours() {
		return cours;
	}

	public String getTitreDuCours() {
		return cours.getTitre();
	}

}