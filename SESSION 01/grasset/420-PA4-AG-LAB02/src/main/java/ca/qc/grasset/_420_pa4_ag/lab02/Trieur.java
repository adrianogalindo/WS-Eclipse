package ca.qc.grasset._420_pa4_ag.lab02;

import java.util.Arrays;

public final class Trieur {
	
	public Trieur() {
		
		super();
	}
	
	public int[] trier(
		final int[] tableauOriginal_) {
		
		int[] tableau = Arrays.copyOf(tableauOriginal_,  tableauOriginal_.length);
		
		int cycle = 0;
		System.out.println("Cycle #" + cycle++ + " : " + Arrays.toString(tableau));
		
		for (int indexExterne = tableau.length - 1; indexExterne >= 0; indexExterne--) {
			
			for (int indexInterne = 1; indexInterne <= indexExterne; indexInterne++) {
				
				if (tableau[indexInterne - 1] > tableau[indexInterne]) {
					
					int element = tableau[indexInterne - 1];
					
					tableau[indexInterne - 1] = tableau[indexInterne];
					
					tableau[indexInterne] = element;
				}
			}
			
			System.out.println("Cycle #" + cycle++ + " : " + Arrays.toString(tableau));
		}
		
		return tableau;
	}
}
