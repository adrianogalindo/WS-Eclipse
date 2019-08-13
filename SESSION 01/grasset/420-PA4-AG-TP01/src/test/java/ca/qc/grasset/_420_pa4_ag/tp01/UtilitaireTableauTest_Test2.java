package ca.qc.grasset._420_pa4_ag.tp01;

import org.junit.Assert;
import org.junit.Test;

public class UtilitaireTableauTest_Test2 {

	@Test
	public void test() {

        final int[] x = { 0, 1, 0 };


        int indicateur = new UtilitaireTableau().chercherDernierePositionZero(x);

        if (indicateur == 2) {
            System.out.println("La dernier position de 0 est " + indicateur);
        }
        else {
        	System.out.println(" 0 n'est pas trouv� dans le tableau. Retourne " + indicateur);
        }
        Assert.assertTrue(indicateur == 2);
    }

}

