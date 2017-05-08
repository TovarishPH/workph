package alura.java.tres.thread;

import java.util.Collection;

public class ProduzMensagens implements Runnable {

	private int comeco;
	private int fim;
	private Collection<String> mensagens;
	
	public ProduzMensagens(int comeco, int fim, Collection<String> mensagens) {
		this.comeco = comeco;
		this.fim = fim;
		this.mensagens = mensagens;
	}
	
	@Override
	public void run() {
		for (int i = comeco; i < fim; i++) {
				mensagens.add("Mensagem " + i);
		}
	}

	public int getComeco() {
		return comeco;
	}


	public void setComeco(int comeco) {
		this.comeco = comeco;
	}


	public int getFim() {
		return fim;
	}


	public void setFim(int fim) {
		this.fim = fim;
	}


	public Collection<String> getMensagens() {
		return mensagens;
	}


	public void setMensagens(Collection<String> mensagens) {
		this.mensagens = mensagens;
	}
	
}
