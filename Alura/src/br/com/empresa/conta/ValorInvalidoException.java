package br.com.empresa.conta;

public class ValorInvalidoException extends RuntimeException {

	public ValorInvalidoException(double valor) {
		super("Valor inválido: " + valor);
	}
}
