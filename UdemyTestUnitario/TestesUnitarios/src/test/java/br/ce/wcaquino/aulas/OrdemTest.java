package br.ce.wcaquino.aulas;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Em ordem alfabetica
public class OrdemTest {
	
	public static int contador = 0;
	
	@Test
	public void inicia() {
		contador = 1;
		
	}
	
	
	@Test
	public void verifica() { //erro pois executou antes do inicia
		Assert.assertEquals(1, contador);
		
	}

	
	
	
}
