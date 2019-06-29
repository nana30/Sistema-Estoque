package br.sistemaestoque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Anotação para o hibernate saber que essa classe é uma entidade do persistence!
@Table(name= "Fornecedor")

public class ModelCadastroFornecedor {
	
	//Atributos da classe ModelProdutos!
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idFornecedor;
		
		@Column //Gera as colunas da tabela, no caso da tabela produtos
		private String nome;
		@Column
		private String endereco;
		@Column
		private String cidade;
		@Column
		private String telefone;
		@Column
		private String nomeVendedor;
		
		public long getidFornecedor() {
			return idFornecedor;
		}
		public void setidFornecedor(long idFornecedor) {
			this.idFornecedor = idFornecedor;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getNomeVendedor() {
			return nomeVendedor;
		}
		public void setNomeVendedor(String nomeVendedor) {
			this.nomeVendedor = nomeVendedor;
		}
		

}
