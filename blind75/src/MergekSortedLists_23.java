import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists_23 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Naive Store all the nodes in an array then sort it and then convert it into LL


    // Better
    // (N1 + N2) + (n1 + n2 + n3) + (n1 + n2 + n3 + n4)
    // N + (2N + 3N + 4N)
    // N (1 + 2 + 3 + --- + K)
    // TC: n * (k * (k + 1) / 2)
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode temp = lists[0];

        for (int i = 1; i < lists.length; i++){
            ListNode currList = lists[i];

            temp = mergeLists(temp, currList);
        }

        return temp;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;

        ListNode dNode = new ListNode(-1, null);
        ListNode temp = dNode;

        while (t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                temp.next = t1;
                t1 = t1.next;
            }else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
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

    private static class ListHeap {
        int val;
        ListNode node;

        ListHeap(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int getVal(){
            return val;
        }
    }

    public static ListNode mergeKListsOptimal(ListNode[] lists) {
        PriorityQueue<ListHeap> pq = new PriorityQueue<>(Comparator.comparingInt(ListHeap::getVal));

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null){
                pq.add(new ListHeap(temp.val, temp));
                temp = temp.next;
            }
        }

        ListNode dNode  = new ListNode();
        ListNode temp = dNode;

        while (!pq.isEmpty()) {
            temp.next = pq.poll().node;
            temp = temp.next;
        }
        temp.next = null;

        return dNode.next;
    }

    public static void main(String[] args) {

    }
}

/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */
