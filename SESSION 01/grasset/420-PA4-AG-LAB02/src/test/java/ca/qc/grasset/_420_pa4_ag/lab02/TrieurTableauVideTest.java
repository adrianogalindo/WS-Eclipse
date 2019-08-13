package ca.qc.grasset._420_pa4_ag.lab02;

import org.junit.Assert;
import org.junit.Test;

public class TrieurTableauVideTest {

	public TrieurTableauVideTest() {

		super();
	}

	@Test
	public void test() {

		final int[] tableau = new int[] {};

		Trieur trieur = new Trieur();
		int[] tableauTrierActuel = trieur.trier(tableau);

		Assert.assertArrayEquals(tableau, tableauTrierActuel);
	}

}
