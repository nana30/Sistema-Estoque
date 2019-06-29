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

public class SaidaEstoqueView extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtMotivoSaida;
	private JTextField txtQuantidade;
	private JTextField txtSaida;
	private JTextField textBuscar;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public SaidaEstoqueView() {
		
		setBackground(SystemColor.windowBorder);
		setBounds(100, 100, 1280, 750);
		setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Sa\u00EDda");
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Impact", Font.PLAIN, 30));
		lblCadastroDeProdutos.setBounds(399, 42, 223, 54);
		add(lblCadastroDeProdutos);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nome do Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNome.setBounds(419, 107, 389, 39);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtMotivoSaida = new JTextField();
		txtMotivoSaida.setEnabled(false);
		txtMotivoSaida.setColumns(10);
		txtMotivoSaida.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Motivo de Sa\u00EDda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtMotivoSaida.setBounds(419, 157, 709, 39);
		add(txtMotivoSaida);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEnabled(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Quantidade em Estoque", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtQuantidade.setBounds(818, 107, 150, 39);
		add(txtQuantidade);
		
		txtSaida = new JTextField();
		txtSaida.setEnabled(false);
		txtSaida.setColumns(10);
		txtSaida.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Quantidade de Sa\u00EDda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtSaida.setBounds(978, 107, 150, 39);
		add(txtSaida);
		
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
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/iconsearch.png")));
		btnBuscar.setBounds(1070, 207, 58, 39);
		add(btnBuscar);
		
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
				txtMotivoSaida.setText("");
			}
		});
		btnLimpar.setBounds(1138, 207, 106, 39);
		add(btnLimpar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtMotivoSaida.setEnabled(true);
				txtNome.setEnabled(true);
				txtQuantidade.setEnabled(true);
				txtSaida.setEnabled(true);
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
		btnPainelVertical.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/saida de produtos.jpg")));
		btnPainelVertical.setEnabled(false);
		btnPainelVertical.setBounds(10, 30, 367, 642);
		add(btnPainelVertical);

	}
}
