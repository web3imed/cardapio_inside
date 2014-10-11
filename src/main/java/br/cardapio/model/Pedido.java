package br.cardapio.model;

import java.util.ArrayList;
import java.util.List;

import br.cardapio.dao.PedidoDao;


public class Pedido {
	private int id;
	private List<Item> itens = new ArrayList<Item>();

	public Pedido(PedidoDao pedidoDao) {
		this.setId(pedidoDao.lista().size()+1);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public void addItem(Item item) {
		getItens().add(item);
	}
}
