// 234_Palindrome_Linked_List.java
// 1ms 100% Total Accepted: 53611 Total Submissions: 184873 Difficulty: Easy
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        for (ListNode i = head; i != null; i = i.next) n++;
        if (n < 2) return true;
        
        ListNode tail = head;
        for (int i = 0; i < (n + 1) / 2; i++)
            tail = tail.next;
        for (ListNode next = tail.next; next != null; ) {
            ListNode t = next.next;
            next.next = tail;
            tail = next;
            next = t;
        }
        
        for (int i = 0; i < n / 2; i++, head = head.next, tail = tail.next)
            if (head.val != tail.val) 
                return false;
                
        return true;
    }
}
