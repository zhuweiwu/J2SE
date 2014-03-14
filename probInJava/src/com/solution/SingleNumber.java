package com.solution;
/**
 * Single Number  
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */


public class SingleNumber {
	 public static int singleNumber(int[] A) {  
	        int res = 0;  
	        for (int i : A) {  
	            res ^= i;  
	        }  
	        return res;  
	 } 
	 
	 public static void main(String[] args) {
		int[] arr = {2,2,6,5,5};
		int singleNum = singleNumber(arr);
		System.out.println(singleNum);
	}
}
