package model;

public class Produto {
	private int finalidade;
	private String nome;
	private String marca;
	private String descricao;
	private String tipoProduto;
	private int origem;
	private int quantidade;
	private int quantidadeAviso;
	private String validade;
	private int validadeAviso;
	private double valorProduto;
	private int descontoMax;
	private String imagem;

	public int getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(int finalidade) {
		this.finalidade = finalidade;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public int getOrigem() {
		return origem;
	}

	public void setOrigem(int origem) {
		this.origem = origem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidadeAviso() {
		return quantidadeAviso;
	}

	public void setQuantidadeAviso(int quantidadeAviso) {
		this.quantidadeAviso = quantidadeAviso;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getValidadeAviso() {
		return validadeAviso;
	}

	public void setValidadeAviso(int validadeAviso) {
		this.validadeAviso = validadeAviso;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getDescontoMax() {
		return descontoMax;
	}

	public void setDescontoMax(int descontoMax) {
		this.descontoMax = descontoMax;
	}

	public double calculaDesconto() {
		double resultado = valorProduto * ((double)descontoMax / 100);
		return valorProduto - resultado;
	}

	public int verificaQuantidade() {
		if (quantidade == 0) {
			return 2;
		} else if (quantidade < quantidadeAviso) {
			return 1;
		} else {
			return 0;
		}
	}

	public void verficaValidade() {

	}

}
