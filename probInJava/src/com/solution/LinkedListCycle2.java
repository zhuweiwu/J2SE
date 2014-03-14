package com.solution;

import com.basicclass.ListNode;

/**
 * Linked List Cycle: if have cycle, return the start of the cycle.
 * 
 *    |<--    a   -->|
 *    O--O--O--O--O--O
 *                  / \
 *                 O   O
 *                /     \
 *               O       O
 *                \     /
 * ��һ�������ص�-->O   O
 * ������ڳ���Ϊb   \ /
 *                   O  
 * �ܳ���ΪL
 * ���ĳ���Ϊr
 * ����ָ�������������߹���·�ֱ�Ϊs��2s
 * 2s - s = k * r
 * s = k * r, s = a + b
 * �õ� a + b = k * r = (k-1)*r + r = (k-1)*r + L-a
 * ����� a = (k-1)*r + (L - a - b)
 * �������ǽ���ָ�����ָ��ͷ��㣬��ָ���ٶȱ�Ϊ����ָ��һ��, 
 * ���ǾͿ��Եõ�����ָ���ߵ���ڵ�ʱ������ָ���Ȼ���������
 * 
 * 
 * 
 * @author AD
 * 2014-3-13
 */
public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null){
			return null;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast!=null && fast.next!=null && slow!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		
		if(fast != slow){
			return null;
		}
		
		slow = head;
		while(fast!=null && slow!=null){
			if(fast == slow){
				break;
			}
			
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
    }
}
