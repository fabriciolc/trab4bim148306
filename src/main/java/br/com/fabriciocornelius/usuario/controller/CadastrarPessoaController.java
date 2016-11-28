package br.com.fabriciocornelius.usuario.controller;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.primefaces.model.UploadedFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.fabriciocornelius.model.PessoaModel;
import br.com.fabriciocornelius.repository.PessoaRepository;
import br.com.fabriciocornelius.usuario.controller.UsuarioController;
import br.com.fabriciocornelius.uteis.Uteis;

/**
 * Classe responsavel por salvar uma nova pessoa
 * @author Fabricio
 *
 */
@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {

	@Inject
	PessoaModel pessoaModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	PessoaRepository pessoaRepository;

	private UploadedFile file;

	/**
	 * Obtém File
	 * @return file
	 */
	public UploadedFile getFile() {
		return file;
	}
	/**
	 * Configurar o valor file
	 * @param file
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}

	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}

	/**
	 * Metodo para salvar um registro de pessoa
	 */
	public void SalvarNovaPessoa(){

		pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());

		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");

		pessoaRepository.SalvarNovoRegistro(this.pessoaModel);

		this.pessoaModel = null;

		Uteis.MensagemInfo("Registro cadastrado com sucesso");

	}

	/**
	 * Metodo para fazer Upload do Xml
	 */
	 public void UploadRegistros() {

		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		 try {


			 if(this.file.getFileName().equals("")){
				 Uteis.MensagemAtencao("Nenhum arquivo selecionado!");
				 return;
			 }

			 DocumentBuilder builder = factory.newDocumentBuilder();

	                 Document doc = builder.parse(this.file.getInputstream());

	                 Element element = doc.getDocumentElement();

	                 NodeList nodes = element.getChildNodes();

	                for (int i = 0; i < nodes.getLength(); i++) {

	        	     Node node  = nodes.item(i);

	        	    if(node.getNodeType() == Node.ELEMENT_NODE){

	        		 Element elementPessoa =(Element) node;

	        		 //PEGANDO OS VALORES DO ARQUIVO XML
	        		 String nome     = elementPessoa.getElementsByTagName("nome").item(0).getChildNodes().item(0).getNodeValue();
	        		 String sexo     = elementPessoa.getElementsByTagName("sexo").item(0).getChildNodes().item(0).getNodeValue();
	        		 String email    = elementPessoa.getElementsByTagName("email").item(0).getChildNodes().item(0).getNodeValue();
	        		 String endereco = elementPessoa.getElementsByTagName("endereco").item(0).getChildNodes().item(0).getNodeValue();

	        		 PessoaModel newPessoaModel = new PessoaModel();

	        		 newPessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
	        		 newPessoaModel.setEmail(email);
	        		 newPessoaModel.setEndereco(endereco);
	        		 newPessoaModel.setNome(nome);
	        		 newPessoaModel.setOrigemCadastro("X");
	        		 newPessoaModel.setSexo(sexo);

	        		 //SALVANDO UM REGISTRO QUE VEIO DO ARQUIVO XML
	        		 pessoaRepository.SalvarNovoRegistro(newPessoaModel);
	        	   }
	              }



		     Uteis.MensagemInfo("Registros cadastrados com sucesso!");

		} catch (ParserConfigurationException e) {

			e.printStackTrace();

		} catch (SAXException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}


	 }
}