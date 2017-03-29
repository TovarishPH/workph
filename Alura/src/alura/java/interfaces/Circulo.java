package alura.java.interfaces;

public class Circulo implements AreaCalculavel {

	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	@Override
	public double calculaArea() {
		//return Math.pow(raio, raio) * Math.PI;
		return raio * raio * Math.PI;
	}

}
