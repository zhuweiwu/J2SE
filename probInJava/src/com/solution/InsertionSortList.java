package com.solution;
import com.basicclass.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode curNode = head.next;
		while(curNode != null){
			ListNode temp = head;
			while(temp.val <curNode.val && temp != curNode){
				temp = temp.next;
			}
			if(temp != curNode){
				while(temp != curNode){
					int tempValue = temp.val;
					temp.val = curNode.val;
					curNode.val = tempValue;
					temp = temp.next;
				}
			}
			
			curNode = curNode.next;
		}
		
		return head;
	}
}
