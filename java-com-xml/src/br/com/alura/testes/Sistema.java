package br.com.alura.testes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.model.Produto;

public class Sistema {

	public static void main(String[] args) throws Exception {
		
		// contróis documento na memória
		//cria fábrica
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		//cria instancia de documento
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		//atribui à um objeto
		Document document = builder.parse("src/vendas.xml");
		
		//Exibindo a moeda de pagto da venda - atributo da tag venda
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(" Moeda de pagto:" + moeda + "\n");

		//Pegando o objeto produto
		NodeList produtos = document.getElementsByTagName("produto");
		
		for(int i = 0;i < produtos.getLength(); i++){
			Element produto = (Element) produtos.item(i);
			
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			
			Produto prod = new Produto(nome, preco);
			
			System.out.println(prod);
			
		}
	}
}
