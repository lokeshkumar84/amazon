package com.leetcode.amazon.medium;

 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class AddTwoNumbersII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        int sum;

        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);

        while(reverseL1 != null || reverseL2 != null) {

            int x = (reverseL1 != null)?reverseL1.val:0;
            int y = (reverseL2 != null)?reverseL2.val:0;

            sum = x + y + carry;

            ListNode node = new ListNode(sum%10);
            carry = sum/10;

            temp.next = node;
            temp = node;

            reverseL1 = (reverseL1 == null)?null:reverseL1.next;
            reverseL2 = (reverseL2 == null)?null:reverseL2.next;


        }

        if(carry > 0){
            temp.next = new ListNode(carry);
        }

        return reverse(root.next);
    }

    private ListNode reverse(ListNode current){

        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        return previous;

    }
}