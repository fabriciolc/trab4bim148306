package br.com.fabriciocornelius.model;

import java.io.Serializable;
/**
 * Classe do Modelo do usuario
 * @author Fabricio
 *
 */
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Declaração dos obj.
	 *
	 */
	private String codigo;
	private String usuario;
	private String senha;

	/**
	 * Obtém codigo do usuario
	 * @return codigo do usuario
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * Configuta o Condigo do usuario
	 * @param codigo o codigo do usuario
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * Obtém o Usuario (login)
	 * @return usuario (login)
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * Configura Usuario (login)
	 * @param usuario o Usuario (login)
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * Obtém a Senha do usuario
	 * @return senha do usuario
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Configura senha do Usuario
	 * @param senha a senha do usuario
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}