package br.com.fabriciocornelius.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
/**
 * Classe para recuperar EntityManager do JPAFilter
 * @author Fabricio
 *
 */
public class Uteis {

	public static EntityManager JpaEntityManager(){

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();

		HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();

		return (EntityManager)request.getAttribute("entityManager");
	}

	/**
	 * Metodo para mostrar mensagemde alerta
	 * @param mensagem a mensagem de alerta
	 */
	public static void Mensagem(String mensagem){

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage("Alerta",mensagem));
	}

	/**
	 * Metodo para mostrar mensagem de atenção
	 * @param mensagem a mensagem de atenção
	 */
	public static void MensagemAtencao(String mensagem){

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
	}

	/**
	 * Metodo para mostrar mensagem de info
	 * @param mensagem a mensagem de info
	 */
	public static void MensagemInfo(String mensagem){

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}

}