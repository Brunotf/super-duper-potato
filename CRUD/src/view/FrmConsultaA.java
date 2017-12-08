package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.FlowLayout;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;

import controller.ctrEstoque;
import controller.listaEstoque;
import model.Produto;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.NumberFormatter;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class FrmConsultaA extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private boolean ligarCampos = false;
	private String imagemCarregada = null;
	private static FrmConsultaA tela = new FrmConsultaA();
	private ctrEstoque controle = new ctrEstoque();
	private ButtonGroup cojuntoFinalidade;
	private ButtonGroup cojuntoExibir; 
	private ButtonGroup conjuntoOrigem;
	
	private JPanel contentPane;
	private JPanel painelConsulta;
	private JPanel painelPesquisa;
	private JPanel painelPesquisaLinha1;
	private JPanel painelPesquisaLinha2;
	private JScrollPane painelTabela;
	private JPanel painelImprimir;
	private JPanel painelFormulario;
	private JPanel painelBotoes;
	private JPanel painelCriar;
	private JPanel painelAlterar;
	private JPanel painelCampos;
	private JTable tableProduto;
	private JRadioButton rdbtnFinalidadeCliente;
	private JRadioButton rdbtnTodos;
	private JRadioButton rdbtnCliente;
	private JRadioButton rdbtnSalao;
	private JRadioButton rdbtnFinalidadeSalao;
	private JRadioButton rdbtnNacional;
	private JRadioButton rdbtnImportado;
	private JTextField txtPesquisa;
	private JTextField txtNomeProduto;
	private JTextField txtMarca;
	private JFormattedTextField txtDataDeValidade;
	private JFormattedTextField txtValorDoProduto;
	private JFormattedTextField txtDescontoMaximo;
	private JFormattedTextField txtValorComDesconto;
	private JButton btnPesquisarProduto;
	private JButton btnImprimir;
	private JButton btnExcluir;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnRegistrarProd;
	private JButton btnAlterarProd;
	private JButton btnVoltar;
	private JButton btnReturn;
	private JButton btnAdicionarImagem;
	private JButton btnAdicionar;
	private JComboBox <String> cboxOrganizarStatus;
	private JComboBox <String> cboxTipoProduto;
	private JTextField txtTipoProduto;
	private JLabel lblExibir;
	private JLabel lblFinalidade;
	private JLabel lblNomeProduto;
	private JLabel lblMarca;
	private JLabel lblValorComDesconto;
	private JLabel lblPercent;
	private JLabel lblDescontoMaximo;
	private JLabel lblValorDoProduto;
	private JLabel lblUnidades;
	private JLabel lblDias;
	private JLabel lblAvisoDeValidade;
	private JLabel lblDatasDeValidade;
	private JLabel lblLimiteDeAviso;
	private JLabel lblQuantidade;
	private JLabel lblOrigem;
	private JLabel lblTipoDeProduto;
	private JLabel lblDescricao;
	private JLabel imagem;
	private JTextArea txtDescricao;
	private JSpinner spnAvisoDeValidade;
	private JSpinner spnLimiteDeAviso;
	private JSpinner spnQuantidade;

	public FrmConsultaA() {
	}
	
	public void telaPrincipal() {	
		// habilitar campos
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1100, 550);
		this.setSize(1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2));

		painelConsulta = new JPanel();
		contentPane.add(painelConsulta);
		painelConsulta.setLayout(new BorderLayout(0, 0));

		painelPesquisa = new JPanel();
		painelConsulta.add(painelPesquisa, BorderLayout.NORTH);
		painelPesquisa.setLayout(new GridLayout(2, 1));

		painelPesquisaLinha1 = new JPanel();
		painelPesquisa.add(painelPesquisaLinha1);

		txtPesquisa = new JTextField();
		txtPesquisa.setColumns(30);

		btnPesquisarProduto = new JButton("Pesquisar Produto");
		painelPesquisaLinha1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelPesquisaLinha1.add(txtPesquisa);
		painelPesquisaLinha1.add(btnPesquisarProduto);

		painelPesquisaLinha2 = new JPanel();
		painelPesquisa.add(painelPesquisaLinha2);
		cboxOrganizarStatus = new JComboBox<String>();
		cboxOrganizarStatus.addItem("Aviso");
		cboxOrganizarStatus.addItem("Validade");
		cboxOrganizarStatus.addItem("Produto");
		cboxOrganizarStatus.addItem("Marca");
		cboxOrganizarStatus.addItem("Tipo");
		cboxOrganizarStatus.addItem("Finalidade");
		cboxOrganizarStatus.addItem("Maior Preço");
		cboxOrganizarStatus.addItem("Menor Preço");

		lblExibir = new JLabel("Exibir:");

		rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.setSelected(true);

		rdbtnCliente = new JRadioButton("Cliente");

		rdbtnSalao = new JRadioButton("Salão");
		painelPesquisaLinha2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelPesquisaLinha2.add(cboxOrganizarStatus);
		painelPesquisaLinha2.add(lblExibir);
		painelPesquisaLinha2.add(rdbtnTodos);
		painelPesquisaLinha2.add(rdbtnCliente);
		painelPesquisaLinha2.add(rdbtnSalao);

		painelTabela = new JScrollPane();
		painelConsulta.add(painelTabela, BorderLayout.CENTER);
