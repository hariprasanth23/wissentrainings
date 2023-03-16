package com.leetcode.twopointer;



public class PartitionLinkedList {

    ListNode head;

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public void push(int new_data)
    {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList()
    {
        ListNode tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.val+" ");
            tnode = tnode.next;
        }
    }

    public ListNode partition(int x) {

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode leftTail = left;
        ListNode rightTail = right;

        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }
            else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;

        return left.next;
    }

    public static void main(String[] args){

        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();
        partitionLinkedList.push(1);
        partitionLinkedList.push(4);
        partitionLinkedList.push(3);
        partitionLinkedList.push(2);
        partitionLinkedList.push(5);
        partitionLinkedList.push(2);

        partitionLinkedList.partition(3);

        partitionLinkedList.printList();


    }
}
