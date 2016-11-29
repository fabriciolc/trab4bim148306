package br.com.fabriciocornelius.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fabriciocornelius.model.PessoaModel;
import br.com.fabriciocornelius.model.UsuarioModel;
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
	/***
	 * Método que consulta Pessoas do banco
	 * @return List<PessoalModel>
	 */
	public List<PessoaModel> GetPessoas(){

		List<PessoaModel> pessoasModel = new ArrayList<PessoaModel>();

		entityManager =  Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("PessoaEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<PessoaEntity> pessoasEntity = (Collection<PessoaEntity>)query.getResultList();

		PessoaModel pessoaModel = null;

		for (PessoaEntity pessoaEntity : pessoasEntity) {

			pessoaModel = new PessoaModel();
			pessoaModel.setCodigo(pessoaEntity.getCodigo());
			pessoaModel.setDataCadastro(pessoaEntity.getDataCadastro());
			pessoaModel.setEmail(pessoaEntity.getEmail());
			pessoaModel.setEndereco(pessoaEntity.getEndereco());
			pessoaModel.setNome(pessoaEntity.getNome());

			if(pessoaEntity.getOrigemCadastro().equals("X"))
				pessoaModel.setOrigemCadastro("XML");
			else
				pessoaModel.setOrigemCadastro("INPUT");


			if(pessoaEntity.getSexo().equals("M"))
				pessoaModel.setSexo("Masculino");
			else
				pessoaModel.setSexo("Feminino");

			UsuarioEntity usuarioEntity =  pessoaEntity.getUsuarioEntity();

			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());

			pessoaModel.setUsuarioModel(usuarioModel);

			pessoasModel.add(pessoaModel);
		}

		return pessoasModel;

	}
	/***
	 * Metodo para consultar uma pessoa castrada pelo Codigo
	 * @param codigo
	 * @return
	 */
	private PessoaEntity GetPessoa(int codigo){

		entityManager =  Uteis.JpaEntityManager();

		return entityManager.find(PessoaEntity.class, codigo);
	}

	/***
	 * Métdo para alterar registro no Banco
	 * @param pessoaModel
	 */
	public void AlterarRegistro(PessoaModel pessoaModel){

		entityManager =  Uteis.JpaEntityManager();

		PessoaEntity pessoaEntity = this.GetPessoa(pessoaModel.getCodigo());

		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setSexo(pessoaModel.getSexo());

		entityManager.merge(pessoaEntity);
	}
	/***
	 * Metodo para Excluir registro do banco
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){

		entityManager =  Uteis.JpaEntityManager();

		PessoaEntity pessoaEntity = this.GetPessoa(codigo);

		entityManager.remove(pessoaEntity);
	}
}