//		painelTabela.setLayout(new BorderLayout(0, 0));
		listaEstoque listagem = new listaEstoque(listarTudo());
		
//		for (int x = 0; x < listagem.getRowCount(); x ++) {
//			for (int y = 0; y < 7; y ++)
//				listagem.getValueAt(x, y);			
//		}
		
//		listagem.getValueAt(0, 0);
		System.out.println("Retornei");
		tableProduto = new JTable(listagem);
		tableProduto.setColumnSelectionAllowed(true);
		tableProduto.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableProduto.getSelectionModel().addListSelectionListener(this);
		tableProduto.getColumnModel().getColumn(0).setPreferredWidth(102);
		tableProduto.getColumnModel().getColumn(3).setPreferredWidth(66);
		tableProduto.getColumnModel().getColumn(4).setPreferredWidth(45);
		tableProduto.getColumnModel().getColumn(5).setPreferredWidth(55);
		painelTabela.setViewportView(tableProduto);

		painelImprimir = new JPanel(new GridLayout(1, 3));
		painelConsulta.add(painelImprimir, BorderLayout.SOUTH);

		btnImprimir = new JButton("Imprimir Relatório");
		painelImprimir.add(new JLabel());
		painelImprimir.add(btnImprimir);
		painelImprimir.add(new JLabel());
		
		//FORMULARIO
		painelFormulario = new JPanel();
		contentPane.add(painelFormulario);
		painelFormulario.setLayout(new BorderLayout(0, 0));

		painelCampos = new JPanel();
		painelFormulario.add(painelCampos, BorderLayout.CENTER);
		
		verImagem();
		

		lblFinalidade = new JLabel("Finalidade: ");
		rdbtnFinalidadeCliente = new JRadioButton("Cliente");

		lblNomeProduto = new JLabel("Nome do Produto:");

		txtNomeProduto = new JTextField();
		txtNomeProduto.setColumns(10);

		lblMarca = new JLabel("Marca: ");

		txtMarca = new JTextField();
		txtMarca.setColumns(10);

		btnAdicionarImagem = new JButton("Adicionar Imagem");

		rdbtnFinalidadeSalao = new JRadioButton("Salão");

		lblDescricao = new JLabel("Descrição:");

		txtDescricao = new JTextArea();

		lblTipoDeProduto = new JLabel("Tipo de Produto: ");

		cboxTipoProduto = new JComboBox <String> ();

		btnAdicionar = new JButton("+");

		lblOrigem = new JLabel("Origem:");

		rdbtnImportado = new JRadioButton("Importado");

		rdbtnNacional = new JRadioButton("Nacional");

		lblQuantidade = new JLabel("Quantidade:");
		
		spnQuantidade = new JSpinner();

		lblLimiteDeAviso = new JLabel("Limite de Aviso:");

		spnLimiteDeAviso = new JSpinner();

		lblDatasDeValidade = new JLabel("Data de Validade:");

		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		txtDataDeValidade = new JFormattedTextField(formato);
		txtDataDeValidade.setColumns(10);

		lblAvisoDeValidade = new JLabel("Aviso de Validade:");

		spnAvisoDeValidade = new JSpinner();

		lblDias = new JLabel("Dias");

		lblUnidades = new JLabel("Unidades");

		lblValorDoProduto = new JLabel("Valor do Produto:");

