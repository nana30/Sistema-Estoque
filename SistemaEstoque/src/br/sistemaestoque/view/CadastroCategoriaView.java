package br.sistemaestoque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CadastroCategoriaView extends JPanel {

	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CadastroCategoriaView() {
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
		txtNome.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nome da Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNome.setBounds(419, 107, 307, 39);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtDescricao.setBounds(419, 157, 709, 39);
		add(txtDescricao);
		
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
			}
		});
		btnLimpar.setBounds(1138, 207, 106, 39);
		add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(419, 257, 825, 349);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Descri\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField.setBounds(419, 207, 641, 39);
		add(textField);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(1070, 207, 58, 39);
		btnBuscar.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/iconsearch.png")));
		add(btnBuscar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(1138, 617, 106, 39);
		add(btnExcluir);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDescricao.setEnabled(true);
				txtNome.setEnabled(true);
				btnSalvar.setEnabled(true);
				btnLimpar.setEnabled(true);
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
		btnPainelVertical.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/cadastro de categoria.jpg")));
		btnPainelVertical.setEnabled(false);
		btnPainelVertical.setBounds(10, 30, 367, 642);
		add(btnPainelVertical);
	}
}
