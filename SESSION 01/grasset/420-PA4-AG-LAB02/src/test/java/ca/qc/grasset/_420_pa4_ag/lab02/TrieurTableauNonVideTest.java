package ca.qc.grasset._420_pa4_ag.lab02;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TrieurTableauNonVideTest {
	
	public TrieurTableauNonVideTest() {
		
		super();
	}
	@Ignore //ignora esse test entao não chega a 100%
	@Test
	public void test() {
		
		final int[] tableau = new int[] {7, 8, 9, 45, 86, 89, -1, 789546, 45, 856, 15};

		Trieur trieur = new Trieur();
		int[] tableauTrierActuel = trieur.trier(tableau);

		Assert.assertArrayEquals(tableau, tableauTrierActuel);
	}

}
