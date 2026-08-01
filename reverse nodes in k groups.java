class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        int count = 0;

        // Check if there are at least k nodes
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // Reverse first k nodes
        if (count == k) {

            current = reverseKGroup(current, k);

            while (count-- > 0) {
                ListNode next = head.next;
                head.next = current;
                current = head;
                head = next;
            }

            head = current;
        }

        return head;
    }
}
