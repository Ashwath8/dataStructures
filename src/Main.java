public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
        doublyLinkedList.addFirst("1");
        doublyLinkedList.addFirst("2");
        doublyLinkedList.addLast("3");
        System.out.println(doublyLinkedList);
        doublyLinkedList.removeFirst();
        System.out.println(doublyLinkedList);
        doublyLinkedList.removeFirst();
        System.out.println(doublyLinkedList);
    }
}
