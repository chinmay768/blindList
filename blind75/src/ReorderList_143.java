import java.util.ArrayList;
import java.util.List;

public class ReorderList_143 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    // Naive Approach
    // TC: O(n + n)  SC: O(n)
    public void reorderList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();

        ListNode temp = head;
        while (temp != null){
            nodeList.add(temp);
            temp = temp.next;
        }

        int start = 0;
        int end = nodeList.size() - 1;

        while (start <= end) {
            if(temp != null){
                temp.next = nodeList.get(start);
            }
            nodeList.get(start).next = nodeList.get(end);

            nodeList.get(end).next = null;
            temp = nodeList.get(end);
            start++;
            end--;
        }
    }

    // Optimal Approach
    public void reorderListOptimal(ListNode head) {
        if (head == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;
        slow.next = null;
        ListNode node = null;

        while (second != null) {
            ListNode temp = second.next;
            second.next = node;
            node = second;
            second = temp;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        second = node;

        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }

    // Naive Approach 2
    public void reorderListNaive(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();

        ListNode temp = head;
        while (temp != null){
            nodeList.add(temp);
            temp = temp.next;
        }

        int start = 0;
        int end = nodeList.size() - 1;

        while (start < end) {
            nodeList.get(start).next = nodeList.get(end);

            start++;

            nodeList.get(end).next = nodeList.get(start);

            end--;
        }

        nodeList.get(start).next = null; // For middle two nodes the last node wil point to itself and to handle that case
    }

    public static void main(String[] args) {

    }
}

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */