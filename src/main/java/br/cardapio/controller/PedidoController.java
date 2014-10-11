package br.cardapio.controller;

import javax.inject.Inject;

import br.cardapio.dao.PedidoDao;
import br.cardapio.dao.ProdutoDao;
import br.cardapio.model.Item;
import br.cardapio.model.Pedido;
import br.cardapio.model.Produto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
@Path("/pedido")
public class PedidoController {

	@Inject private PedidoDao pedidoDao;
	@Inject private ProdutoDao produtoDao;
	@Inject private Result result;
	
	@Get("")
	public void novo(){
		result.include("pedido", new Pedido(pedidoDao));
		
		Produto prod = new Produto();
		prod.setId(1);
		prod.setNome("Coca-Cola");
		prod.setValor(3.5);
		produtoDao.salvar(prod);
		
		prod = new Produto();
		prod.setId(2);
		prod.setNome("Pastel de Flango");
		prod.setValor(2.5);
		produtoDao.salvar(prod);
		
		result.include("produtos", produtoDao.lista());
	}
	
	@Post("/add")
	public void add(Produto produto, Pedido pedido, int quantidade){
		Item item = new Item(produtoDao.get(produto.getId()), quantidade);
		pedido.addItem(item);
		pedidoDao.salvar(pedido);
		
		result.forwardTo(this).novo();
	}
	
/*
	@Get("/adicionar")
	public void adicionar(){
		Pedido pedido = new Pedido(prodDao.lista());
		result.forwardTo(this).formulario(pedido);
	}
	
	public void formulario(Pedido pedido) {
		result.include("pedido", pedido);
	}
	
	@Get("/editar/{id}")
	public void edit(int id){
		result.forwardTo(this).formulario(dao.get(id));
	}
	
	@Post("/salvar")
	public void salvar(Pedido pedido){
		dao.salvar(pedido);
		result.redirectTo(this).listar();
	}
	
	@Get("/deletar/{id}")
	public void delete(int id){
		dao.deletar(id);
		result.redirectTo(this).listar();
	}
*/
}
