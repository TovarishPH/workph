package alura.java.tres.lang;

import java.awt.image.ColorConvertOp;
import java.io.PrintStream;

import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;

public class TestaString {

	public static void main(String[] args) {
//		String s = "fj11";
//		s = s.replace("1", "2");
//		
//		System.out.println(s.length());
//		
//		PrintStream saida = System.out;
//	    saida.println("ola");
//		
//		Conta c = new ContaCorrente();
//		System.out.println(c);
		
		String s = "Alura";
		String d = "Socorram-me, subi no ônibus em Marrocos";
		String f = "anotaram a data da maratona";
		
//		palavrasEmOrdemContraria(d);
//		inverteComStringBuilder(f);
		
//		char c = '3';
//		System.out.println(Character.getNumericValue(c));
		String tx = "762";
		convertInInt(tx);

	}

	private static void textoAoContrario(String texto) {
		for(int i = texto.length() -1; i >= 0; i--){
			System.out.print(texto.charAt(i));
		}
	}
	
	private static void palavrasEmOrdemContraria(String texto){
		String[] palavras = texto.split(" ");
		for (int i = palavras.length - 1; i >= 0 ; i--) {
			if(palavras[i] == palavras[0]){
				System.out.print(palavras[i]);
			}else {
				System.out.print(palavras[i] + " ");
			}
		}
	}
	
	public static void inverteComStringBuilder(String texto) {
        System.out.print("\t");
        StringBuilder invertido = new StringBuilder(texto).reverse();
        System.out.println(invertido);
    }
	
	private static void convertInInt(String tx){
		int[] nums = new int[tx.length()];
		char letter;
		for(int i = 0; i <= tx.length() - 1; i++){
			letter = tx.charAt(i);
			System.out.print(nums[i] = Character.getNumericValue(letter));
		}
		
	}

}
