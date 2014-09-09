package exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class tree {
	class TreeNode
	{
		int val;
		TreeNode left,right;
		TreeNode(int x)
		{
			val = x;
		}
	}
      public static void inorder(TreeNode root)
      {
    	  if(root == null) return;
      	  TreeNode p = root;
    	  Stack<TreeNode> stack = new Stack<TreeNode>();
    	  while(!stack.isEmpty() || p != null)
    	  {
    		  while(p!= null)
    		  {
    			  stack.push(p);
    			  p = p.left;
    		  }
    		  p = stack.pop();
    		  System.out.println(p.val);
    		  p = p.right;
    	  }
      }
      public static List<List<Integer>> levelorder(TreeNode root)
      {
    	  List<List<Integer>> listlist = new ArrayList<List<Integer>>();
    	  if(null == root) return listlist;
    	  Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	  List<Integer> list;
    	  queue.add(root);
    	  while(!queue.isEmpty())
    	  {
    		  int size = queue.size();
    		  list = new ArrayList<Integer>();
    		  for(int i = 0; i < size; ++i)
    		  {
    			  TreeNode node = queue.remove();
    			  list.add(node.val);
    			  if(null != node.left) queue.add(node.left);
    			  if(null != node.right) queue.add(node.right);
    		  }
    		  listlist.add(list);
    	  }
    	  return listlist;
      }
      public static TreeNode deleteNode(TreeNode root, int key)
      {
    	  if(root == null) return null;
    	  TreeNode cur = root, parent = root;
    	  while(cur != null)
    	  {
    		  if(cur.val == key)
    			  break;
    		  else if(cur.val > key)
    		  {
    			  parent = cur;
    			  cur = cur.left;
    		  }
    		  else
    		  {
    			  parent = cur;
    			  cur = cur.right;
    		  }
    	  }
    	  if(cur == null) return root;//Ã»ÕÒµ½
    	  if(cur.left == null && cur.right == null)
    	  {
    		  if(parent.left == cur) parent.left = null;
    		  else parent.right = null;
    	  }
    	  else if(cur.left == null) 
    	  {
    		  if(parent.left == cur) parent.left = cur.right;
    		  else parent.right = cur.right;
    	  }
    	  else if(cur.right == null) 
    	  {
    		  if(parent.left == cur) parent.left = cur.left;
    		  else parent.right = cur.left;
    	  }
    	  else
    	  {
    		  TreeNode p = cur, q = cur.right;
    		  while(q.left != null)
    		  {
    			  p = q;
    			  q = q.left;
    		  }
    		  if(parent.left == cur)
    		  {
    			  if(p == cur)
    			  {
    				  parent.left = q;
    				  q.left = cur.left;
    			  }
    			  else
    			  {
    				  parent.left = q;
    				  p.left = q.right;
    				  q.left = cur.left;
    				  q.right = cur.right;
    			  }
    		  }
    		  else
    		  {
    			  if(p == cur)
    			  {
    				  parent.right = q;
    				  q.left = cur.left;
    			  }
    			  else
    			  {
    				  parent.right = q;
    				  p.left = q.right;
    				  q.left = cur.left;
    				  q.right = cur.right;
    			  } 
    		  }
    	  }
    	  return root;
      }
      public static boolean isSameTree(TreeNode p, TreeNode q)
      {
    	  if(p == null && q == null)
    		  return true;
    	  if(p == null || q == null)
    		  return false;
    	  return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      }
      public static int maxDepth(TreeNode root)
      {
    	  if(root == null) return 0;
    	  return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
      }
      public static int minDepth(TreeNode root)
      {
    	if(root == null) return 0;
    	int l = minDepth(root.left);
    	int r = minDepth(root.right);
    	if(l == 0) return r + 1;
    	if(r == 0) return l + 1;
    	return Math.min(l, r) + 1;
      }
      public static boolean isBalanced(TreeNode root)
      {
    	  return getHeight(root) == -1 ? false: true;
      }
      private static int getHeight(TreeNode root)
      {
    	  if(root == null) return 0;
    	  int l = getHeight(root.left);
    	  int r = getHeight(root.right);
    	  if(l == -1 || r == -1 || Math.abs(r - l) > 1)
    		  return -1;
    	  return Math.max(r, l)+1;
      }
      public static boolean isBST(TreeNode root)
      {
    	  return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }
      private static boolean isBST(TreeNode root, int min, int max)
      {
    	  if(root == null) return true;
    	  if(root.val > min && root.val < max)
    	  {
    		  return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    	  }
    	  else
    		  return false;
      }
      public static void main(String[] args)
      {
    	  
      }
}
