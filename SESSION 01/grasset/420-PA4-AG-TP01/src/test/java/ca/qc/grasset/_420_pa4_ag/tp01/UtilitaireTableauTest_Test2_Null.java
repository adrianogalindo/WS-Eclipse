package ca.qc.grasset._420_pa4_ag.tp01;

import org.junit.Test;

public class UtilitaireTableauTest_Test2_Null {

	@Test
	(expected = NullPointerException.class)
	public void test() {

		try {
			new UtilitaireTableau().chercherDernierePositionZero(null);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
	}

}
