package alura.java.tres.thread;

public class Programa implements Runnable {

	private int Id;
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Programa: " + getId() + " / valor: " + i);
		}
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

}
