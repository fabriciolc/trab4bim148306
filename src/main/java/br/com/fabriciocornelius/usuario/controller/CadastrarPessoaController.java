package br.com.fabriciocornelius.usuario.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fabriciocornelius.model.PessoaModel;
import br.com.fabriciocornelius.repository.PessoaRepository;
import br.com.fabriciocornelius.usuario.controller.UsuarioController;
import br.com.fabriciocornelius.uteis.Uteis;

/**
 * Classe responsavel por salvar uma nova pessoa
 * @author Fabricio
 *
 */
@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {

	@Inject
	PessoaModel pessoaModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	PessoaRepository pessoaRepository;


	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}

	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}

	/**
	 * Metodo para salvar um registro de pessoa
	 */
	public void SalvarNovaPessoa(){

		pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());

		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");

		pessoaRepository.SalvarNovoRegistro(this.pessoaModel);

		this.pessoaModel = null;

		Uteis.MensagemInfo("Registro cadastrado com sucesso");

	}

}