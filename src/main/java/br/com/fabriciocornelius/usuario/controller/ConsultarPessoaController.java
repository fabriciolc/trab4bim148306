package br.com.fabriciocornelius.usuario.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fabriciocornelius.model.PessoaModel;
import br.com.fabriciocornelius.repository.PessoaRepository;

/**
 * Classe de Controller de consulta para Pessoa
 * @author Fabricio
 *
 */
@Named(value="consultarPessoaController")
@ViewScoped
public class ConsultarPessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject transient
	private PessoaModel pessoaModel;

	@Produces
	private List<PessoaModel> pessoas;

	@Inject transient
	private PessoaRepository pessoaRepository;

	/**
	 * Obtém lista de pessoas
	 * @return pessoas uma List<PessoaModel>
	 */
	public List<PessoaModel> getPessoas() {
		return pessoas;
	}
	/**
	 * Configura o valor de uma Lista de Pessoas
	 * @param pessoas uma lista de pessoas
	 */
	public void setPessoas(List<PessoaModel> pessoas) {
		this.pessoas = pessoas;
	}
	/**
	 * Obtém Modelo de Pessoa
	 * @return pessoaModel
	 */
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
	/**
	 * Configura pessoaModel com o Modelo da Pessoa
	 * @param pessoaModel Modelo da Pessoa
	 */
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}

	/***
	 * CARREGA AS PESSOAS NA INICIALIZAÇÃO
	 */
	@PostConstruct
	public void init(){

		//Retorna Pessoas cadastradas
		this.pessoas = pessoaRepository.GetPessoas();
	}
}
