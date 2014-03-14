package com.solution;

import com.basicclass.ListNode;

/**
 * øÏ¬˝÷∏’Î’“ª∑
 * @author AD
 * 2014-3-12
 */
public class LinkedListCycle1 {
	public boolean hasCycle(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(true){
			if(fast==null || fast.next==null || slow==null){
				return false;
			}
			
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow){
				return true;
			}
		}
    }
}
