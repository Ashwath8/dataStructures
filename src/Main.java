public class Main {

    public static void main(String[] args) {
        LinkedListTest<String> linkedListTest = new LinkedListTest<String>();
        linkedListTest.addLast("First");
        linkedListTest.addLast("Second");
        linkedListTest.addFirst("Third");
        System.out.println(linkedListTest.removeLast());
        System.out.println(linkedListTest.toString());
    }
}
