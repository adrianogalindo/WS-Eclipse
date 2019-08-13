package ca.qc.grasset._420_pa4_ag.tp01;

import org.junit.Assert;
import org.junit.Test;

public class UtilitaireTableauTest_Test3 {

	@Test
	public void test() {

        final int[] x = { -3, -2, 0, 1, 4 };


        int indicateur = new UtilitaireTableau().compterEntierImpairOuPositif(x);

        if (indicateur == 3) {
            System.out.println("Il y a " + indicateur + " entiers impairs ou positifs");
        } else {
        	System.out.println("Pas de nombre positif ou impair");
        }

        Assert.assertTrue(indicateur == 3);
    }

}
