package br.sistemaestoque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.sistemaestoque.jpa.ModelProdutosDAO;
import br.sistemaestoque.jpa.ModelUsuariosDAO;
import br.sistemaestoque.model.ModelCadastroProdutos;
import br.sistemaestoque.model.ModelCadastroUsuario;

import javax.swing.border.LineBorder;
import javax.swing.JTable;

public class CadastroUsuarioView extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSenha;
	private JTextField txtConfirmaSenha;
	private JTextField textBuscar;
	
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CadastroUsuarioView() {
		setBackground(SystemColor.windowBorder);
		setBounds(100, 100, 1280, 750);
		setLayout(null);
		
		JScrollPane painelTabela = new JScrollPane((Component) null);
		painelTabela.setBounds(419, 257, 825, 350);
		add(painelTabela);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Cargo"
			}
		));
		painelTabela.setViewportView(table);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro");
		lblCadastroDeProdutos.setBounds(399, 42, 223, 54);
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Impact", Font.PLAIN, 30));
		add(lblCadastroDeProdutos);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(419, 107, 490, 39);
		txtNome.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nome do Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(txtNome);
		txtNome.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setEnabled(false);
		txtCargo.setBounds(919, 107, 209, 39);
		txtCargo.setColumns(10);
		txtCargo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cargo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(txtCargo);
		
		txtSenha = new JTextField();
		txtSenha.setEnabled(false);
		txtSenha.setBounds(419, 157, 321, 39);
		txtSenha.setColumns(10);
		txtSenha.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(txtSenha);
		
		txtConfirmaSenha = new JTextField();
		txtConfirmaSenha.setEnabled(false);
		txtConfirmaSenha.setBounds(750, 157, 378, 39);
		txtConfirmaSenha.setColumns(10);
		txtConfirmaSenha.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Confirma Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(txtConfirmaSenha);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(1070, 207, 58, 39);
		btnBuscar.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/iconsearch.png")));
		add(btnBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(419, 207, 641, 39);
		textBuscar.setColumns(10);
		textBuscar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Usu\u00E1rios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(textBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelUsuariosDAO usdao = new ModelUsuariosDAO();
				ModelCadastroUsuario cadus = new ModelCadastroUsuario();
				cadus.setNome(txtNome.getText());
				cadus.setCargo(txtCargo.getText());
				cadus.setSenha(txtSenha.getText());
				cadus.setConfirmaSenha(txtConfirmaSenha.getText());
				usdao.salvar(cadus);
				txtNome.setText("");
				txtCargo.setText("");
				txtConfirmaSenha.setText("");
				txtSenha.setText("");
				
			}
		});
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelUsuariosDAO usudao = new ModelUsuariosDAO();
				usudao.listar();
			}
		});
		btnListar.setBounds(1022, 618, 106, 40);
		add(btnListar);
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(1138, 157, 106, 39);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(1138, 207, 106, 39);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//clicando no botão limpar, todos os campos voltarão a ficar em branco, sem nada digitado!
				txtNome.setText("");
				txtCargo.setText("");
				txtConfirmaSenha.setText("");
				txtSenha.setText("");
			}
		});
		add(btnLimpar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCargo.setEnabled(true);
				txtConfirmaSenha.setEnabled(true);
				txtNome.setEnabled(true);
				txtSenha.setEnabled(true);
				btnSalvar.setEnabled(true);
				btnLimpar.setEnabled(true);
			}
		});
		btnNovo.setBounds(1138, 107, 106, 39);
		add(btnNovo);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelUsuariosDAO prodexc = new ModelUsuariosDAO();
				ModelCadastroUsuario prodcad = new ModelCadastroUsuario();
				
				 String excluir = JOptionPane.showInputDialog("Qual ID excluir?");
				 int idProdutoView = Integer.parseInt(excluir);
				 prodcad.setIdUsuarios(idProdutoView);
				 prodexc.remover(prodcad);
				
			}
		});
		btnExcluir.setBounds(1138, 619, 106, 39);
		add(btnExcluir);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(383, 30, 883, 642);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setEnabled(false);
		add(btnNewButton);
		
		JButton btnPainelVertical = new JButton("");
		btnPainelVertical.setBounds(10, 30, 367, 642);
		btnPainelVertical.setBackground(SystemColor.inactiveCaption);
		btnPainelVertical.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/cadastro de usuarios.jpg")));
		btnPainelVertical.setEnabled(false);
		add(btnPainelVertical);
	

		

	}
}
