package com.solution;

import java.util.HashMap;

public class TwoSum {
	 public int[] twoSum(int[] numbers, int target) {
		 int[] index = new int[2];
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 
		 for(int i=0; i<numbers.length; i++){
			 if(map.get(target- numbers[i]) == null){
				 map.put(numbers[i], i);
			 }else {
				index[0] = map.get(target-numbers[i]) +1;
				index[1] = i+1;
			}
		 }
		 
		 return index;
	 }
}
