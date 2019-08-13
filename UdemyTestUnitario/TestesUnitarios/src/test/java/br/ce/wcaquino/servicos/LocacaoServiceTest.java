package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.matchers.MatchersProprios.caiNumaSegunda;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHoje;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHojeComDiferencaDias;
import static br.cewcaquino.builders.FilmeBuilder.umFilme;
import static br.cewcaquino.builders.LocacaoBuilder.umLocacao;
import static br.cewcaquino.builders.UsuarioBuilder.umUsuario;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;
import br.cewcaquino.builders.FilmeBuilder;
import br.cewcaquino.builders.LocacaoBuilder;
import br.cewcaquino.builders.UsuarioBuilder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoServiceTest {
	@InjectMocks @Spy
	private LocacaoService service;
	
	@Mock
	private SPCService spc;
	@Mock
	private LocacaoDAO dao;
	@Mock
	private EmailService email;
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none(); // para terceiro teste
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		//service = PowerMockito.spy(service);
//		service = new LocacaoService();
//		dao = Mockito.mock(LocacaoDAO.class);
//		service.setLocacaoDAO(dao);
//		spc = Mockito.mock(SPCService.class);
//		service.setSPCService(spc);
//		email = Mockito.mock(EmailService.class);
//		service.setEmailService(email);
	}
	
	@Test
	public void t1_deveAlugarFilme() throws Exception {
		//Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(FilmeBuilder.umFilme().modificaValorLocacao(5d).agora());
		
		Mockito.doReturn(DataUtils.obterData(22,  2, 2019)).when(service).obterData();
		
		//Ação
		//Locacao locacao = LocacaoBuilder.umLocacao().agora();

		Locacao locacao = service.alugarFilme(usuario, filmeList);
		

		//Verificação
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		//error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		//error.checkThat(locacao.getDataLocacao(), ehHoje());
		//error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
		//error.checkThat(locacao.getDataRetorno(), ehHojeComDiferencaDias(1));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), DataUtils.obterData(22, 02, 2019)), is(true));

		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterData(23, 02, 2019)), is(true));
		
	}
	
	@Test //(expected=FilmeSemEstoqueException.class) // o teste já espera uma exceção (de erro) METODO ELEGANTE
	public void t2_naoDeveAlugarFilmeSemEstoque() throws  LocadoraException  {
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(FilmeBuilder.umFilme().semEstoque().agora());

		
		try {
			service.alugarFilme(usuario, filmeList);
			Assert.fail();
		} catch (FilmeSemEstoqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
//		//Ação		
//		try {
//			service.alugarFilme(usuario, filmeList);
//
//			Assert.fail();
//		} catch (FilmeSemEstoqueException e) {
//			Assert.assertThat(e.getMessage(), is("Filme Vazio"));
//		}
	}
	
	@Test //Método robusto
	public void t3_naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		
		//cenario
		List<Filme> filmeList = Arrays.asList(umFilme().agora());
		
		//Ação
		try {
			service.alugarFilme(null, filmeList);
			Assert.fail();
		} catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), is("Usuário Vazio"));
		}
		//System.out.println("Forma Robusta");
	}
	
	
	@Test //Método novo
	public void t4_naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException  {
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();

		//exception.expect(LocadoraException.class);
		//exception.expectMessage("Filme vazio");
		
		//Ação
		//service.alugarFilme(usuario, null);
		
		
		//veriicacao
		try {
			service.alugarFilme(usuario, null);
			Assert.fail();
		} catch (LocadoraException e) {
			// TODO Auto-generated catch block
			error.checkThat(e.getMessage(), is("Filme vazio"));
		}
		
		
		//System.out.println("Forma nova");

	}
	
	@Test
	public void t5_devePagar75pctNoFilme3() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(umFilme().agora(),
				umFilme().agora(),
				umFilme().agora());

		//acao
		Locacao resultado = service.alugarFilme(usuario, filmeList);
		
		//verificacao 4+4+3 
		Assert.assertThat(resultado.getValor(), is(11.0));
	}
	
	@Test
	public void t6_devePagar50pctNoFilme4() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(umFilme().agora(),
				umFilme().agora(),
				umFilme().agora(),
				umFilme().agora());

		//acao
		Locacao resultado = service.alugarFilme(usuario, filmeList);
		
		//verificacao 4+4+3+2
		Assert.assertThat(resultado.getValor(), is(13.0));
	}
	
	@Test
	public void t7_devePagar25pctNoFilme5() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(umFilme().agora(),
				umFilme().agora(),
				umFilme().agora(),
				umFilme().agora(),
				umFilme().agora());

		//acao
		Locacao resultado = service.alugarFilme(usuario, filmeList);
		
		//verificacao 4+4+3+2+1
		Assert.assertThat(resultado.getValor(), is(14.0));
	}
	
	@Test
	public void t8_devePagar100pctNoFilme6() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(umFilme().agora(),
				umFilme().agora(),
				umFilme().agora(),
				umFilme().agora(),
				umFilme().agora(),
				umFilme().agora());

		//acao
		Locacao resultado = service.alugarFilme(usuario, filmeList);
		
		//verificacao 4+4+3+2+1+0
		Assert.assertThat(resultado.getValor(), is(14.0));
	}
	
	@Test
	public void t9_DeveDevolverNaSegundaAoAlugarNoSabado() throws Exception {
		//Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(umFilme().agora());
		//PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(23, 02, 2019));
		
		Mockito.doReturn(DataUtils.obterData(23,  2, 2019)).when(service).obterData();

		//acao
		Locacao resultado = service.alugarFilme(usuario, filmeList);
		
		//verificação

		//assertThat(resultado.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
		//assertThat(resultado.getDataRetorno(), caiEm(Calendar.SUNDAY));
		assertThat(resultado.getDataRetorno(), caiNumaSegunda());

		
	}
	
	@Test
	public void t10_naoDeveAlugarFilmeParaNegativadoSPC() throws Exception {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		//Usuario usuario2 = UsuarioBuilder.umUsuario().comNome("Usuario 2").agora();
		List<Filme> filmeList = Arrays.asList(umFilme().agora());
		
		Mockito.when(spc.possuiNegativacao(Mockito.any(Usuario.class))).thenReturn(true);
		
		//acao
		try {
			service.alugarFilme(usuario, filmeList);
			Assert.fail();
		//verificacao	
		} catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), is("Usuário negativado pelo SPC"));
		}
		

		Mockito.verify(spc).possuiNegativacao(usuario);
	}
	
	@Test
	public void t11_DeveEnviarEmailsPAraLocacoesdAtrasadas() {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Usuario usuario2 = UsuarioBuilder.umUsuario().comNome("Usuario em dia").agora();
		Usuario usuario3 = UsuarioBuilder.umUsuario().comNome("Usuario atrasado").agora();
		List<Locacao> listLocacao = Arrays.asList(
				LocacaoBuilder.umLocacao().atrasado().comUsuario(usuario).agora(),
				LocacaoBuilder.umLocacao().comUsuario(usuario2).agora(),
				LocacaoBuilder.umLocacao().atrasado().comUsuario(usuario3).agora(),
				LocacaoBuilder.umLocacao().atrasado().comUsuario(usuario3).agora());
				
		Mockito.when(dao.obterLocacoesPendentes()).thenReturn(listLocacao);
		
		
		//acao
		service.notificarAtrasos();
		
		//verificacao
		Mockito.verify(email, Mockito.times(3)).notificarAtraso(Mockito.any(Usuario.class)); //não tem distinção de usuário
		Mockito.verify(email).notificarAtraso(usuario);
	    Mockito.verify(email, Mockito.atLeastOnce()).notificarAtraso(usuario3);
		Mockito.verify(email, Mockito.never()).notificarAtraso(usuario2);
		Mockito.verifyNoMoreInteractions(email);
		//Mockito.verifyZeroInteractions(spc);   Seria desnecessário, pois não tem iteração com notificação de e-mail.
		
	}
	
	@Test
	public void t12_deveTratarErroSPC() throws Exception {
		//cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> listFilme = Arrays.asList(umFilme().agora());
		
		when(spc.possuiNegativacao(usuario)).thenThrow(new Exception("Falha catastrófica"));
		
		//verificação
		exception.expect(LocadoraException.class);
		exception.expectMessage("Problemas com o SPC, tente novamente");
		
		
		//ação
		service.alugarFilme(usuario, listFilme);
	}
	
	@Test
	public void t13_deveProrrogarUmaLocacao() {
		//cenario
		Locacao locacao = umLocacao().agora();
		
		//acao
		service.prorrogarLocacao(locacao, 3);
		
		//verificacao
		ArgumentCaptor<Locacao> argCapt = ArgumentCaptor.forClass(Locacao.class); 
		Mockito.verify(dao).salvar(argCapt.capture());
		Locacao locacaoRetornada = argCapt.getValue();
		error.checkThat(locacaoRetornada.getValor(), is(12.0)); //3 * 4
		error.checkThat(locacaoRetornada.getDataLocacao(), is(ehHoje()));
		error.checkThat(locacaoRetornada.getDataRetorno(), is(ehHojeComDiferencaDias(3)));

				
	}
	
	
	@Test
	public void t14_deveCalcularValorLocacao() throws Exception {
		//cenario
		List<Filme> listFilme = Arrays.asList(umFilme().agora());

		//acao
		
		Class<LocacaoService> clazz = LocacaoService.class;
		java.lang.reflect.Method metodo = clazz.getDeclaredMethod("calcularValorLocacao", List.class);
		metodo.setAccessible(true);
		Double valor = (Double) metodo.invoke(service, listFilme);
		
			
		//verificacao
		Assert.assertThat(valor, is(4.0));
	}

}


