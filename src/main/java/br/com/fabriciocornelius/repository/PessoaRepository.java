package br.com.fabriciocornelius.repository;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.fabriciocornelius.model.PessoaModel;
import br.com.fabriciocornelius.repository.entity.PessoaEntity;
import br.com.fabriciocornelius.repository.entity.UsuarioEntity;
import br.com.fabriciocornelius.uteis.Uteis;
/**
 * Classe responsavel por persistir a entidade PessoaEntity
 * @author Fabricio
 *
 */
public class PessoaRepository {

	@Inject
	PessoaEntity pessoaEntity;

	EntityManager entityManager;

	/***
	 * Metodo que salva um registro de uma Pessoa
	 * @param pessoaModel
	 */
	public void SalvarNovoRegistro(PessoaModel pessoaModel){

		entityManager =  Uteis.JpaEntityManager();

		pessoaEntity = new PessoaEntity();
		pessoaEntity.setDataCadastro(LocalDateTime.now());
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setOrigemCadastro(pessoaModel.getOrigemCadastro());
		pessoaEntity.setSexo(pessoaModel.getSexo());

		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, pessoaModel.getUsuarioModel().getCodigo());

		pessoaEntity.setUsuarioEntity(usuarioEntity);

		entityManager.persist(pessoaEntity);

	}
}