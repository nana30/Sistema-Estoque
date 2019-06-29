package br.sistemaestoque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EntradaEstoqueView extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtValorPago;
	private JTextField txtQuantidade;
	private JTextField txtValidade;
	private JTextField textBuscar;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public EntradaEstoqueView() {
		
		setBackground(SystemColor.windowBorder);
		setBounds(100, 100, 1280, 750);
		setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Entrada");
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
		
		txtValorPago = new JTextField();
		txtValorPago.setEnabled(false);
		txtValorPago.setColumns(10);
		txtValorPago.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Valor Pago", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtValorPago.setBounds(692, 157, 116, 39);
		add(txtValorPago);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEnabled(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Quantidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtQuantidade.setBounds(419, 157, 106, 39);
		add(txtQuantidade);
		
		txtValidade = new JTextField();
		txtValidade.setEnabled(false);
		txtValidade.setColumns(10);
		txtValidade.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Data Validade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtValidade.setBounds(535, 157, 147, 39);
		add(txtValidade);
		
		textBuscar = new JTextField();
		textBuscar.setColumns(10);
		textBuscar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textBuscar.setBounds(419, 207, 641, 39);
		add(textBuscar);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(419, 257, 825, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Descri\u00E7\u00E3o", "Categoria", "Quantidade", "Validade", "Valor Pago"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Excluir");
		button.setBounds(1138, 603, 106, 39);
		add(button);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(1070, 207, 58, 39);
		btnBuscar.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/iconsearch.png")));
		add(btnBuscar);
		
		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setEnabled(false);
		comboCategoria.setBorder(new TitledBorder(null, "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboCategoria.setBounds(818, 157, 310, 39);
		add(comboCategoria);
		
		JButton btnSalvar = new JButton("Salvar");
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
				txtValorPago.setText("");
				comboCategoria.setToolTipText("");
			}
		});
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDescricao.setEnabled(true);
				txtNome.setEnabled(true);
				txtValorPago.setEnabled(true);
				txtQuantidade.setEnabled(true);
				txtValidade.setEnabled(true);
				comboCategoria.setEnabled(true);
				btnLimpar.setEnabled(true);
				btnSalvar.setEnabled(true);
				
			}
		});
		btnNovo.setBounds(1138, 107, 106, 39);
		add(btnNovo);
		btnLimpar.setBounds(1138, 207, 106, 39);
		add(btnLimpar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(383, 30, 883, 642);
		add(btnNewButton);
		
		JButton btnPainelVertical = new JButton("");
		btnPainelVertical.setBackground(SystemColor.inactiveCaption);
		btnPainelVertical.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/entrada de produtos.jpg")));
		btnPainelVertical.setEnabled(false);
		btnPainelVertical.setBounds(10, 30, 367, 642);
		add(btnPainelVertical);

	}
}
