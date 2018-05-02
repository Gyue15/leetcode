package easy;

public class MergeList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode head = null;
        while (l1 != null || l2 != null) {

            if (l1 == null) {
                if (node == null) {
                    node = l2;
                    head = node;
                } else {
                    node.next = l2;
                    node = node.next;
                }
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                if (node == null) {
                    node = l1;
                    head = node;
                } else {
                    node.next = l1;
                    node = node.next;
                }
                l1 = l1.next;
                continue;
            }

            if (l1.val < l2.val) {
                if (node == null) {
                    node = l1;
                    head = node;
                }else {
                    node.next = l1;
                    node = node.next;
                }
                l1 = l1.next;
            } else {
                if (node == null) {
                    node = l2;
                    head = node;
                }else {
                    node.next = l2;
                    node = node.next;
                }
                l2 = l2.next;
            }

        }
        return head;
    }

    private static void printNode(ListNode l) {
        if (l == null) {
            System.out.println("null");
            return;
        }
        System.out.print(l.val + ", ");
        ListNode next = l;
        while ((next = next.next) != null) {
            System.out.print(next.val + ", ");
        }
        System.out.println("\b\b");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        printNode(new MergeList().mergeTwoLists(l1, l2));
    }
}
