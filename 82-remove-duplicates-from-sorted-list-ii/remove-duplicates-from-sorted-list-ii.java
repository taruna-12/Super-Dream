class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Check if current value is duplicated
            if (curr.next != null && curr.val == curr.next.val) {

                int value = curr.val;

                // Skip all nodes with this value
                while (curr != null && curr.val == value) {
                    curr = curr.next;
                }

                prev.next = curr;

            } else {
                // Current value is unique
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}