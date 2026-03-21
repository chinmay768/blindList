public class MergeTwoSortedLists_21 {

     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // TC: O(n1 + n2)  SC: O(1)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;

        ListNode t1 = list1;
        ListNode t2 = list2;

        while (t1 != null && t2 != null) {
            if(t1.val < t2.val){
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            }else{
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }

        while (t1 != null){
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;
        }

        while (t2 != null){
            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }

        return dNode.next;
    }

    public static void main(String[] args) {

    }
}

/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */