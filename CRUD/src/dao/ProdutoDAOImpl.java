package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {

	@Override
	public void adicionar(Produto produto) {
		DBUtil dbu = new DBUtil();
		Connection con = dbu.getConnection();
		String sql = "INSERT INTO produto (finalidade, nome, marca, descricao,"
				+ "tipoProduto, origem, quantidade, quantidadeAviso, validade,"
				+ "validadeAviso, valorProduto, descontoMax, imagem) VALUES"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
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
			stmt.setString(13, produto.getImagem());
			System.out.println("produto cadastrado");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> pesquisar(String nome) {
		List<Produto> listaTemp = new ArrayList<Produto>();
		DBUtil dbu = new DBUtil();
		Connection con = dbu.getConnection();
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
		String query = "SELECT finalidade, nome, marca, tipoProduto, quantidade, validade, valorProduto FROM produto";
		DBUtil dbu = new DBUtil();
		Connection con = dbu.getConnection();
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
		DBUtil dbu = new DBUtil();
		Connection con = dbu.getConnection();
		String apagar = "DELETE produto WHERE nome = '?'";
		try {
			PreparedStatement stmt = con.prepareStatement( apagar );
			stmt.setString(1, produto.getNome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Produto produto) {
		String atualizar = "UPDATE produto" 
		+"SET finalidade = 1, nome = '?', marca = '?', descricao = '?',"
		+"tipoProduto = ?, origem = ?, quantidade = ?, quantidadeAviso = ?,"
		+"validade = char(8), validadeAviso = ?, valorProduto = ?,"
		+"descontoMax = ?, imagem = '?'"
		+"WHERE nome = '?' AND marca = '?'";
	}

}
