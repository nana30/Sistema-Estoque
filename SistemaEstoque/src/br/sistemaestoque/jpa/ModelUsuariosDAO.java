package br.sistemaestoque.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.sistemaestoque.controller.ModelUsuariosDAOInterfaces;
import br.sistemaestoque.model.ModelCadastroProdutos;
import br.sistemaestoque.model.ModelCadastroUsuario;

public class ModelUsuariosDAO implements ModelUsuariosDAOInterfaces{
	
	//Gerenciamento com banco de dados
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dbestoquePU");

	    EntityManager manager = factory.createEntityManager();
	    
		@Override
		public ModelCadastroUsuario salvar(ModelCadastroUsuario usuario) {
			// TODO Auto-generated method stub
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			return usuario;
		}

		@Override
		
		public ModelCadastroUsuario alterar(ModelCadastroUsuario usuario) {
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			return usuario;
		}

		@Override
		public ModelCadastroUsuario remover(ModelCadastroUsuario usuario) {
			manager.getTransaction().begin();
			manager.remove(manager.find(ModelCadastroUsuario.class,usuario.getIdUsuarios()));
			manager.getTransaction().commit();
			return usuario;
		}
		
		@Override
		public List<ModelCadastroUsuario> listar() {
			manager.getTransaction().begin();
			Query qry = manager.createNamedQuery("SELECT e FROM usuarios e");
			List<ModelCadastroUsuario> result = qry.getResultList();
			manager.getTransaction().commit();
			StringBuilder builder = new StringBuilder();
			
			for(ModelCadastroUsuario test : result){
				
				ModelCadastroUsuario retorno = new ModelCadastroUsuario();
				builder.append("\nID: "+test.getIdUsuarios()+" Nome: "+test.getNome());
				
				retorno=test;
			}
			return result;
		}
		
		
		public List<ModelCadastroUsuario> buscaPorNome (String nome){
			Query qry = manager.createNamedQuery("Produtos.buscapornome");
			qry.setParameter("nome", nome+"%");
			List<ModelCadastroUsuario> results = qry.getResultList();
			for (ModelCadastroUsuario pessoafisica : results){
				System.out.println(">>>"+pessoafisica.toString());
			}
			return results;
		}

		public ModelCadastroUsuario buscaid (long id) {
			manager.getTransaction().begin();
			Query qry = manager.createNamedQuery("Produtos.buscaid");
			qry.setParameter("id", id);
			List<ModelCadastroUsuario> result = qry.getResultList();
			
			manager.getTransaction().commit();
			
			
			ModelCadastroUsuario retorno = new ModelCadastroUsuario();
			for(ModelCadastroUsuario test : result){
				
				System.out.println("Id: "+test.getIdUsuarios()+"\nNome: "+test.getNome());
				retorno=test;
			}
			return retorno;
		}

}
