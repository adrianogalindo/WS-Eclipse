package ca.qc.grasset._420_pa4_ag.tp01;

import org.junit.Assert;
import org.junit.Test;

public class UtilitaireTableauTest_Test3_Null {

	@Test
	(expected = NullPointerException.class)
	public void test() {

		try {
			new UtilitaireTableau().compterEntierImpairOuPositif(null);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
	}

}
