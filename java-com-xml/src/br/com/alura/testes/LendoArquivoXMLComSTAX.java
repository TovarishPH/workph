package br.com.alura.testes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
		
		XMLEvent evento = eventos.nextEvent();
		
		while (eventos.hasNext()) {
			
			if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {
				Produto produto = new Produto();
			}else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")) {
				
			}
		}
		
	}
}
