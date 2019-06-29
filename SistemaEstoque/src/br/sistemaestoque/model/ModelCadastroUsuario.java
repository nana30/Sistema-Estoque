package br.sistemaestoque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity //Anotação para o hibernate saber que essa classe é uma entidade do persistence!
@Table(name= "Usuarios")
public class ModelCadastroUsuario {
	
	//Atributos da classe ModelProdutos!
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idUsuarios;
		
		@Column //Gera as colunas da tabela, no caso da tabela produtos
		private String nome;
		@Column
		private String cargo;
		@Column
		private String senha;
		@Column
		private String confirmaSenha;
		
		public long getIdUsuarios() {
			return idUsuarios;
		}
		public void setIdUsuarios(long idUsuarios) {
			this.idUsuarios = idUsuarios;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCargo() {
			return cargo;
		}
		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getConfirmaSenha() {
			return confirmaSenha;
		}
		public void setConfirmaSenha(String confirmaSenha) {
			this.confirmaSenha = confirmaSenha;
		}
		

		
}
