package br.com.alura.testes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.model.Produto;

public class SistemaTeste {

	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document documento = builder.parse("src/vendas.xml");
		
		//Moeda
		String moeda = documento.getDocumentElement().getAttribute("moeda");
		System.out.println(" Moeda:" + moeda);
		
		NodeList produtos = documento.getElementsByTagName("produto");
		for(int i = 0;i < produtos.getLength(); i++){
			
			Element produto = (Element) produtos.item(i);
			
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			
			Produto prod = new Produto(nome, preco);
			
			System.out.println(prod);
		}

	}
}