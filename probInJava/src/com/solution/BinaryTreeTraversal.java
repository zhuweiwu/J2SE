package com.solution;
import java.util.ArrayList;
import java.util.Stack;

import com.basicclass.TreeNode;

/**
 *                  5
 *               /     \
 *              3       7
 *             / \     / \
 *            2   4   6   8
 *   return£º  
 *    postorder£º 2 ¡ª¡ª 4 ¡ª¡ª 3 ¡ª¡ª 6 ¡ª¡ª 8 ¡ª¡ª 7 ¡ª¡ª 5 (Left-->Right-->Root)
 *    preorder£º   5 ¡ª¡ª 3 ¡ª¡ª 7 ¡ª¡ª 2 ¡ª¡ª 4 ¡ª¡ª 6 ¡ª¡ª 8 (Root-->Left-->Right)
 *            
 * @author AD
 * 2014-2-27
 */
public class BinaryTreeTraversal {
	public ArrayList<Integer> postorderTraveral(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(root);
		while(!s1.isEmpty()){
			TreeNode curNode = s1.pop();
			s2.push(curNode);
			if(curNode.left != null){
				s1.push(curNode.left);
			}
			if(curNode.right != null){
				s1.push(curNode.right);
			}
		}
		while(!s2.isEmpty()){
			result.add(s2.pop().val);
		}
		
		return result;
	}
	
	public ArrayList<Integer> preorderTraveral(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			result.add(curNode.val);
			if(curNode.right != null){
				stack.push(curNode.right);
			}
			if(curNode.left != null){
				stack.push(curNode.left);
			}
		}

		return result;
	}
}