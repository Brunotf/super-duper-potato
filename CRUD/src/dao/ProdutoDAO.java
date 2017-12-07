package dao;

import java.util.List;
import model.Produto;

public interface ProdutoDAO {
	void adicionar( Produto produto );
	List<Produto> pesquisar( String nome );
	List<Produto> listar();
	void remover(Produto produto);
	void alterar(Produto produto);
}
