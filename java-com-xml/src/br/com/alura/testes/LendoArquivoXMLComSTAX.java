package br.com.alura.testes;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Produto;

public class LendoArquivoXMLComSTAX {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(is);

		Produto produto;

		while (eventos.hasNext()) {

			XMLEvent evento = eventos.nextEvent();

			if (evento.isStartElement()
					&& evento.asStartElement().equals("produtos")) {
				produto = criaUmProduto(eventos);
			}
		}
	}

	private static Produto criaUmProduto(XMLEventReader eventos) throws Exception {
		Produto produto = new Produto();

		while(eventos.hasNext()){
			XMLEvent evento = eventos.nextEvent();
			
			if(evento.isStartElement() && evento.asStartElement().equals("nome")){
				evento = eventos.nextEvent();
				produto.setNome(evento.asCharacters().getData());
			}
			
		}
		return null;
	}
}
