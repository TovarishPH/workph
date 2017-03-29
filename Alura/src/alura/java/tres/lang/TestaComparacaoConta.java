package alura.java.tres.lang;

import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;

public class TestaComparacaoConta {

	public static void main(String[] args) {
		Conta cc = new ContaCorrente();
		Conta cc2 = new ContaCorrente();
		
		cc.setNome("Jurandir");
		cc2.setNome("Jurandir");
		
		cc.setNumero(1);
		cc2.setNumero(1);
		
		System.out.println("Usando '==':" + (cc == cc2));
		System.out.println("Usando equals:" + cc.equals(cc2));
		
	}
}
