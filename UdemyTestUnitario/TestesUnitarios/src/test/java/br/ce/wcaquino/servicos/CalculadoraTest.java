package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@Before
	public void setup() {
		calc = new Calculadora();
	}
	
	@Test
	public void deve1SomarDoisValores() {
		//cenario
		int a = 5;
		int b = 2;

		//ação
		int resultado = calc.somar(a,b);

		//Verificacão
		Assert.assertEquals(7, resultado);
	}
	
	@Test
	public void deve2SubtrairDoisValores() {
		//cenario
		int a = 5;
		int b = 2;

		//ação
		int resultado = calc.subtrair(a,b);

		//Verificacão
		Assert.assertEquals(3, resultado);
	}
	
	@Test
	public void deve3DividirDoisValores() throws NaoPodeDividirPorZeroException {
		//cenario
		int a = 6;
		int b = 2;

		//ação
		int resultado = calc.dividir(a,b);

		//Verificacão
		Assert.assertEquals(3, resultado);
	}
	
	@Test (expected=NaoPodeDividirPorZeroException.class)
	public void deve4LancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		int a = 10;
		int b = 0;
		
		calc.dividir(a, b);
			
	}
	
	@Test
	public void deveDividir() {
		String a = "6";
		String b = "3";
		
		int resultado =calc.dividir(a, b);
		
		Assert.assertEquals(2,resultado);
	}
	

}
