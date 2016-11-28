package br.com.fabriciocornelius.model;
import java.time.LocalDateTime;

import br.com.fabriciocornelius.repository.entity.UsuarioEntity;

/**
 * Classe Modelo de Pessoa
 * @author Fabricio
 *
 */
public class PessoaModel {

	private Integer 	codigo;
	private String  	nome;
	private String  	sexo;
	private LocalDateTime	dataCadastro;
	private String  	email;
	private String  	endereco;
	private String  	origemCadastro;
	private UsuarioModel    usuarioModel;

	/**
	 * Obtém codigo da Pessoa
	 * @return
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * Configura codigo da pessoa
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * Obtém Nome da pessoa
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Configura o valor do Nome da pessoa
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Obtém Sexo da Pessoa
	 * @return sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Configura valor do sexo da pessoa
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Obtém Data de Cadastro da pessoa
	 * @return dataCadastro
	 */
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	/**
	 * Configura o valor da Data de Cadastro da Pessoa
	 * @param dataCadastro da pessoa
	 */
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	/**
	 * Obtém Email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Configura email da pessoas
	 * @param email o email da pessoas
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Obtém endereço da pessoa
	 * @return endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * Configura endereço da pessoa
	 * @param endereco o endereço da pessoa
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * Obtém Origem do Cadastro
	 * @return origemCadastro
	 */
	public String getOrigemCadastro() {
		return origemCadastro;
	}
	/**
	 * Configura o valor da Origem de Cadastro
	 * @param origemCadastro valor da Origem de Cadastro
	 */
	public void setOrigemCadastro(String origemCadastro) {
		this.origemCadastro = origemCadastro;
	}
	/**
	 * Obtém Modelo de Usuario
	 * @return usuarioModel
	 */
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	/**
	 * Configura o valor do usuarioModel
	 * @param usuarioModel
	 */
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
}