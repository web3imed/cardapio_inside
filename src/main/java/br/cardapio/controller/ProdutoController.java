package br.cardapio.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.cardapio.dao.ProdutoDao;
import br.cardapio.model.Produto;

@Controller
@Path("/produto")
public class ProdutoController {

	@Inject private ProdutoDao dao;
	@Inject private Result result;
	
	public ProdutoController() {
	}

	@Inject
	public ProdutoController(Result result, ProdutoDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Get("")
	public void listar(){
		result.include("produtos",dao.lista());
	}
		
	@Get("/adicionar")
	public void adicionar(){
		result.forwardTo(this).formulario(new Produto());
	}
	
	public void formulario(Produto produto) {
		result.include("produto", produto);
	}

	@Get("/editar/{id}")
	public void edit(int id){
		result.forwardTo(this).formulario(dao.get(id));
	}
	
	@Post("/salvar")
	public void salvar(Produto produto){
		dao.salvar(produto);
		result.include("sucesso", true);
		result.redirectTo(this).listar();
	}
	
	@Get("/deletar/{id}")
	public void delete(int id){
		dao.deletar(id);
		result.include("sucesso", true);
		result.redirectTo(this).listar();}
}
