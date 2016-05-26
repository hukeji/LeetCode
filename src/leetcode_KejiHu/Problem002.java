package leetcode_KejiHu;
/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author hukeji
 * 
 * The difficult part of this problem is to find a uniform way
 * to solve a dozen of corner cases.
 * The idea is to have a while loop that stops only when both
 * lists reach the end. If only one list reaches the end,
 * set the current value to be zero and proceed as if it has the next node
 *
 */

public class Problem002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		// dummy node
		ListNode res = new ListNode(-1);
		ListNode cur = res;
		int cout = 0;
		while (cur1 != null || cur2 != null) {
			int val1 = cur1 == null ? 0 : cur1.val;
			int val2 = cur2 == null ? 0 : cur2.val;
			ListNode next = new ListNode((val1 + val2 + cout) % 10);
			cout = (val1 + val2 + cout) / 10;
			// proceed to the next in result
			cur.next = next;
			cur = next;
			// proceed to the next in list 1 and 2
			if (cur1 != null)
				cur1 = cur1.next;
			if (cur2 != null)
				cur2 = cur2.next;
		}

		if (cout != 0) {
			cur.next = new ListNode(cout);
		}

		return res.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(val);
			ListNode curr = next;
			while (curr != null) {
				sb.append("->").append(curr.val);
				curr = curr.next;
			}
			return sb.toString();
		}
	}
}
