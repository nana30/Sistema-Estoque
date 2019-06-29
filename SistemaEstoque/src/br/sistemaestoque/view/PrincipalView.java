package br.sistemaestoque.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.sistemaestoque.util.Background;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PrincipalView extends JFrame {

	private JPanel painelPrincipal;
	private JButton btnBackground;
	
	
	
	public PrincipalView() {
		setTitle("Sistema de Estoque");
		setResizable(false);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 705);
		setPainelPrincipal(new JPanel());
		getPainelPrincipal().setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getPainelPrincipal());
		getPainelPrincipal().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Menu");
		menuBar.setBounds(0, 0, 1274, 21);
		getPainelPrincipal().add(menuBar);
		
		Background bg = new Background();
		bg.setSize(1272,705);
		bg.setLocation(0, 0);
		getPainelPrincipal().removeAll();
		getPainelPrincipal().add(menuBar);
		getPainelPrincipal().add(bg, BorderLayout.CENTER);
		getPainelPrincipal().revalidate();
		getPainelPrincipal().repaint();
		
		JMenu mnInicio = new JMenu("Sistema");
		
		menuBar.add(mnInicio);
		
		JMenuItem mntmIncio = new JMenuItem("Tela de In\u00EDcio");
		mntmIncio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Background bg = new Background();
				bg.setSize(1272,705);
				bg.setLocation(0, 0);
				getPainelPrincipal().removeAll();
				getPainelPrincipal().add(menuBar);
				getPainelPrincipal().add(bg, BorderLayout.CENTER);
				getPainelPrincipal().revalidate();
				getPainelPrincipal().repaint();
			}
		});
		mnInicio.add(mntmIncio);
		
		JMenu mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastroDeProdutos = new JMenuItem("Cadastro de Produtos");
		mntmCadastroDeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutosView prodview = new ProdutosView();
				prodview.setSize(1280, 705);
				prodview.setLocation(0, 0);
				//puxa as informações de tudo que está no painel novo em ProdutosView para a tela principal 
				getPainelPrincipal().removeAll();
				getPainelPrincipal().add(menuBar);
				getPainelPrincipal().add(prodview, BorderLayout.CENTER);
				getPainelPrincipal().revalidate();
				getPainelPrincipal().repaint();
				
				
			}
		});
		mnCadastro.add(mntmCadastroDeProdutos);
		
		JMenuItem mntmCadastroDeFornecedor = new JMenuItem("Cadastro de Fornecedor");
		mntmCadastroDeFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastroFornecedorView forview = new CadastroFornecedorView();
				forview.setSize(1280, 705);
				forview.setLocation(0, 0);
				//puxa as informações de tudo que está no painel novo em CadastroFornecedorView para a tela principal 
				getPainelPrincipal().removeAll();
				getPainelPrincipal().add(menuBar);
				getPainelPrincipal().add(forview, BorderLayout.CENTER);
				getPainelPrincipal().revalidate();
				getPainelPrincipal().repaint();
			}
		});
		mnCadastro.add(mntmCadastroDeFornecedor);
		
		JMenuItem mntmCadastroDeUsurio = new JMenuItem("Cadastro de Usu\u00E1rio");
		mntmCadastroDeUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastroUsuarioView usuview = new CadastroUsuarioView();
				usuview.setSize(1280, 705);
				usuview.setLocation(0, 0);
				//puxa as informações de tudo que está no painel novo em CadastroUsuarioView para a tela principal 
				getPainelPrincipal().removeAll();
				getPainelPrincipal().add(menuBar);
				getPainelPrincipal().add(usuview, BorderLayout.CENTER);
				getPainelPrincipal().revalidate();
				getPainelPrincipal().repaint();
			}
		});
		
		JMenuItem mntmCadastroDeCategoria = new JMenuItem("Cadastro de Categoria");
		mntmCadastroDeCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroCategoriaView catview = new CadastroCategoriaView();
				catview.setSize(1280, 705);
				catview.setLocation(0, 0);
				//puxa as informações de tudo que está no painel novo em CadastroCategoriaView para a tela principal 
				getPainelPrincipal().removeAll();
				getPainelPrincipal().add(menuBar);
				getPainelPrincipal().add(catview, BorderLayout.CENTER);
				getPainelPrincipal().revalidate();
				getPainelPrincipal().repaint();
				
			}
		});
		mnCadastro.add(mntmCadastroDeCategoria);
		mnCadastro.add(mntmCadastroDeUsurio);
		
		JMenu mnEstoque = new JMenu("Estoque");
		menuBar.add(mnEstoque);
		
		JMenuItem mntmEntradaEstoque = new JMenuItem("Entrada de Estoque");
		mntmEntradaEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EntradaEstoqueView estview = new EntradaEstoqueView();
				estview.setSize(1280, 705);
				estview.setLocation(0, 0);
				getPainelPrincipal().removeAll();
				getPainelPrincipal().add(menuBar);
				getPainelPrincipal().add(estview, BorderLayout.CENTER);
				getPainelPrincipal().revalidate();
				getPainelPrincipal().repaint();
			}
		});
		mnEstoque.add(mntmEntradaEstoque);
		
		JMenuItem mntmSadaDeEstoque = new JMenuItem("Sa\u00EDda de Estoque");
		mntmSadaDeEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SaidaEstoqueView saiview = new SaidaEstoqueView();
				saiview.setSize(1280, 705);
				saiview.setLocation(0, 0);
				getPainelPrincipal().removeAll();
				getPainelPrincipal().add(menuBar);
				getPainelPrincipal().add(saiview, BorderLayout.CENTER);
				getPainelPrincipal().revalidate();
				getPainelPrincipal().repaint();
			}
		});
		mnEstoque.add(mntmSadaDeEstoque);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmVendasDeProdutos = new JMenuItem("Vendas de Produtos");
		mnVendas.add(mntmVendasDeProdutos);
	}

	public JButton getBtnBackground() {
		return btnBackground;
	}

	public void setBtnBackground(JButton btnBackground) {
		this.btnBackground = btnBackground;
	}
	
	public JPanel getPainelPrincipal() {
		return painelPrincipal;
	}



	public void setPainelPrincipal(JPanel painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}
}
