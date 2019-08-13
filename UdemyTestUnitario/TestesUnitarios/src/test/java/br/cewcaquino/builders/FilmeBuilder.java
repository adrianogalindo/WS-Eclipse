package br.cewcaquino.builders;

import br.ce.wcaquino.entidades.Filme;

public class FilmeBuilder {
	private Filme filme;
	
	private FilmeBuilder() {
	}	
	
	public static FilmeBuilder umFilme() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setNome("Filme");
		builder.filme.setEstoque(1);
		builder.filme.setPrecoLocacao(4.0);
		return builder;
	}
	
	public static FilmeBuilder umFilmeSemEstoque() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setNome("Filme");
		builder.filme.setEstoque(0);
		builder.filme.setPrecoLocacao(4.0);
		return builder;
	}
	
	public FilmeBuilder semEstoque() {
		filme.setEstoque(0);
		return this;
	}
	
	public FilmeBuilder modificaValorLocacao(Double precoLocacao) {
		filme.setPrecoLocacao(precoLocacao);
		return this;
	}
	
	public Filme agora() {
		return filme;
	}
}

