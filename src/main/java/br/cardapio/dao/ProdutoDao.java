package br.cardapio.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.cardapio.model.Produto;

public class ProdutoDao {

	private static Map<Integer, Produto> db = new HashMap<Integer, Produto>();

	public ProdutoDao() {
		
	}
	
	public void salvar(Produto produto) {
		int id = produto.getId();
		db.put(id, produto);
	}
	public Collection<Produto> lista() {
		return db.values();
	}
	public Produto get(int id) {
		return db.get(id);
	}
	public void deletar(int id) {
		db.remove(id);
	}

}
