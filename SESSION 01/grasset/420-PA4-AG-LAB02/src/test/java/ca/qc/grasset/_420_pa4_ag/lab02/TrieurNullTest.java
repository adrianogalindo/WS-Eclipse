package ca.qc.grasset._420_pa4_ag.lab02;

import org.junit.Test;

public class TrieurNullTest {
	
	public TrieurNullTest() {
		
		super();
	}

	@Test (expected = NullPointerException.class)
	public void test() {
		
		Trieur trieur = new Trieur();
		trieur.trier(null);
	}

}
