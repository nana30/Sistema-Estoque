package br.sistemaestoque.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.sistemaestoque.controller.ModelFornecedorDAOInterfaces;
import br.sistemaestoque.controller.ModelProdutosDAOInterfaces;
import br.sistemaestoque.model.ModelCadastroFornecedor;
import br.sistemaestoque.model.ModelCadastroProdutos;

public class ModelFornecedorDAO implements ModelFornecedorDAOInterfaces{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dbestoquePU");

    EntityManager manager = factory.createEntityManager();
    
	@Override
	public ModelCadastroFornecedor salvar(ModelCadastroFornecedor fornecedor) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(fornecedor);
		manager.getTransaction().commit();
		return fornecedor;
	}

	@Override
	
	public ModelCadastroFornecedor alterar(ModelCadastroFornecedor fornecedor) {
		manager.getTransaction().begin();
		manager.merge(fornecedor);
		manager.getTransaction().commit();
		return fornecedor;
	}

	@Override
	public ModelCadastroFornecedor remover(ModelCadastroFornecedor fornecedor) {
		manager.getTransaction().begin();
		manager.remove(manager.find(ModelCadastroFornecedor.class,fornecedor.getidFornecedor()));
		manager.getTransaction().commit();
		return fornecedor;
	}
	
	@Override
	public List<ModelCadastroFornecedor> listar() {
		manager.getTransaction().begin();
		Query qry = manager.createNamedQuery("Produtos.listall");
		List<ModelCadastroFornecedor> result = qry.getResultList();
		manager.getTransaction().commit();
		StringBuilder builder = new StringBuilder();
		
		for(ModelCadastroFornecedor test : result){
			
			ModelCadastroFornecedor retorno = new ModelCadastroFornecedor();
			builder.append("\nID: "+test.getidFornecedor()+" Nome: "+test.getNome());
			
			retorno=test;
		}
		return result;
	}
	
	
	public List<ModelCadastroFornecedor> buscaPorNome (String nome){
		Query qry = manager.createNamedQuery("Produtos.buscapornome");
		qry.setParameter("nome", nome+"%");
		List<ModelCadastroFornecedor> results = qry.getResultList();
		for (ModelCadastroFornecedor pessoafisica : results){
			System.out.println(">>>"+pessoafisica.toString());
		}
		return results;
	}

	@Override
	public ModelCadastroFornecedor buscaid (long id) {
		manager.getTransaction().begin();
		Query qry = manager.createNamedQuery("Produtos.buscaid");
		qry.setParameter("id", id);
		List<ModelCadastroFornecedor> result = qry.getResultList();
		
		manager.getTransaction().commit();
		
		
		ModelCadastroFornecedor retorno = new ModelCadastroFornecedor();
		for(ModelCadastroFornecedor test : result){
			
			System.out.println("Id: "+test.getidFornecedor()+"\nNome: "+test.getNome());
			retorno=test;
		}
		return retorno;
	}

}
