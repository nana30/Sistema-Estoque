package br.sistemaestoque.controller;

import java.util.List;


import br.sistemaestoque.model.ModelCadastroProdutos;

public interface ModelProdutosDAOInterfaces {

	public ModelCadastroProdutos salvar(ModelCadastroProdutos produtos);
	public ModelCadastroProdutos remover (ModelCadastroProdutos produtos);
	public ModelCadastroProdutos alterar(ModelCadastroProdutos produtos);
	public List<ModelCadastroProdutos> listar();
	public ModelCadastroProdutos buscaid(long id);
	public List<ModelCadastroProdutos> buscaPorNome (String nome);
	
	
}
