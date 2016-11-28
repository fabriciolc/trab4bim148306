package br.com.fabriciocornelius.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe de persistencia de Pessoas no Banco
 * @author Fabricio
 *
 */
@Entity
@Table(name="tb_pessoa")
@NamedQueries({

	@NamedQuery(name = "PessoaEntity.findAll",query= "SELECT p FROM PessoaEntity p")

})
public class PessoaEntity {

	/**
	 * Declaração de variavies para persistencia no banco
	 */

	@Id
	@GeneratedValue
	@Column(name = "id_pessoa")
	private Integer codigo;

	@Column(name = "nm_pessoa")
	private String  nome;

	@Column(name = "fl_sexo")
	private String  sexo;

	@Column(name = "dt_cadastro")
	private LocalDateTime	dataCadastro;

	@Column(name = "ds_email")
	private String  email;

	@Column(name = "ds_endereco")
	private String  endereco;

	@Column(name = "fl_origemCadastro")
	private String  origemCadastro;


	/**
	 * @OneToOne fazendo relacionamento com Usuario de 1 para 1
	 */
	@OneToOne
	@JoinColumn(name="id_usuario_cadastro")
	private UsuarioEntity usuarioEntity;



	/**
	 * Obtém codigo
	 * @return codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * Configura valor do codigo da Pessoa
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * Obtém Nome
	 * @return nome o nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Configura valor nome da pessoas
	 * @param nome o nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Obtém sexo
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
	 * Obtém o UsuaioEntity
	 * @return usuarioEntity
	 */
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	/**
	 * Configura o valor do usuarioEntity
	 * @param usuarioEntity
	 */
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

}