package br.cardapio.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.cardapio.model.Pedido;

public class PedidoDao {

	private static Map<Integer, Pedido> db = new HashMap<Integer, Pedido>();

	public PedidoDao() {
	}
	
	public void salvar(Pedido pedido) {
		int id = pedido.getId();
		db.put(id, pedido);
	}
	public Collection<Pedido> lista() {
		return db.values();
	}
	public Pedido get(int id) {
		return db.get(id);
	}
	public void deletar(int id) {
		db.remove(id);
	}

}
