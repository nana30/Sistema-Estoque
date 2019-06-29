package br.sistemaestoque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity //Anotação para o hibernate saber que essa classe é uma entidade do persistence!
@Table(name= "Produtos")
public class ModelCadastroProdutos {
	
	//Atributos da classe ModelProdutos!
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduto;
	
	@Column //Gera as colunas da tabela, no caso da tabela produtos
	private String nome;
	@Column
	private String descricao;
	@Column
	private float valorVenda;
	
	
	//Getters and Setters da classe ModelProdutos!
	
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
	
	

}
