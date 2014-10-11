
package br.cardapioinside.controller.api;

import java.util.Collection;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.cardapio.dao.ProdutoDao;
import br.cardapio.model.Produto;

@Controller
@Path("/api/produto")
public class ApiProdutoController {

	private static final int NAO_ENCONTRADO = 404;
	private static final int SUCESSO = 200;
	private static final String XML_FORMAT = "xml";
	private static final String JSON_FORMAT = "json";

	@Inject
	private Result result;
	@Inject
	private ProdutoDao dao;

	@Put("")
	@Consumes({ "application/json", "application/xml" })
	public void adicionar(Produto produto) {
		dao.salvar(produto);
		retornarSucesso();
	}

	@Post("/{id}.{formato}")
	@Consumes({ "application/json", "application/xml" })
	public void editar(int id, String formato, Produto produto) {
		Produto produtoEncontrado = dao.get(id);
		if(produtoEncontrado == null){
			retornaProdutoNaoEncontrado();
		}
			
		dao.salvar(produto);
		buscarPorId(id, formato);
	}

	@Delete("/{id}")
	public void deletar(int id) {
		dao.deletar(id);
		retornarSucesso();
	}
	
	@Get("/lista.{formato}")
	public void buscarTodos(String formato){
		Collection<Produto> produtos = dao.lista();
		switch (formato) {
		case JSON_FORMAT:
			result.use(Results.json()).from(produtos).serialize();
			break;
		case XML_FORMAT:
			result.use(Results.xml()).from(produtos).serialize();
			break;

		default:
			break;
		}
		retornarSucesso();
	}
	
	@Get("/{id}.{formato}")
	public void buscarPorId(int id, String formato) {
		if(dao.get(id) == null){
			retornaProdutoNaoEncontrado();
			return;
		}
		retornProduto(id, formato);
		retornarSucesso();
	}

	private void retornProduto(int id, String formato) {
		switch (formato) {
		case JSON_FORMAT:
			result.use(Results.json()).from(dao.get(id)).serialize();
			break;
		case XML_FORMAT:
			result.use(Results.xml()).from(dao.get(id)).serialize();
			break;

		default:
			break;
		}
	}

	private void retornarSucesso() {
		result.use(Results.http()).setStatusCode(SUCESSO);
	}
	
	private void retornaProdutoNaoEncontrado() {
		result.use(Results.http()).setStatusCode(NAO_ENCONTRADO);
	}
}