//		NumberFormat formatoValor = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
//		formatoValor.setMaximumFractionDigits(2);
		NumberFormatter valorFormatado = new NumberFormatter();
		valorFormatado.setMinimum(0.01);
		valorFormatado.setMaximum(10000.00);
		valorFormatado.setOverwriteMode(true);
		valorFormatado.setAllowsInvalid(false);
		
		lblValorComDesconto = new JLabel("Valor com Desconto:");
		txtValorComDesconto = new JFormattedTextField(valorFormatado);
//		txtValorComDesconto.setValue(0.00);
		txtValorComDesconto.setColumns(10);
		
		txtValorDoProduto = new JFormattedTextField(valorFormatado);
//		txtValorDoProduto.setValue(0.00);
		txtValorDoProduto.setColumns(10);

		NumberFormatter descontoFormato = new NumberFormatter();
		descontoFormato.setMaximum(100);
		descontoFormato.setMinimum(0);
		lblDescontoMaximo = new JLabel("Desconto M\u00E1ximo:");
		txtDescontoMaximo = new JFormattedTextField(descontoFormato);
		txtDescontoMaximo.setColumns(10);

		lblPercent = new JLabel("%");

		

		GroupLayout gl_painelCampos = new GroupLayout(painelCampos);
		gl_painelCampos.setHorizontalGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup().addContainerGap().addGroup(gl_painelCampos
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(gl_painelCampos.createSequentialGroup().addGroup(gl_painelCampos
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelCampos.createSequentialGroup()
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnAdicionarImagem, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(imagem, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
												.addComponent(lblFinalidade).addGroup(
														gl_painelCampos
																.createSequentialGroup().addComponent(lblMarca).addGap(
																		245))
												.addComponent(lblDescricao)
												.addGroup(gl_painelCampos.createSequentialGroup()
														.addComponent(lblNomeProduto)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_painelCampos
																.createParallelGroup(Alignment.LEADING)
																.addComponent(txtMarca, GroupLayout.DEFAULT_SIZE, 322,
																		Short.MAX_VALUE)
																.addComponent(txtNomeProduto, GroupLayout.DEFAULT_SIZE,
																		322, Short.MAX_VALUE)
																.addComponent(txtDescricao, GroupLayout.DEFAULT_SIZE,
																		322, Short.MAX_VALUE)
																.addGroup(gl_painelCampos.createSequentialGroup()
																		.addComponent(rdbtnFinalidadeCliente).addGap(26)
																		.addComponent(rdbtnFinalidadeSalao))))))
								.addGroup(gl_painelCampos.createSequentialGroup().addComponent(lblQuantidade)
										.addGap(188)
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblDescontoMaximo).addComponent(lblAvisoDeValidade)
												.addComponent(lblLimiteDeAviso, Alignment.LEADING))
										.addGap(11)
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING, false)
												.addComponent(spnLimiteDeAviso, GroupLayout.DEFAULT_SIZE, 79,
														Short.MAX_VALUE)
												.addComponent(txtDescontoMaximo, 0, 0, Short.MAX_VALUE)
												.addComponent(spnAvisoDeValidade))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPercent).addComponent(lblDias)
												.addComponent(lblUnidades))
										.addGap(5)))
								.addGap(15))
						.addGroup(gl_painelCampos.createSequentialGroup().addGroup(gl_painelCampos
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_painelCampos.createSequentialGroup()
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
												.addComponent(lblDatasDeValidade).addComponent(lblValorDoProduto))
										.addGap(18)
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtValorDoProduto, 0, 0, Short.MAX_VALUE)
												.addComponent(txtDataDeValidade, GroupLayout.DEFAULT_SIZE, 74,
														Short.MAX_VALUE)
												.addComponent(spnQuantidade)))
								.addGroup(gl_painelCampos.createSequentialGroup().addComponent(lblValorComDesconto)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtValorComDesconto, 0, 0, Short.MAX_VALUE)))
								.addContainerGap(375, Short.MAX_VALUE))
						.addGroup(gl_painelCampos.createSequentialGroup().addComponent(lblTipoDeProduto)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cboxTipoProduto, GroupLayout.PREFERRED_SIZE, 119,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAdicionar).addGap(18)
								.addComponent(lblOrigem).addGap(6).addComponent(rdbtnImportado)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnNacional)
								.addContainerGap(100, Short.MAX_VALUE)))));
		gl_painelCampos.setVerticalGroup(
				gl_painelCampos.createParallelGroup(Alignment.LEADING).addGroup(gl_painelCampos
						.createSequentialGroup().addGap(11).addGroup(gl_painelCampos
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_painelCampos.createSequentialGroup()
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNomeProduto).addComponent(txtNomeProduto,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(22)
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblMarca)
												.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(23)
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblDescricao).addComponent(txtDescricao,
														GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_painelCampos.createSequentialGroup()
										.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
												.addComponent(imagem, GroupLayout.PREFERRED_SIZE, 141,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFinalidade).addComponent(rdbtnFinalidadeCliente)
												.addComponent(rdbtnFinalidadeSalao))
										.addGap(5).addComponent(btnAdicionarImagem)))
						.addGap(29)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipoDeProduto)
								.addComponent(cboxTipoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdicionar).addComponent(rdbtnImportado).addComponent(lblOrigem)
								.addComponent(rdbtnNacional))
						.addGap(26)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantidade)
								.addComponent(spnLimiteDeAviso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUnidades)
								.addComponent(spnQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLimiteDeAviso))
						.addGap(26)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDatasDeValidade).addComponent(lblDias)
								.addComponent(txtDataDeValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAvisoDeValidade).addComponent(spnAvisoDeValidade,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValorDoProduto).addComponent(lblDescontoMaximo)
								.addComponent(txtValorDoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDescontoMaximo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPercent))
						.addGap(26)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValorComDesconto).addComponent(txtValorComDesconto,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(107, Short.MAX_VALUE)));
		
		painelCampos.setLayout(gl_painelCampos);
		
				painelBotoes = new JPanel(new GridLayout(1, 7));
				painelFormulario.add(painelBotoes, BorderLayout.SOUTH);
				
						btnNovo = new JButton("Novo");
						painelBotoes.add(new JLabel());
						painelBotoes.add(btnNovo);
						painelBotoes.add(new JLabel());
						
								btnAlterar = new JButton("Alterar");
								painelBotoes.add(btnAlterar);
								painelBotoes.add(new JLabel());
								
										btnExcluir = new JButton("Excluir");
										painelBotoes.add(btnExcluir);
										painelBotoes.add(new JLabel());
				
				painelCriar = new JPanel(new GridLayout(1, 5));
				
						btnRegistrarProd = new JButton("Registrar");
						painelCriar.add(new JLabel());
						painelCriar.add(btnRegistrarProd);
						painelCriar.add(new JLabel());
				
							btnReturn = new JButton ("Voltar");
							painelCriar.add(btnReturn);
							painelCriar.add(new JLabel());
				
				painelAlterar = new JPanel(new GridLayout(1, 7));
				
						btnAlterarProd = new JButton("Alterar Produto");
						painelAlterar.add(new JLabel());
						painelAlterar.add(new JLabel());
						painelAlterar.add(btnAlterarProd);
						painelAlterar.add(new JLabel());
							btnVoltar = new JButton ("Voltar");
							painelAlterar.add(btnVoltar);
							painelAlterar.add(new JLabel());
							painelAlterar.add(new JLabel());
				
		ligarFormulario();
		btnNovo.addActionListener( this );
		btnAlterar.addActionListener( this );
		btnExcluir.addActionListener( this );
		btnRegistrarProd.addActionListener( this );
		btnReturn.addActionListener( this );
		btnAdicionarImagem.addActionListener( this );
		tableProduto.getSelectionModel().addListSelectionListener( this );
		btnAdicionar.addActionListener(this);
		
		this.txtValorComDesconto.requestFocusInWindow();
		this.txtValorDoProduto.requestFocusInWindow();
		
		cojuntoFinalidade = new ButtonGroup();
		cojuntoFinalidade.add(rdbtnFinalidadeCliente);
		cojuntoFinalidade.add(rdbtnFinalidadeSalao);
		cojuntoExibir = new ButtonGroup();
		cojuntoExibir.add(rdbtnTodos);
		cojuntoExibir.add(rdbtnCliente);
		cojuntoExibir.add(rdbtnSalao);
		conjuntoOrigem = new ButtonGroup();
		conjuntoOrigem.add(rdbtnImportado);
		conjuntoOrigem.add(rdbtnNacional);
		rdbtnImportado.setSelected(true);
		rdbtnFinalidadeCliente.setSelected(true);
		imagem.setVisible(false);
		btnAdicionarImagem.setVisible(false);
	}
	public List<Produto> listarTudo(){
		System.out.println("listei");
		List<Produto> listaTemp = controle.listarProdutos();
		
		return listaTemp;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela.telaPrincipal();
					tela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void verImagem() {
		if (imagemCarregada == null) {
			imagemCarregada = "./Icone-SemFoto.png";
		}
		System.out.println(imagemCarregada);
		BufferedImage bufImagem = null;
		try {
			bufImagem = ImageIO.read(getClass().getResource(imagemCarregada));
		} catch (IOException e) {
			System.out.println(e.getMessage());
//			imagemCarregada = null;
			verImagem();
			e.printStackTrace();
		} finally {
			bufImagem = adjustaImagem(bufImagem, 150, 150);
			imagem = new JLabel (new ImageIcon(bufImagem));
		}
		
	}
	
	public void ligarFormulario(){
		txtNomeProduto.setEnabled(ligarCampos);
		txtMarca.setEnabled(ligarCampos);
		txtDataDeValidade.setEnabled(ligarCampos);
		txtValorDoProduto.setEnabled(ligarCampos);
		txtDescontoMaximo.setEnabled(ligarCampos);
		txtValorComDesconto.setEnabled(ligarCampos);
		btnExcluir.setEnabled(ligarCampos);
		btnAlterar.setEnabled(ligarCampos);
		btnAdicionarImagem.setEnabled(ligarCampos);
		btnAdicionar.setEnabled(ligarCampos);
		cboxTipoProduto.setEnabled(ligarCampos);
		lblFinalidade.setEnabled(ligarCampos);
		lblNomeProduto.setEnabled(ligarCampos);
		lblMarca.setEnabled(ligarCampos);
		lblValorComDesconto.setEnabled(ligarCampos);
		lblPercent.setEnabled(ligarCampos);
		lblDescontoMaximo.setEnabled(ligarCampos);
		lblValorDoProduto.setEnabled(ligarCampos);
		lblUnidades.setEnabled(ligarCampos);
		lblDias.setEnabled(ligarCampos);
		lblAvisoDeValidade.setEnabled(ligarCampos);
		lblDatasDeValidade.setEnabled(ligarCampos);
		lblLimiteDeAviso.setEnabled(ligarCampos);
		lblQuantidade.setEnabled(ligarCampos);
		lblOrigem.setEnabled(ligarCampos);
		lblTipoDeProduto.setEnabled(ligarCampos);
		lblDescricao.setEnabled(ligarCampos);
		txtDescricao.setEnabled(ligarCampos);
		spnAvisoDeValidade.setEnabled(ligarCampos);
		spnLimiteDeAviso.setEnabled(ligarCampos);
		spnQuantidade.setEnabled(ligarCampos);
		rdbtnFinalidadeCliente.setEnabled(ligarCampos);
		rdbtnFinalidadeSalao.setEnabled(ligarCampos);
		rdbtnNacional.setEnabled(ligarCampos);
		rdbtnImportado.setEnabled(ligarCampos);
				
		txtValorComDesconto.setEditable(false);
	}

	public Produto enviaProduto() {
		
		Produto produto = new Produto();
		produto.setFinalidade(cojuntoFinalidade.getButtonCount());
		produto.setNome(txtNomeProduto.getText());
		produto.setMarca(txtMarca.getText());
		produto.setDescricao(txtDescricao.getText());
		produto.setTipoProduto(cboxTipoProduto.getSelectedItem().toString());
		produto.setOrigem(conjuntoOrigem.getButtonCount());
		produto.setQuantidade((Integer)(spnQuantidade.getValue()));
		produto.setQuantidadeAviso((Integer)(spnLimiteDeAviso.getValue()));
		produto.setValidade(txtDataDeValidade.getText());
		produto.setValidadeAviso((Integer)(spnAvisoDeValidade.getValue()));
		produto.setValorProduto(Double.parseDouble(txtValorDoProduto.getText()));
		produto.setDescontoMax(Integer.parseInt(txtDescontoMaximo.getText()));
		//desconto com acesso direto ao produto
		txtValorComDesconto.setText(String.valueOf(produto.calculaDesconto())); 
		return produto;
//		produto.setImagem();
	}
	
	public void recebeProduto(Produto produto) {
		if (produto.getFinalidade() == 0) {
			rdbtnFinalidadeCliente.setSelected(true);
		}
		else {
			rdbtnFinalidadeSalao.setSelected(true);
		}
		txtNomeProduto.setText(produto.getNome());
		txtMarca.setText(produto.getMarca());
		txtDescricao.setText(produto.getDescricao());
		cboxTipoProduto.setSelectedItem(produto.getTipoProduto());
		if (produto.getOrigem() == 1) {
			rdbtnImportado.setSelected(true);
		}
		else {
			rdbtnNacional.setSelected(true);
		}
		spnQuantidade.setValue(produto.getQuantidade());
		spnLimiteDeAviso.setValue(produto.getQuantidadeAviso());
		txtDataDeValidade.setText(produto.getValidade());
		spnAvisoDeValidade.setValue(produto.getValidadeAviso());
		txtValorDoProduto.setText(String.valueOf(produto.getValorProduto()));
		imagemCarregada = produto.getImagem();
	}
	
	public BufferedImage adjustaImagem(BufferedImage img, int w, int h) {
		BufferedImage imgSize = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = imgSize.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(img, 0, 0, w, h, null);
	    g2.dispose();
		return imgSize;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
//		System.out.println(cmd +" - ");
		
		if("Novo".equals(cmd)) {
			ligarCampos = true;
			ligarFormulario();
			painelFormulario.add(painelCriar, BorderLayout.SOUTH);
			painelBotoes.setVisible(false);
		}
		
		else if ("Alterar".equals(cmd)) {
			
			ligarCampos = true;
			ligarFormulario();
			painelFormulario.add(painelAlterar, BorderLayout.SOUTH);
		}
		
		else if ("Excluir".equals(cmd)) {
			
		}
		else if ("Registrar".equals(cmd)) {
			if ((txtDescontoMaximo.getText().isEmpty())
					|| ((txtNomeProduto.getText().isEmpty())
					|| (txtMarca.getText().isEmpty())
					|| (txtDescricao.getText().isEmpty())
					|| (((Integer)spnQuantidade.getValue()) < 0)
					|| (((Integer)spnLimiteDeAviso.getValue()) < 0)
					|| (txtDataDeValidade.getText().isEmpty())
					|| (((Integer)spnAvisoDeValidade.getValue()) < 0)
					|| (Double.parseDouble(txtValorDoProduto.getText()) < 0)
					|| (Double.parseDouble(txtDescontoMaximo.getText()) < 0)
					|| (Double.parseDouble(txtDescontoMaximo.getText()) > 100))) {
				
				JOptionPane.showMessageDialog(null, "Campos vazios ou preenchidos incorretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				controle.adicionaProduto(enviaProduto());
				System.out.println("registrar produto enviado a control");
				painelCampos.invalidate();
				painelCampos.revalidate();
				painelCampos.repaint();
			}
						
		}
		else if ("Voltar".equals(cmd)) {
			//LIMPA CAMPOS
			for(Component control : painelFormulario.getComponents())
			{
			    if(control instanceof JTextField)
			    {
			        JTextField ctrl = (JTextField) control;
			        ctrl.setText("");
			    }
			    else if (control instanceof JComboBox)
			    {
			        JComboBox ctr = (JComboBox) control;
			        ctr.setSelectedIndex(-1);
			    }
			    else if (control instanceof JSpinner)
			    {
			    	JSpinner ctr = (JSpinner) control;
			        ctr.setValue(0);
			    }
			}
			imagemCarregada = null;
			ligarCampos = false;
			ligarFormulario();
			painelCriar.setVisible(false);
			painelBotoes.setVisible(true);
			telaPrincipal();
		}
		
		else if ("Adicionar Imagem".equals(cmd)) {
			JFileChooser recebeImagem = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Imagem", "jpg", "png");
			recebeImagem.setFileFilter(filtro);
			int imagemSelecionada = recebeImagem.showOpenDialog(null);
			if (imagemSelecionada == JFileChooser.APPROVE_OPTION) {
				imagemCarregada = recebeImagem.getSelectedFile().getAbsolutePath();
				imagemCarregada = imagemCarregada.replaceAll("\\\\", "/");
				imagemCarregada = ("file:///"+imagemCarregada);
//				imagemCarregada = "C://Users//bruno//Documents//Overwatch//ScreenShots//Overwatch//ScreenShot_17-10-09_00-33-53-000.jpg";
			}
			System.out.println(imagemCarregada);
			verImagem();
		} 
		
		else if ("+".equals(cmd)) {
			String tipoProduto = JOptionPane.showInputDialog("Informe o tipo de produto:", JOptionPane.INPUT_VALUE_PROPERTY);
			cboxTipoProduto.addItem(tipoProduto);
			cboxTipoProduto.invalidate();			
			cboxTipoProduto.repaint();
			cboxTipoProduto.revalidate();
		}
				
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String cmd = e.toString();
		System.out.println(cmd);
//		Produto produto = listagem.getDadosLinha(tableProduto.getSelectedRow());
		btnAlterar.setEnabled(true);
		btnExcluir.setEnabled(true);
		painelBotoes.invalidate();
		painelBotoes.revalidate();
		painelBotoes.repaint();
//		painelFormulario.add(painelBotoes, BorderLayout.SOUTH);
//		if (produto != null) {
//			recebeProduto(produto);
//		}
	}

}
