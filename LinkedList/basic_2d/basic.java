package LinkedList.basic_2d;

public class basic {

    public static void main(String[] args) {
        Solution s1 = new Solution();

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        Node head = s1.convertToDLL(arr);

        // head = s1.deleteAtK(head, 1);
        // s1.deleteNode(head.next.next);
        // s1.insertAtH(head, -1);
        // s1.insertAtK(head, 111, 1);
        head = s1.reverseDLL(head);
        s1.printList(head);

        // s1.deleteAtK(head, 5);
        // System.out.println("lenght : " + s1.length(head));
        // s1.printList(head);
    }

}

class Solution {

    public void deleteNode(Node temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.prev = null;
        temp.next = null;

    }

    public Node insertAtK(Node head, int data, int k) {
        Node temp = head;
        int cnt = 1;
        while (cnt <= k) {
            temp = temp.next;
            cnt++;
        }

        Node n = new Node(data, temp, temp.prev);

        temp.prev.next = n;
        temp.next.prev = n;

        return head;

    }

    public Node insertAtH(Node head, int data) {
        // Node temp = head;
        Node n = new Node(data);
        n.next = head;
        head.prev = n;

        return n;
    }

    public Node deleteAtK(Node head, int i) {

        if (head.prev == null && head.next == null) {
            return null;
        } else if (i == 0) {
            return deleteAtH(head);
        } else if (i == length(head)) {
            return deleteAtT(head);
        } else {
            Node temp = head;
            int cnt = 1;
            while (cnt <= i) {
                temp = temp.next;
                cnt++;
            }

            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            temp.prev = null;
            temp.next = null;

        }
        return head;
    }

    public int length(Node head) {
        int ans = 1;
        while (head.next != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }

    public Node deleteAtH(Node head) {

        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    public Node deleteAtT(Node head) {

        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {

            tail = tail.next;
        }

        Node prev = tail.prev;

        tail.prev = null;
        prev.next = null;

        return head;
    }

    public Node insertAtEnd(int data, Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data, temp);
        return head;

    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node convertToDLL(int[] arr) {
        Node head = new Node(arr[0]);

        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], prev);
            prev.next = temp;
            prev = temp;

        }
        return head;

    }

    public Node reverseDLL(Node head) {

        Node currunt = head;
        Node last = null;
        while (currunt != null) {
            last = currunt;
            Node prev = currunt.next;
            currunt.next = currunt.prev;
            currunt.prev = prev;
            currunt = currunt.prev;
        }

        return last;

    }

}

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;

    }

    Node(int data1, Node prev1) {
        data = data1;
        next = null;
        prev = prev1;
    }

    // Constructor with only data
    Node(int data1) {
        data = data1;
        next = null;
        prev = null;
    }
}
