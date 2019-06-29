package br.sistemaestoque.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import br.sistemaestoque.controller.ModelProdutosDAOInterfaces;
import br.sistemaestoque.jpa.ModelProdutosDAO;
import br.sistemaestoque.model.ModelCadastroProdutos;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdutosView extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtVenda;
	private JTextField txtBuscar;
	
	private JTable tableProdutos;
	
	

	/**
	 * Create the panel.
	 */
	public ProdutosView() {
		setBackground(SystemColor.windowBorder);
		setBounds(100, 100, 1280, 750);
		setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro");
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Impact", Font.PLAIN, 30));
		lblCadastroDeProdutos.setBounds(399, 42, 223, 54);
		add(lblCadastroDeProdutos);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nome do Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNome.setBounds(419, 107, 298, 39);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descri\u00E7\u00E3o do Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtDescricao.setBounds(723, 107, 405, 39);
		add(txtDescricao);
		
		txtVenda = new JTextField();
		txtVenda.setEnabled(false);
		txtVenda.setColumns(10);
		txtVenda.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Valor Venda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtVenda.setBounds(419, 157, 298, 39);
		add(txtVenda);
		
		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setEnabled(false);
		comboCategoria.setBorder(new TitledBorder(null, "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboCategoria.setBounds(723, 157, 248, 39);
		add(comboCategoria);
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtBuscar.setBounds(419, 207, 641, 39);
		add(txtBuscar);
		
		
		
		
		JScrollPane paneTable = new JScrollPane((Component) null);
		paneTable.setBounds(419, 257, 825, 349);
		add(paneTable);
		
		tableProdutos = new JTable();
		tableProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Descri\u00E7\u00E3o", "Valor", "Categoria"
			}
		));
		paneTable.setViewportView(tableProdutos);
		

		

		
		JButton button = new JButton("Excluir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ModelProdutosDAO prodexc = new ModelProdutosDAO();
				ModelCadastroProdutos prodcad = new ModelCadastroProdutos();
				
				 String excluir = JOptionPane.showInputDialog("Qual ID excluir?");
				 int idProdutoView = Integer.parseInt(excluir);
				 prodcad.setIdProduto(idProdutoView);
				 prodexc.remover(prodcad);
			}
		});
		button.setBounds(1138, 617, 106, 39);
		add(button);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/iconsearch.png")));
		btnBuscar.setBounds(1070, 207, 58, 39);
		add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelCadastroProdutos prod = new ModelCadastroProdutos();
				ModelProdutosDAO proddao = new ModelProdutosDAO();
				prod.setNome(txtNome.getText());
				prod.setDescricao(txtDescricao.getText());
				prod.setValorVenda(Long.parseLong(txtVenda.getText()));
				proddao.salvar(prod);
				txtNome.setText("");
				txtDescricao.setText("");
				txtVenda.setText("");
				comboCategoria.setToolTipText("");
				txtNome.setEnabled(false);
				txtDescricao.setEnabled(false);
				txtVenda.setEnabled(false);
				comboCategoria.setEnabled(false);
				
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(1138, 157, 106, 39);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//clicando no botão limpar, todos os campos voltarão a ficar em branco, sem nada digitado!
				txtNome.setText("");
				txtDescricao.setText("");
				txtVenda.setText("");
				comboCategoria.setToolTipText("");
			}
		});
		btnLimpar.setBounds(1138, 207, 106, 39);
		add(btnLimpar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtNome.setEnabled(true);
				txtDescricao.setEnabled(true);
				txtVenda.setEnabled(true);
				txtBuscar.setEnabled(true);
				comboCategoria.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnLimpar.setEnabled(true);
				btnSalvar.setEnabled(true);
				
			}
		});
		btnNovo.setBounds(1138, 107, 106, 39);
		add(btnNovo);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(383, 30, 883, 642);
		add(btnNewButton);
		
		JButton btnPainelVertical = new JButton("");
		btnPainelVertical.setBackground(SystemColor.inactiveCaption);
		btnPainelVertical.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/cadastro de produtos.jpg")));
		btnPainelVertical.setEnabled(false);
		btnPainelVertical.setBounds(10, 30, 367, 642);
		add(btnPainelVertical);
		
	
		
	}
	
	

	
}
