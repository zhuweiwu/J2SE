package com.solution;
import com.basicclass.ListNode;

public class InsertionSortList2 {
	public ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null) 
			return head;
		
		ListNode curNode = head;
		ListNode nextNode = head.next;
		while(curNode != null && nextNode != null){
			if(curNode.val <= nextNode.val){
				curNode = nextNode;
				nextNode = nextNode.next;
			}else {
				ListNode searchHead = head;
				if(head.val >= nextNode.val){
					ListNode temp = nextNode.next;
					curNode.next = temp;
					nextNode.next = head;
					head = nextNode;
					nextNode = temp;
				}else {
					while(searchHead.val <= nextNode.val && searchHead.next.val <= nextNode.val){
						searchHead = searchHead.next;
					}
					if(searchHead.val <= nextNode.val && nextNode.val <= searchHead.next.val){
						ListNode temp = nextNode.next;
						curNode.next = temp;
						nextNode.next = searchHead.next;
						searchHead.next = nextNode;
						curNode = temp;
					}
				}
			}
		}
		return head;
	}
}
