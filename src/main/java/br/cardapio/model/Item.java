package br.cardapio.model;

public class Item {
	private Produto produto;
	private Integer quantidade;
	
	public Item() {
	}
	public Item(Produto produto, int quantidade) {
		setProduto(produto);
		setQuantidade(quantidade);
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
