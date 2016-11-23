package br.com.fabriciocornelius.filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/***
 * ESSE FILTER VAI SER CHAMADO TODA VEZ QUE FOR REALIZADO
 * UMA REQUISIÇÃO PARA O FACES SERVLET.
 * */
@WebFilter(servletNames ={ "Faces Servlet" })
public class JPAFilter implements Filter {


	private EntityManagerFactory entityManagerFactory;

	private String persistence_unit_name = "unit_app";

    public JPAFilter() {

    }

	public void destroy() {

		this.entityManagerFactory.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		/* Declarando uma Entidade de Gerenciamento ou (entityManager) chamada entityManager */
		EntityManager entityManager =  this.entityManagerFactory.createEntityManager();

		//Adicionando para Requisição
		request.setAttribute("entityManager", entityManager);

		//Inicia uma transação
		entityManager.getTransaction().begin();

		//Iniciando faces servlet*/
		chain.doFilter(request, response);

		try {

			// Se não houver algum erro ele da o commit
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Em acaso de alguma falha é feito rollback
			entityManager.getTransaction().rollback();
		}
		finally{

			/*Finaliza a entityManager*/
			entityManager.close();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

		/*CRIA O entityManagerFactory COM OS PARÂMETROS DEFINIDOS NO persistence.xml*/
		this.entityManagerFactory = Persistence.createEntityManagerFactory(this.persistence_unit_name);
	}

}