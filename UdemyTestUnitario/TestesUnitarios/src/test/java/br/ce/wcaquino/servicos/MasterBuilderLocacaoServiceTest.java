package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.matchers.MatchersProprios.caiNumaSegunda;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHoje;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHojeComDiferencaDias;
import static br.cewcaquino.builders.FilmeBuilder.umFilme;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
import buildermaster.BuilderMaster;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MasterBuilderLocacaoServiceTest {
	@InjectMocks
	private LocacaoService service;
	@Mock
	private SPCService spc;
	@Mock
	private LocacaoDAO dao;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none(); // para terceiro teste
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
//		service = new LocacaoService();
//		dao = Mockito.mock(LocacaoDAO.class);
//		service.setLocacaoDAO(dao);
//		spc = Mockito.mock(SPCService.class);
//		service.setSPCService(spc);
		
	}
	
	@Test
	public void t1_deveAlugarFilme() throws Exception {
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		//cenario
		//Usuario usuario = UsuarioBuilder.umUsuario().agora();
		//List<Filme> filmeList = Arrays.asList(FilmeBuilder.umFilme().modificaValorLocacao(5d).agora());
				
		//Ação
		//Locacao locacao = service.alugarFilme(usuario, filmeList);
		Locacao locacao = LocacaoBuilder.umLocacao().agora();
		
		//Verificação
		error.checkThat(locacao.getValor(), is(equalTo(4.0)));
		error.checkThat(locacao.getDataLocacao(), ehHoje());
		error.checkThat(locacao.getDataRetorno(), ehHojeComDiferencaDias(1));
		
	}
	
	@Test (expected=FilmeSemEstoqueException.class) // o teste já espera uma exceção (de erro) METODO ELEGANTE
	public void t2_naoDeveAlugarFilmeSemEstoque() throws FilmeSemEstoqueException, LocadoraException {
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(FilmeBuilder.umFilmeSemEstoque().agora());

		//Ação
		service.alugarFilme(usuario, filmeList);
		
		System.out.println("Forma Elegante");
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

	}
	
	
	@Test //Método novo
	public void t4_naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();

		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		//Ação
		service.alugarFilme(usuario, null);
	}
	
	
	@Test
	public void t5_DeveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmeList = Arrays.asList(umFilme().agora());
		
		//acao
		Locacao resultado = service.alugarFilme(usuario, filmeList);
		
		//verificação

		//assertThat(resultado.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
		//assertThat(resultado.getDataRetorno(), caiEm(Calendar.SUNDAY));
		assertThat(resultado.getDataRetorno(), caiNumaSegunda());
		
	}
	
	public static void main(String[] args) {
		new BuilderMaster().gerarCodigoClasse(Locacao.class);
	}

}
