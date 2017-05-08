package alura.java.tres.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

public class RegistroDeMensagens {

	public static void main(String[] args) throws InterruptedException {

		Collection<String> mensagens = new LinkedList<String>();
		
		Thread t1 = new Thread(new ProduzMensagens(0, 10000, mensagens));
		Thread t2 = new Thread(new ProduzMensagens(10000, 20000, mensagens));
		Thread t3 = new Thread(new ProduzMensagens(20000, 30000, mensagens));
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Threads de mensagens finalizadas");
		
		// verifica se as mensagens foram guardadas
		for (int i = 0; i < 15000; i++) {
			if(!mensagens.contains("Mensagem " + i)){
				throw new IllegalStateException("Mensagem " + i + " não encontrada");
			}
		}
		
		if(mensagens.contains(null)){
			throw new IllegalStateException("não deveria ter null aqui dentro");
		}
		
		System.out.println("Fim da execução com sucesso!");
		
	}
}
