package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.ce.wcaquino.entidades.Locacao;

public class CalculadoraMockTest {
	
	@Mock
	private Calculadora calcMock;
	@Spy
	private Calculadora calcSpy;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void devoMostrarDiferencaEntreMockESpy() {
		
		Mockito.when(calcMock.somar(1, 2)).thenReturn(5);
		//Mockito.when(calcSpy.somar(1, 2)).thenReturn(5);
		Mockito.doReturn(5).when(calcSpy).somar(1, 2);
		Mockito.doNothing().when(calcSpy).imprime();

		
		System.out.println("Mock: " + calcMock.somar(1,2)); // o MOck trará 0 caso não saiba o que fazer
		System.out.println("Spy: " + calcSpy.somar(1,2)); // o spy trará o resultado real quando não souber op que fazer (Não funciona com interface
		
		System.out.println("Mock");
		calcMock.imprime();
		System.out.println("Spy"); // normalmente implementa o methodo
		calcSpy.imprime();

	}
	
	
	
	@Test
	public void teste() {
		Calculadora calc = Mockito.mock(Calculadora.class);
		
		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class); 
		Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);
		
		Assert.assertEquals(5, calc.somar(1, 123123));
		
		//System.out.println(argCapt.getAllValues());


		
	}
}
