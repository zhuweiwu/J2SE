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
 * 第一次相遇地点-->O   O
 * 距离入口长度为b   \ /
 *                   O  
 * 总长度为L
 * 环的长度为r
 * 快慢指针在相遇是所走过的路分别为s和2s
 * 2s - s = k * r
 * s = k * r, s = a + b
 * 得到 a + b = k * r = (k-1)*r + r = (k-1)*r + L-a
 * 最后有 a = (k-1)*r + (L - a - b)
 * 接着我们将慢指针从新指向头结点，快指针速度变为跟慢指针一样, 
 * 我们就可以得到当慢指针走到入口的时候，两者指针必然在入口相遇
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
