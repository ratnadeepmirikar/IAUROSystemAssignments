package com.code2;

/*Q2. You are a software developer at a logistics company. Your company maintains a system to track packages as they move through different stages of delivery. Each package's journey is represented as a linked list, 
where each node contains information about a stage in the delivery process. Recently, some packages have been reported to be stuck in an infinite loop in the tracking system, causing delays and confusion. To prevent this, you 
need to implement a function to detect any structural issues in the package 
tracking system.
Problem Statement:
Given the head of a linked list representing the stages of a package's journey, you need to determine if there is a structural issue causing an infinite loop.
Example 1:
Input :
head = [20,30,40,60,80]
Output :
true
Explanation: There is a cycle in the linked list where the tail connects to the 
3rd node.
Example 2:
Input:
head = [6,4,2,8]
Output:
false
Explanation: The linked do not have a cycle.
Note: You need to write the required function for this problem, and you 
Must take the head of the linked list as input parameter to the function.
Answer:*/
class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class PackageTrackingSystem {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           
            fast = fast.next.next;      

            if (slow == fast) {        
                return true;
            }
        }

        return false;                 
    }

    public static void main(String[] args) {
        
        ListNode head1 = new ListNode(20);
        head1.next = new ListNode(30);
        head1.next.next = new ListNode(40);
        head1.next.next.next = new ListNode(60);
        head1.next.next.next.next = new ListNode(80);
        head1.next.next.next.next.next = head1.next.next; 

        System.out.println(hasCycle(head1)); 

        
        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(8);

        System.out.println( hasCycle(head2));
    }
}

