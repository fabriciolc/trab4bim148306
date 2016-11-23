package br.com.fabriciocornelius.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * Classe e uma entidade de persistencia de tabela de usuario no banco.
 * @author Fabricio
 *
 */
@Table(name="tb_usuario") //Nome da Tabela no banco de dados
@Entity //Declaração da classe com um Entidade
@NamedQuery(name = "UsuarioEntity.findUser",
		    query= "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.senha = :senha") //Querry para autenticação do login
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Delcaração das Colunas fazendo persistencia dos dados
	 */
	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private String codigo;

	@Column(name="ds_login")
	private String usuario;

	@Column(name="ds_senha")
	private String senha;


	/**
	 * Obtém Codigo
	 * @return codigo com codigo do usuario
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Configura o valor do codigo do usuario
	 * @param codigo o codigo do usuario
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * Obtém o Usuario (login)
	 * @return usuario o login do usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Configura o Usuario (login)
	 * @param usuario passa o login do usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtém senha
	 * @return senha do usuario
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Configura senha do usuario
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}