package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import model.Produto;
	
public class ctrEstoque {
	private Produto produto;
	private ProdutoDAO prDao = new ProdutoDAOImpl();
	private List<Produto> lista = new ArrayList<Produto>(); 
	public double calculaDesconto(){
		return produto.calculaDesconto();
	}
	
	public void adicionaProduto(Produto dados) {
		prDao.adicionar(dados);
	}
	
	public List<Produto> pesquisarProduto(String nome) {
		lista = prDao.pesquisar(nome);
		return lista;
	}
	
	public List<Produto> listarProdutos(){
		lista = prDao.listar();
		return lista;
	}
	
	public void removerProduto(Produto dados) {
		prDao.remover(dados);
	}
	
	public void alterarProduto(Produto dados) {
		prDao.alterar(dados);
	}
}
