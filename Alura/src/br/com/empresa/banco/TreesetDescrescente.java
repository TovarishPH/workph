package br.com.empresa.banco;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreesetDescrescente {

	public static void main(String[] args) {
		
		TreeSet<Integer> nums = new TreeSet<Integer>();
		
		for(int i = 0; i <= 1000; i++){
			nums.add(i);
		}
		
		// Aplicar a ordem reversa do Set
		
//		NavigableSet<Integer> descNums= nums.descendingSet();
//		
//		for (Integer integer : descNums) {
//			System.out.println(integer);
//		}
		
		for (Integer integer : nums.descendingSet()) {
			System.out.println(integer);
		}
	}

}
