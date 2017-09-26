package br.com.ph.collections.utils;

import java.util.Comparator;

import br.com.ph.collections.bean.Recibo;

public class TreeSetComparator implements Comparator<Recibo> {

	@Override
	public int compare(Recibo o1, Recibo o2) {
		if (o1.getQuantidade() > o2.getQuantidade()) {
			return 1;
		}
		
		if (o1.getQuantidade() < o2.getQuantidade()) {
			return -1;
		}
		return 0;
	}

}
