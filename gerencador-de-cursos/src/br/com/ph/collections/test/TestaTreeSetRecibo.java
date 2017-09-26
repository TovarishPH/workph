package br.com.ph.collections.test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import br.com.ph.collections.bean.Recibo;
import br.com.ph.collections.utils.TreeSetComparator;

public class TestaTreeSetRecibo {

	public static void main(String[] args) {
		
		Recibo r1 = new Recibo("pedras", 10);
		Recibo r2 = new Recibo("moedas", 25);
		Recibo r3 = new Recibo("bolachas", 30);
		
		Set<Recibo> recibosSet = new TreeSet<Recibo>(new TreeSetComparator());
		
		recibosSet.add(r1);
		recibosSet.add(r2);
		recibosSet.add(r3);
		
		Iterator<Recibo> it = recibosSet.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
