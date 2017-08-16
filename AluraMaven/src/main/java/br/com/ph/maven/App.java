package br.com.ph.maven;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Produto p = new Produto("bala jukinha", 0.15);
		
		System.out.println("Produto: " + p.getNome() + "\nValor: R$" + p.getPreco());
	}
}
