package LinkedList.basic_1d;

public class first {

    public static void main(String[] args) {

        Solution s1 = new Solution();
        Node head = new Node(0);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for (int i : arr) {
            s1.insertAtEnd(head, i);
        }

        // s1.deleteAtK(head, 5);
        // System.out.println("lenght : " + s1.length(head));
        head = s1.rev(head);
        s1.printList(head);

    }

}

class Solution {

    public int length(Node head) {
        int ans = 1;
        while (head.next != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }

    // Function to insert a new node at the head
    public Node insertAtHead(Node head, int newData) {
        // Create a new node whose next points to current head
        Node newNode = new Node(newData, head);
        // Return the new node as the head
        return newNode;
    }

    public Node insertAtEnd(Node head, int newData) {
        Node n1 = head;
        // Create a new node whose next points to current head
        while (n1.next != null) {
            n1 = n1.next;
        }

        n1.next = new Node(newData);
        // Return the new node as the head
        return n1;
    }

    public Node deleteAtEnd(Node head) {
        Node n1 = head;
        // Create a new node whose next points to current head
        while (n1.next.next != null) {
            n1 = n1.next;
        }

        n1.next = null;
        return n1;

    }

    public void deleteAtK(Node head, int k) {

        int cnt = 0;
        while (cnt <= k) {
            if (cnt == k - 1) {

                head.next = head.next.next;
            }
            head = head.next;
            cnt++;
        }

    }

    public Node deleteAtBegin(Node head) {

        return head.next;

    }
    // Function to print the linked list

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node rev(Node head) {

        Node temp = null;
        Node prev = null;

        while (head != null) {
            temp = head.next;
            head.next = prev;

            prev = head;
            head = temp;
        }
        return prev;
    }
}

class Node {

    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data
    Node(int data1) {
        data = data1;
        next = null;
    }
}
