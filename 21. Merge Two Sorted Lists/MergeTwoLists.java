class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode merged = dummy;
        
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                merged.next = list1;
                list1 = list1.next;
                merged = merged.next;                
            } else {
                merged.next = list2;
                list2 = list2.next;
                merged = merged.next;
            }
        }
        if(list1 != null) {
            merged.next = list1;
        }
        if(list2 != null) {
            merged.next = list2;
        }
        return dummy.next;
    }
}
