package ca.qc.grasset._420_pa4_ag.tp01;

import org.junit.Assert;
import org.junit.Test;

public class UtilitaireTableauTest_Test4 {

	@Test
	public void test() {

        final int[] x = { -4, 2, 0, 2 };


        int indicateur = new UtilitaireTableau().compterEntierPositif(x);

        if (indicateur == 2) {
            System.out.println("Il y a " + indicateur + " entiers positifs");

            Assert.assertTrue(indicateur == 2);
        } else {
        	System.out.println("Pas de nombre positif");
        }

    }

}