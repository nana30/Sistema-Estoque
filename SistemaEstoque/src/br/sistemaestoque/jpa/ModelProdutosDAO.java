package br.sistemaestoque.jpa;

import java.util.List;


import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.sistemaestoque.controller.ModelProdutosDAOInterfaces;
import br.sistemaestoque.model.ModelCadastroProdutos;



public class ModelProdutosDAO implements ModelProdutosDAOInterfaces{
	
	//Gerenciamento com banco de dados
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dbestoquePU");

    EntityManager manager = factory.createEntityManager();
    
	@Override
	public ModelCadastroProdutos salvar(ModelCadastroProdutos produtos) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(produtos);
		manager.getTransaction().commit();
		return produtos;
	}

	@Override
	
	public ModelCadastroProdutos alterar(ModelCadastroProdutos produtos) {
		manager.getTransaction().begin();
		manager.merge(produtos);
		manager.getTransaction().commit();
		return produtos;
	}

	@Override
	public ModelCadastroProdutos remover(ModelCadastroProdutos produtos) {
		manager.getTransaction().begin();
		manager.remove(manager.find(ModelCadastroProdutos.class,produtos.getIdProduto()));
		manager.getTransaction().commit();
		return produtos;
	}
	
	@Override
	public List<ModelCadastroProdutos> listar() {
		manager.getTransaction().begin();
		Query qry = manager.createNamedQuery("Produtos.listall");
		List<ModelCadastroProdutos> result = qry.getResultList();
		manager.getTransaction().commit();
		StringBuilder builder = new StringBuilder();
		
		for(ModelCadastroProdutos test : result){
			
			ModelCadastroProdutos retorno = new ModelCadastroProdutos();
			builder.append("\nID: "+test.getIdProduto()+" Nome: "+test.getNome());
			
			retorno=test;
		}
		return result;
	}
	
	
	public List<ModelCadastroProdutos> buscaPorNome (String nome){
		Query qry = manager.createNamedQuery("Produtos.buscapornome");
		qry.setParameter("nome", nome+"%");
		List<ModelCadastroProdutos> results = qry.getResultList();
		for (ModelCadastroProdutos pessoafisica : results){
			System.out.println(">>>"+pessoafisica.toString());
		}
		return results;
	}

	@Override
	public ModelCadastroProdutos buscaid (long id) {
		manager.getTransaction().begin();
		Query qry = manager.createNamedQuery("Produtos.buscaid");
		qry.setParameter("id", id);
		List<ModelCadastroProdutos> result = qry.getResultList();
		
		manager.getTransaction().commit();
		
		
		ModelCadastroProdutos retorno = new ModelCadastroProdutos();
		for(ModelCadastroProdutos test : result){
			
			System.out.println("Id: "+test.getIdProduto()+"\nNome: "+test.getNome());
			retorno=test;
		}
		return retorno;
	}
	
	
	
	

	

	

	
	
	

}
