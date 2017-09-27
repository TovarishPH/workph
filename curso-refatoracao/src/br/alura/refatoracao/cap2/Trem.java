package br.alura.refatoracao.cap2;

import java.util.List;

public class Trem {

	private List<Vagao> vagoes;
	private int capacidade;
	
	public boolean podeReservar(int lugaresAReservar) {
		
		return capacidade - lugaresJaReservados() > lugaresAReservar; 
	}

	private int lugaresJaReservados() {
		int lugaresJaReservados = 0;
		for(Vagao vagoes : vagoes) {
			lugaresJaReservados += vagoes.reservados();
		}
		return lugaresJaReservados;
	}
	
}