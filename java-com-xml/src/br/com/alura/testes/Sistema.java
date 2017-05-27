package br.com.alura.testes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Sistema {

	public static void main(String[] args) throws Exception {
		
		// contróis documento na memória
		//cria fábrica
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		//cria instancia de documento
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		//atribui à um objeto
		Document document = builder.parse("src/vendas.xml");

		//pega lista de tags do xml
		NodeList formasDePagamento = document.getElementsByTagName("nome");
		//pega o elemento
		Element fdpItem = (Element) formasDePagamento.item(0);
		//passa o contrúdo do elemento para String
		String formaDePagamento = fdpItem.getTextContent();
		
		System.out.println(formaDePagamento);
	}
}
