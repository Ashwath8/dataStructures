public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addFirst(3);
        for(Integer obj: singlyLinkedList) {
            System.out.println(obj);
        }
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
        doublyLinkedList.addFirst("1");
        System.out.println(doublyLinkedList);
        doublyLinkedList.addFirst("2");
        System.out.println(doublyLinkedList);
    }
}
