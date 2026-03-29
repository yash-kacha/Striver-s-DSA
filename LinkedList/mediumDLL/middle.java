package LinkedList.mediumDLL;

public class middle {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Node n = new Node(0);
        Node head = n.convertToDLL(arr);

        System.out.println(middleNode(head).data);
        n.printList(head);
    }

    public static Node middleNode(Node head) {

        Node mid = head;
        while (head != null && head.next != null) {

            head = head.next.next;

            mid = mid.next;
        }
        return mid;
    }
}
