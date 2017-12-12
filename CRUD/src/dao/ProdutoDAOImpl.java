package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {

	@Override
	public void adicionar(Produto produto) {

		Connection con = DBUtil.getInstance().getConnection();
		String sql = "INSERT INTO produto (finalidade, nome, marca, descricao,"
				+ "tipoProduto, origem, quantidade, quantidadeAviso, validade,"
				+ "validadeAviso, valorProduto, descontoMax) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getFinalidade());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getMarca());
			stmt.setString(4, produto.getDescricao());
			stmt.setString(5, "Stringa");
			stmt.setInt(6, produto.getOrigem());
			stmt.setInt(7, produto.getQuantidade());
			stmt.setInt(8, produto.getQuantidadeAviso());
			stmt.setString(9, produto.getValidade());
			stmt.setInt(10, produto.getValidadeAviso());
			stmt.setDouble(11, produto.getValorProduto());
			stmt.setDouble(12, produto.getDescontoMax());
			// stmt.setString(13, produto.getImagem());
			stmt.execute();
			stmt.close();
			// System.out.println("produto cadastrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> pesquisar(String nome) {

		List<Produto> listaTemp = new ArrayList<Produto>();
		Connection con = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM contatos WHERE nome like ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setImagem(rs.getString("imagem"));
				produto.setFinalidade(rs.getInt("finalidade"));
				produto.setNome(rs.getString("nome"));
				produto.setMarca(rs.getString("marca"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setTipoProduto(rs.getString("tipoProduto"));
				produto.setOrigem(rs.getInt("origem"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setQuantidadeAviso(rs.getInt("quantidadeAviso"));
				produto.setValidade(rs.getString("validade"));
				produto.setValidadeAviso(rs.getInt("validadeAviso"));
				produto.setValorProduto(rs.getDouble("valorProduto"));
				produto.setDescontoMax(rs.getInt("descontoMax"));
				listaTemp.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTemp;
	}

	@Override
	public List<Produto> listar() {

		List<Produto> listaTemp = new ArrayList<Produto>();
		String query = "SELECT * FROM produto";
		Connection con = DBUtil.getInstance().getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setFinalidade(rs.getInt("finalidade"));
				produto.setNome(rs.getString("nome"));
				produto.setMarca(rs.getString("marca"));
				produto.setTipoProduto(rs.getString("tipoProduto"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValidade(rs.getString("validade"));
				produto.setValorProduto(rs.getDouble("valorProduto"));
				listaTemp.add(produto);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTemp;
	}

	@Override
	public void remover(Produto produto) {

		Connection con = DBUtil.getInstance().getConnection();
		String apagar = "DELETE produto WHERE nome = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(apagar);
			stmt.setString(1, produto.getNome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Produto produto) {
		String sql = "UPDATE produto SET nome = ?, marca = ? WHERE id = ?";
		Connection con = DBUtil.getInstance().getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		}

	}

}
