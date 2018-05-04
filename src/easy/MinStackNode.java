package easy;

public class MinStackNode {

    private class StackNode {
        int val;
        StackNode next;
        StackNode nextInOrder;

        StackNode(int val) {
            this.val = val;
        }
    }

    private StackNode minHead;

    private StackNode head;

    private int size;

    public MinStackNode() {
        size = 0;
    }

    public void push(int x) {
        StackNode node = new StackNode(x);
        if (size == 0) {
            minHead = node;
            head = node;
        } else {
            node.next = head;
            head = node;

            StackNode insertNode = minHead;
            if (x < minHead.val) {
                node.nextInOrder = minHead;
                minHead = node;
            } else {
                while (insertNode.nextInOrder != null && insertNode.nextInOrder.val < x) {
                    insertNode = insertNode.nextInOrder;
                }
                node.nextInOrder = insertNode.nextInOrder;
                insertNode.nextInOrder = node;
            }

        }
        size++;
    }

    public void pop() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }

        StackNode node = head;
        head = head.next;

        StackNode deleteNode = minHead;
        if (deleteNode == node) {
            minHead = minHead.nextInOrder;
        } else {
            while(deleteNode.nextInOrder != null && deleteNode.nextInOrder != node) {
                deleteNode = deleteNode.nextInOrder;
            }
            if (deleteNode.nextInOrder == null) {
                throw new IllegalStateException();
            }
            deleteNode.nextInOrder = deleteNode.nextInOrder.nextInOrder;
        }

        size--;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minHead.val;
    }
}
