package com.solution;

import java.util.LinkedHashMap;

/**
 * 
 * 比如我cache只有4这么大，现在有很多元素1,2,2,4,2,5,3
 * cache                  income:1
 * 1
 * cache                  income:2
 * 2 1
 * cache                  income:1
 * 1 2
 * cache                  income:4
 * 4 1 2
 * cache                  income:2
 * 2 4 1
 * cache                  income:5
 * 5 2 4 1
 * cache                  income:3
 * 3 5 2 4
 * 新按元素使用率（？）排序，最后使用的放最前面
 * 如果cache不满，新来的放第一个，如果满了，在cache里面就把里面那个放到第一个，如果不在就删除最后一个，然后把新元素放第一个。
 * 
 * 
 * @author AD
 * 2014-3-3
 */
public class LRUCache {
	LinkedHashMap<Integer, Integer> map;
	int capacity;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
    	if(map.containsKey(key)){
    		int val = map.get(key);
    		map.remove(key);
    		map.put(key, val);
    		return val;
    	}
        return -1;
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		map.remove(key);
    		map.put(key, value);
    	}else {
			if(map.size() == capacity){
				int firstKey = map.keySet().iterator().next();
				map.remove(firstKey);
			}
			map.put(key, value);
		}
    }
}
