class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode cur = head;
        
        while(cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }
        
        cur = head;
        for(int i=vals.size()-1; i>=0; i--) {
            if(cur.val != vals.get(i)) return false;
            cur = cur.next;
        }
        return true;
    }
}
