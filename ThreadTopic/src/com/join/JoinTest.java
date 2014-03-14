package com.join;

public class JoinTest {
	public static void main(String[] args) throws InterruptedException{
		Demo demo = new Demo();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		
		t1.start();
		//t1.join();//t1Ҫִ��Ȩ����Ϊt2��û��ʼ������ֻ��Ҫ���߳��ó�ִ��Ȩ
		t2.start();
		t1.join();//t1Ҫִ��Ȩ�����߳��ó�������t1��t2���߼�����ִ��Ȩ
		for(int i=0; i<80; i++){
			System.out.println("main....." + i);
		}
		
		System.out.println("over");
	}
}

class Demo implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<70; i++){
			System.out.println(Thread.currentThread().getName()+"....."+ i);
		}
	}
}