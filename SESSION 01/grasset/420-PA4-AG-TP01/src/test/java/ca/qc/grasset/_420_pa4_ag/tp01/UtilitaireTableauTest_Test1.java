package ca.qc.grasset._420_pa4_ag.tp01;

import org.junit.Assert;
import org.junit.Test;

public class UtilitaireTableauTest_Test1 {

	@Test
	public void test() {

        final int[] tableu_ = {2, 3, 5};

        final int valeur_ = 2;

        int indicateur = new UtilitaireTableau().chercherDernierePositionValeur(tableu_, valeur_);

        if (indicateur >= 0) {
            System.out.println("La position de " + valeur_ + " est  " + indicateur + " dans le tableau");
        } else {
        	System.out.println("La position de " + valeur_ + " n'est pas trouv� dans le tableau. Retourne " + indicateur);
        }

        Assert.assertTrue(indicateur == 0);
    }

}