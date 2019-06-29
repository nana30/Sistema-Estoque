package br.sistemaestoque.controller;

import java.util.List;

import br.sistemaestoque.model.ModelCadastroFornecedor;

public interface ModelFornecedorDAOInterfaces {

	ModelCadastroFornecedor salvar(ModelCadastroFornecedor fornecedor);

	ModelCadastroFornecedor alterar(ModelCadastroFornecedor produtos);

	ModelCadastroFornecedor remover(ModelCadastroFornecedor fornecedor);

	List<ModelCadastroFornecedor> listar();

	ModelCadastroFornecedor buscaid(long id);

}
