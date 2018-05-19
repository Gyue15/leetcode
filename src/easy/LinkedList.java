package easy;

public class LinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;

        int count = 0;

        while (count < 3 && pointA != null && pointB != null) {
            if (pointA == pointB) {
                return pointA;
            }
            if (pointA.next == null || pointB.next == null) {
                count++;
            }
            pointA = pointA.next == null ? headB : pointA.next;
            pointB = pointB.next == null ? headA : pointB.next;
        }

        return null;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
        }

        return pre;
    }

}
