public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addFirst(3);
        for(Integer obj: singlyLinkedList) {
            System.out.println(obj);
        }
    }
}
