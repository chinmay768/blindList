public class RemoveNthNodeFromEndOfList_19 {

    private class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }

    // TC: O(2n) SC: O(1)
    public ListNode removeNthFromEndNaive(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if(n == size) { // This handles the edge case of first elm delete
            head = head.next;
            return head;
        }

        int targetNodePos = size - n;

        temp = head;
        int currPos = 1;
        while (currPos < targetNodePos){
            currPos++;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    //TC: O(n) SC: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // In this our motive is to maintain gap of n bw slow and fast
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if(n == size) {
            head = head.next;
            return head;
        }

        int targetNodePos = size - n;

        temp = head;
        int currPos = 1;
        while (currPos < targetNodePos){
            currPos++;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {

    }
}

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.


Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */