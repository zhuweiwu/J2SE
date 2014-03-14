package com.solution;

/**
 * hint:
 *  s ="" or null    -----Output: ""
 *  s =" 1"          -----Output:"1"
 *	s ="   a    b"   -----Output:"b a"
 * 
 * @author AD
 * 2014-3-11
 */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if(s == null || "".equals(s.trim())){
			return "";
		}else {
			
		}		
		String[] strs = s.trim().split(" +");
		if(strs.length == 0){
			return s;
		}

		int left = 0;
		int right = strs.length - 1;
		String temp = "";
		
		while(left < right){
			temp = strs[right];
			strs[right] = strs[left];
			strs[left] = temp;
			left++;
			right--;
		}
		StringBuilder builder = new StringBuilder();
		for(int i=0; i< strs.length; i++){	
			if(i == strs.length-1){
				builder.append(strs[i]);
			}else{			
				builder.append(strs[i]+" ");
			}
		}
		return builder.toString(); 
    }
	
	
	
	public static void main(String[] args) {
		ReverseWordsinaString test = new ReverseWordsinaString();
		String str = "   a    b";
		String s = test.reverseWords(str);
		System.out.println(s);
	}
}
