/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // if(l1 == null){
        //     return l2;
        // }
        // if(l2 == null){
        //     return l1;
        // }
        
        ListNode mergedList = new ListNode();
        // if(l1.val < l2.val){
        //      mergedList = l1;
        //     l1 = l1.next;
        // }
        // else{
        //     mergedList = l2;
        //     l2 = l2.next;
        // }
        
        ListNode head = mergedList;
        
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    mergedList.next = l1;
                    l1 = l1.next;
                }
                else{
                    mergedList.next = l2;
                    l2 = l2.next;
                }
            }
            else{
                if(l1 != null){
                    mergedList.next = l1;
                    l1 = l1.next;
                }
                else{
                    mergedList.next = l2;
                    l2 = l2.next;
                }
            }
            mergedList = mergedList.next;
        }
        
        //return head;
        return head.next;
    }
}
