package br.cardapio.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.cardapio.dao.ProdutoDao;
import br.cardapio.model.Produto;

public class ProdutoControllerTest {

	private static final int ID_DE_PRODUTO_VALIDO = 99;
	@Mock
	ProdutoDao dao;
	private ProdutoController controller;
	private MockResult result;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.result = new MockResult();
		this.controller = new ProdutoController(result, dao);
	}

	@Test
	public void deveAdicionar_comSucesso_umNovoProduto_preenchidoCorretamente() {
		this.controller.salvar(new Produto());
		assertTrue("Deveria ter adicionado com sucesso!", this.result
				.included().containsKey("sucesso"));
	}

	@Test
	public void deveDeletar_comSucesso_umProduto_UsandoOIdDoProduto(){
		try {
		this.controller.delete(ID_DE_PRODUTO_VALIDO);
		assertTrue("Deveria ter removido o produto com sucesso!", this.result
				.included().containsKey("sucesso"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void deveListar_comSucesso_todosOsProdutosExistente(){
		controller.listar();
		assertTrue(result.included().containsKey("produtos"));
	}
}
