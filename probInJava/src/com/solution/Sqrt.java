package com.solution;

/**
 * f(n) = x^2 -n
 * 
 * f(x) = f(x(i)) + f'(x(i))(x - x(i)) = 0
 * 
 * x(i+1) = x(i) - f(x(i))/f'(x(i))
 *        = x(i) - (x(i)^2 - n)/2(x(i))
 * x(i+1) = (x(i) + n/x(i))/2
 * 
 * 
 * @author AD
 * 2014-3-6
 */
public class Sqrt {
	public int sqrt(int x) {
		
		if(x == 0)
			return 0;
		double pre;		
		double cur = 0;
		
		while(true){
			pre = cur;
			cur = x/(2*pre) + pre/2;						
			if(Math.abs(pre-cur)<0.001){
				break;
			}
		}		
        return (int) cur;
    }
}
