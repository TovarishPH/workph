package alura.java.interfaces;

public class Retangulo implements AreaCalculavel {

	private int altura;
	private int largura;
	
	public Retangulo(int altura, int largura) {
		this.altura = altura;
		this.largura = largura;
	}

	@Override
	public double calculaArea() {
		return this.altura * this.largura;
	}
}
