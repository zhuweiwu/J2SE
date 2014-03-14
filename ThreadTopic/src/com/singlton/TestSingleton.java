package com.singlton;

/**
 * 两种单例的写法
 * @author AD
 * 2014-1-17
 */
public class TestSingleton {
	
}

class Singleton{
	private static Singleton s = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		return s;
	} 
}

class Singlton2{
	private static Singlton2 s = null;
	private Singlton2(){}
	
	public static Singlton2 getInstance(){
		if(s == null){
			synchronized (Singlton2.class) {
				if(s == null){
					s = new Singlton2();
				}
			}
		}
		return s;
	}
}
