package exercise;

import java.util.ArrayList;
import java.util.List;

public class linkedlist {
	class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x;
		}
	}
	public static ListNode find_cycle(ListNode head)
	{
		ListNode n1 = head;
		ListNode n2 = head;
		while(n2 != null && n2.next != null)
		{
			n1 = n1.next;
			n2 = n2.next.next;
			if(n1 == n2) break;
		}
		if(n2 == null || n2.next == null) return null;
		n1 = head;
		while(n1 != n2)
		{
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	public static void test_cycle()
	{
		System.out.println("find_cycle test -------------------------------------------");
		linkedlist list = new linkedlist();
		ListNode head = list.new ListNode(0);
		ListNode p = head, node;
		for(int i = 1; i < 10; i++)
		{
			node = list.new ListNode(i);
			p.next = node;
			p = node;
		}
		p.next = head.next.next;
		p = find_cycle(head);
		if(p == null)
			System.out.println("no cycle!");
		else
		    System.out.println("the meeting point is: " + p.val);
	}
	public static ListNode createList()
	{
		linkedlist list = new linkedlist();
		ListNode head = list.new ListNode(0);
		ListNode p = head, node;
		for(int i = 1; i < 11; ++i)
		{
			node = list.new ListNode(i);
			p.next = node;
			p = p.next;
		}
		return head;
	}
	public static void print(ListNode head)
	{
		while(head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static ListNode reverse_inplace(ListNode head)
	{
		if(head == null || head.next == null) return head;
		ListNode pre, cur, next;
		pre = head;
		cur = head.next;
		while(cur != null)
		{
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head.next = null;
		return pre;
	}
	public static List<ListNode> reverse_recursive(ListNode head)
	{
		if(head == null || head.next == null)
		{
			List<ListNode> list = new ArrayList<ListNode>();
			list.add(head);
			list.add(head);
			return list;
		}
		List<ListNode> list = reverse_recursive(head.next);
		list.get(0).next = head;
		head.next = null;
		list.set(0, head);
		return list;
	}
	public static ListNode delete(ListNode head, ListNode target)
	{
		if(head == null || target == null) return head;
		if(head == target) return head.next;
		ListNode pre = head, cur = head.next;
		while(cur != null && cur != target)
		{
			pre = cur;
			cur = cur.next;
		}
		if(cur == null) return head;
		pre.next = cur.next;
		return head;
	}
	public static ListNode find_middle(ListNode head)
	{
		if(head == null || head.next == null) return head;
		ListNode pre = head, cur = head.next;
		while(cur != null)
		{
			pre = pre.next;
			cur = cur.next;
			if(cur != null)
				cur = cur.next;
		}
		return pre;
	}
	public static ListNode mergeTwoSortedList(ListNode h1, ListNode h2)
	{
		linkedlist list = new linkedlist();
		ListNode dumpy = list.new ListNode(-1), p = dumpy;
		while(h1 != null && h2 != null)
		{
			if(h1.val < h2.val)
			{
				p.next = h1;
				p = p.next;
				h1 = h1.next;
			}
			else
			{
				p.next = h2;
				p = p.next;
				h2 = h2.next;
			}
		}
		while(h1 != null)
		{
			p.next = h1;
			h1 = h1.next;
			p = p.next;
		}
		while(h2 != null)
		{
			p.next = h2;
			h2 = h2.next;
			p = p.next;
		}
		return dumpy.next;
	}
	public static ListNode removeKthFromEnd(ListNode head, int k)
	{
		ListNode p1 = head, p2 = head, pre = head;
		int i = 0;
		while(i < k && p2 != null)
		{
			++i;
			p2 = p2.next;
		}
		if(i < k)return null;
		while(p2 != null)
		{
			pre = p1;
			p2 = p2.next;
			p1 = p1.next;
		}
		if(pre == p1) return head.next;
		else
			pre.next = p1.next;
		return head;
	}
	public static void main(String[] args)
	{
		ListNode head = createList();
		
		print(head);
	}
}
