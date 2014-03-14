package com.solution;

/** 
 *  
 * Reverse Integer  
 *  
 * Reverse digits of an integer. 
 * Example1: x = 123, return 321 
 * Example2: x = -123, return -321 
 */

public class ReverseInteger {
	public int reverse(int x) {
		int revVal = 0;		
		while(x != 0){
			revVal = revVal*10 + x%10;
			x = x/10;
		}
        return revVal;
    }
}
