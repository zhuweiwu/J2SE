package com.solution;
import java.util.HashMap;

import com.basicclass.Point;


public class MaxPointonaLine {
	public static int maxPoints(Point[] points){
		if(points.length<=2){
			return points.length;
		}
		double k = 0.0;
		int maxPointNum = 0;
		int tempMaxPointNum = 0;
		int samePointNum = 0;
		int parallelPointNum = 0;
		HashMap<Double, Integer> slopeMap = new HashMap<Double, Integer>();
		
		for(int i=0; i<points.length; i++){
			samePointNum = 1;
			parallelPointNum = 0;
			tempMaxPointNum = 0;
			slopeMap.clear();
			
			for(int j=i+1; j<points.length; j++){
				//same points
				if(points[i].x == points[j].x && points[i].y == points[j].y){
					samePointNum ++;
					continue;
				}
				
				//k does not exist
				if(points[i].x == points[j].x){
					parallelPointNum ++;
				}else {//k exist
					if(points[i].y == points[j].y){
						k = 0.0;
					}else {
						k = ((double)points[j].y - (double)points[i].y)/((double)points[j].x - (double)points[i].x);
					}
					
					if(slopeMap.get(k) == null){
						slopeMap.put(k, 1);
						if(tempMaxPointNum == 0)//!!!!!
							tempMaxPointNum = 1;
					}else {
						int num = slopeMap.get(k);
						num ++;
						slopeMap.put(k, num);
						if(num > tempMaxPointNum){
							tempMaxPointNum = num;
						}
					}
				}	
			}
			if(parallelPointNum >= 1){
				if(parallelPointNum > tempMaxPointNum){
					tempMaxPointNum = parallelPointNum;
				}
			}
			tempMaxPointNum += samePointNum;
			if(tempMaxPointNum > maxPointNum){
				maxPointNum = tempMaxPointNum;
			}	
		}
		return maxPointNum;
	}
	
	public static void main(String[] args) {
		Point[] points = {new Point(0,9), new Point(138,429), new Point(115,359)};
		 int nums = maxPoints(points);
		 System.out.println(nums);
		
	}
}