//@Test
//public void teste() throws Exception {
//	//cenario
//	Usuario usuario = new Usuario("Usuário 1");
//	List<Filme> filmeList = Arrays.asList(new Filme("filme 1", 2, 5.0));
//	
//	
//	//Ação
//	Locacao locacao = service.alugarFilme(usuario, filmeList);
//	
//	//Verificação
//	Assert.assertEquals(5.0,locacao.getValor(), 0.1);
//	assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//	assertTrue(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
//
//	assertThat(locacao.getValor(), is(equalTo(5.0)));
//	assertThat(locacao.getValor(), is(not(6.0)));
//	assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//	assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
//
//	error.checkThat(locacao.getValor(), is(equalTo(5.0)));
//	error.checkThat(locacao.getValor(), is(not(6.0)));
//	error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//	error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
//	
//	
//	
//}




//@Test //obs. se não lançar umaexceção está com erro, mesmo que o teste passe. Forma robusta
//public void testLocacao_FilmeSemEstoque2() {
//
//	//cenario
//	LocacaoService service = new LocacaoService();
//	Usuario usuario = new Usuario("Usuário 1");
//	Filme filme = new Filme("filme 1", 0, 5.0); // Filme filme = new Filme("filme 1", 2, 5.0);
//		
//	
//	//Ação
//	try {
//		service.alugarFilme(usuario, filme);
//		Assert.fail("Deveria ter lançado uma exeção");
//	} catch (Exception e) {
//		assertThat(e.getMessage(), is("Filme sem estoque"));
//	}
//	
//	
//}


//@Test FORMA NOVA
//public void testLocacao_FilmeSemEstoque3() throws Exception {
//	
//	//cenario
//	LocacaoService service = new LocacaoService();
//	Usuario usuario = new Usuario("Usuário 1");
//	Filme filme = new Filme("filme 1", 0, 5.0);
//		
//	
//	exception.expect(Exception.class);
//	exception.expectMessage("Filme sem estoque");
//	
//	//Ação
//	service.alugarFilme(usuario, filme);
//
//	
//	
//}