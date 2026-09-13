class Solution {

    ArrayList<Integer> values = new ArrayList<>();

    public Solution(ListNode head) {

        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
    }

    public int getRandom() {

        Random random = new Random();

        int index = random.nextInt(values.size());

        return values.get(index);
    }
}