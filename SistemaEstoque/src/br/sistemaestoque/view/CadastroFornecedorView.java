package br.sistemaestoque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.sistemaestoque.jpa.ModelFornecedorDAO;
import br.sistemaestoque.model.ModelCadastroFornecedor;

public class CadastroFornecedorView extends JPanel {
	
	private JTextField txtNomeFornecedor;
	private JTextField txtEndereco;
	private JTextField textCidade;
	private JTextField textTelefone;
	private JTextField textVendedor;
	private JTextField textBuscar;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public CadastroFornecedorView() {
		
		

		/**
		 * Create the panel.
		 */
		
			setBackground(SystemColor.windowBorder);
			setBounds(100, 100, 1280, 750);
			setLayout(null);
			
			JLabel lblCadastroDeProdutos = new JLabel("Cadastro");
			lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadastroDeProdutos.setFont(new Font("Impact", Font.PLAIN, 30));
			lblCadastroDeProdutos.setBounds(399, 42, 223, 54);
			add(lblCadastroDeProdutos);
			
			txtNomeFornecedor = new JTextField();
			txtNomeFornecedor.setEnabled(false);
			txtNomeFornecedor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nome do Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			txtNomeFornecedor.setBounds(419, 107, 710, 39);
			add(txtNomeFornecedor);
			txtNomeFornecedor.setColumns(10);
			
			txtEndereco = new JTextField();
			txtEndereco.setEnabled(false);
			txtEndereco.setColumns(10);
			txtEndereco.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			txtEndereco.setBounds(419, 157, 456, 39);
			add(txtEndereco);
			
			textCidade = new JTextField();
			textCidade.setEnabled(false);
			textCidade.setColumns(10);
			textCidade.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textCidade.setBounds(885, 157, 244, 39);
			add(textCidade);
			
			textTelefone = new JTextField();
			textTelefone.setEnabled(false);
			textTelefone.setColumns(10);
			textTelefone.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telefone", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textTelefone.setBounds(419, 207, 231, 39);
			add(textTelefone);
			
			textVendedor = new JTextField();
			textVendedor.setEnabled(false);
			textVendedor.setColumns(10);
			textVendedor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nome Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textVendedor.setBounds(776, 207, 353, 39);
			add(textVendedor);
			
			textBuscar = new JTextField();
			textBuscar.setColumns(10);
			textBuscar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Fornecedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textBuscar.setBounds(420, 259, 757, 39);
			add(textBuscar);
			
			JScrollPane scrollPane = new JScrollPane((Component) null);
			scrollPane.setBounds(419, 309, 825, 297);
			add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Fornecedor", "Endere\u00E7o", "Cidade", "Telefone", "Nome Vendedor"
				}
			));
			scrollPane.setViewportView(table);
			
			JButton btnExcluir = new JButton("Excluir");
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModelFornecedorDAO forex = new ModelFornecedorDAO();
					ModelCadastroFornecedor forcad = new ModelCadastroFornecedor();
							String excluir = JOptionPane.showInputDialog("Qual ID excluir?");
					 int idForView = Integer.parseInt(excluir);
					 forcad.setidFornecedor(idForView);
					 forex.remover(forcad);
					
				}
			});
			btnExcluir.setBounds(1138, 617, 106, 39);
			add(btnExcluir);
			
			JButton btnBuscar = new JButton("");
			btnBuscar.setBounds(1187, 259, 58, 39);
			btnBuscar.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/iconsearch.png")));
			add(btnBuscar);
			
			JComboBox comboUF = new JComboBox();
			comboUF.setEnabled(false);
			comboUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
			comboUF.setBorder(new TitledBorder(null, "UF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			comboUF.setBounds(660, 207, 106, 39);
			add(comboUF);
			
			
			
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModelFornecedorDAO fordao = new ModelFornecedorDAO();
					ModelCadastroFornecedor fornecedor = new ModelCadastroFornecedor();
					fornecedor.setNome(txtNomeFornecedor.getText());
					fornecedor.setEndereco(txtEndereco.getText());
					fornecedor.setCidade(textCidade.getText());
					fornecedor.setTelefone(textTelefone.getText());
					fornecedor.setNomeVendedor(textVendedor.getText());
					fordao.salvar(fornecedor);
					txtNomeFornecedor.setText("");
					txtEndereco.setText("");
					textCidade.setText("");
					textTelefone.setText("");
					textVendedor.setText("");
					txtNomeFornecedor.setEnabled(false);
					txtEndereco.setEnabled(false);
					textCidade.setEnabled(false);
					textTelefone.setEnabled(false);
					textVendedor.setEnabled(false);
					
				}
			});
			btnSalvar.setEnabled(false);
			btnSalvar.setBounds(1139, 157, 106, 39);
			add(btnSalvar);
			
			JButton btnNovo = new JButton("Novo");
			btnNovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtNomeFornecedor.setEnabled(true);
					txtEndereco.setEnabled(true);
					textCidade.setEnabled(true);
					textTelefone.setEnabled(true);
					textVendedor.setEnabled(true);
					btnSalvar.setEnabled(true);
				}
			});
			btnNovo.setBounds(1139, 107, 106, 39);
			add(btnNovo);
			
			JButton btnLimpar = new JButton("Limpar");
			btnLimpar.setEnabled(false);
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//clicando no botão limpar, todos os campos voltarão a ficar em branco, sem nada digitado!
					txtNomeFornecedor.setText("");
					txtEndereco.setText("");
				}
			});
			btnLimpar.setBounds(1139, 207, 106, 39);
			add(btnLimpar);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setBackground(SystemColor.controlShadow);
			btnNewButton.setEnabled(false);
			btnNewButton.setBounds(383, 30, 883, 642);
			add(btnNewButton);
			
			JButton btnPainelVertical = new JButton("");
			btnPainelVertical.setBackground(SystemColor.inactiveCaption);
			btnPainelVertical.setIcon(new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/cadastro de fornecedor.jpg")));
			btnPainelVertical.setEnabled(false);
			btnPainelVertical.setBounds(10, 30, 367, 642);
			add(btnPainelVertical);
		}
	}


