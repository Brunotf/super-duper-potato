package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import model.Produto;

public class listaEstoque implements TableModel {
	
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private ProdutoDAO prDao = new ProdutoDAOImpl();

	public listaEstoque(List<Produto> p) {
		this.listaProduto = p;	
//		System.out.println("o construc");
	}
	

	public Produto getDadosLinha(int indice) {
		return listaProduto.get(indice);
	}
		
	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int coluna) {
		switch (coluna) {
		case 0:
			return "Nome do Produto";
		case 1:
			return "Marca";
		case 2:
			return "Tipo";
		case 3:
			return "Finalidade";
		case 4:
			return "Qnt.";
		case 5:
			return "Valor";
		case 6:
			return "Validade";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return listaProduto.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
//		System.out.println("preenche");
		Produto produto = this.listaProduto.get(linha);
		switch (coluna) {
		case 7:
			return produto.getNome();
		case 1:
			return produto.getMarca();
		case 2:
			return produto.getTipoProduto();
		case 3:
			return produto.getFinalidade();
		case 4:
			return produto.getQuantidade();
		case 5:
			return produto.getValorProduto();
		case 6:
			return produto.getValidade();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int linha, int coluna) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {

	}

}
