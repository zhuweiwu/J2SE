package com.solution;

import java.util.LinkedHashMap;

/**
 * 
 * ������cacheֻ��4��ô�������кܶ�Ԫ��1,2,2,4,2,5,3
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
 * �°�Ԫ��ʹ���ʣ������������ʹ�õķ���ǰ��
 * ���cache�����������ķŵ�һ����������ˣ���cache����Ͱ������Ǹ��ŵ���һ����������ھ�ɾ�����һ����Ȼ�����Ԫ�طŵ�һ����
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
