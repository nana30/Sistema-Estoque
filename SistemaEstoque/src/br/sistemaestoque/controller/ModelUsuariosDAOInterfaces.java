package br.sistemaestoque.controller;

import java.util.List;

import br.sistemaestoque.model.ModelCadastroUsuario;

public interface ModelUsuariosDAOInterfaces {

	ModelCadastroUsuario salvar(ModelCadastroUsuario usuario);

	ModelCadastroUsuario alterar(ModelCadastroUsuario usuario);

	ModelCadastroUsuario remover(ModelCadastroUsuario usuario);

	List<ModelCadastroUsuario> listar();

	ModelCadastroUsuario buscaid(long id);

}
