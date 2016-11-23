package br.com.fabriciocornelius.usuario.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.fabriciocornelius.model.UsuarioModel;
import br.com.fabriciocornelius.repository.UsuarioRepository;
import br.com.fabriciocornelius.repository.entity.UsuarioEntity;
import br.com.fabriciocornelius.uteis.Uteis;;
/**
 *
 * @author Fabricio
 * Classe que faz o Controle de sessões de usuario
 * @Named Converte a classe em um bean gerenciado pelo CDI
 * @SessionScoped Define o escopo do bean
 * Na classe está sendo Injetada o UsuarioModel,UsuarioRepository e UsuarioEntity
 * @Inject Para injenção de dependencia da classe
 */
@Named(value="usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioModel usuarioModel;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private UsuarioEntity usuarioEntity;

	/**
	 * Obtém Usuario Model
	 * @return usuarioModel
	 */
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	/**
	 * Configura o usuarioModel
	 * @param usuarioModel o UsuarioModel
	 */
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	/**
	 * Obtém sessão do usuario
	 * @return Sessão do usuario
	 */
	public UsuarioModel GetUsuarioSession(){

		FacesContext facesContext = FacesContext.getCurrentInstance();

		return (UsuarioModel)facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}

	/**
	 * Metodo finalizar sessão do usuario
	 * @return Local aonde sera redirecionado
	 */
	public String Logout(){

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/index.xhtml?faces-redirect=true";
	}

	/**
	 * Metodo que inicia a sessão do usuario se Autenticado.
	 * @return
	 */
	public String EfetuarLogin(){

		if(StringUtils.isEmpty(usuarioModel.getUsuario()) || StringUtils.isBlank(usuarioModel.getUsuario())){ //Verifica se usuario escreveu o login.

			Uteis.Mensagem("Favor informar o login!");
			return null;
		}
		else if(StringUtils.isEmpty(usuarioModel.getSenha()) || StringUtils.isBlank(usuarioModel.getSenha())){ //Verifica se usuario escreveu a senha.

			Uteis.Mensagem("Favor informara senha!");
			return null;
		}

		/*
		 * @else
		 * Autenticação do usuario.
		 * Criando um sessão para o usuario.
		 */
		else{

			usuarioEntity = usuarioRepository.ValidaUsuario(usuarioModel);

			if(usuarioEntity!= null){

				usuarioModel.setSenha(null);
				usuarioModel.setCodigo(usuarioEntity.getCodigo());


				FacesContext facesContext = FacesContext.getCurrentInstance();

				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuarioModel);


				return "sistema/home?faces-redirect=true";
			}
			else{

				Uteis.Mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}


	}

}