package br.com.fabriciocornelius.repository;

import java.io.Serializable;

import javax.persistence.Query;

import br.com.fabriciocornelius.model.UsuarioModel;
import br.com.fabriciocornelius.repository.entity.UsuarioEntity;
import br.com.fabriciocornelius.uteis.Uteis;

/**
 * Classe para validação do Usuario
 * @author Fabricio
 *
 */
public class UsuarioRepository implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
	 * Metodo Validador de Usuario
	 *
	 * @param usuarioModel o Objeto da classe UsuarioModel
	 * @return Resultado da execução da querry
	 */
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){

		try {

			//Execução da Querry para consulta
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");

			//Parametros para consultar o Usuario.
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());

			//Retorna o Resultado da Querry
			return (UsuarioEntity)query.getSingleResult();

		} catch (Exception e) {

			return null;
		}



	}
}