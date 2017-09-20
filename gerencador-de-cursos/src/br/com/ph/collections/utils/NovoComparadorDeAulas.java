package br.com.ph.collections.utils;

import java.util.Comparator;

import br.com.ph.collections.bean.Aula;

public class NovoComparadorDeAulas implements Comparator<Aula> {

	@Override
	public int compare(Aula o1, Aula o2) {
		if (o1.getTempo() > o2.getTempo()){
			return 1;
		}
		
		if (o1.getTempo() < o2.getTempo()){
			return -1;
		}
		return 0;
	}

}
