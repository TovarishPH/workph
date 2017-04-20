package br.com.empresa.banco;

import java.util.ArrayList;
import java.util.Collections;


public class ArrayListDecrescente {

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(int i = 0; i <= 1000; i++){
			nums.add(i);
		}
		
		Collections.reverse(nums);
		
		for (Integer integer : nums) {
			System.out.println(integer);
		}
		
	}
}

