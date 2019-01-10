import java.util.Iterator;

public class DoublyLinkedList<E> implements Iterable<E> {

    Node<E> head;
    Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper();
    }

    class IteratorHelper<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E obj) {
            data = obj;
            next = prev = null;
        }
    }

    public void addFirst(E obj) {
        Node<E> newNode = new Node<E>(obj);
        // If there is an empty list
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        // If an element already exists
        Node<E> tmp = head;
        // Setting the newNode as the previous node for the already existing element
        tmp.prev = newNode;
        // Setting the next element reference for the newNode
        newNode.next = head;
        // Setting the newNode as the head
        head = newNode;
        size++;
    }

    public void addLast(E obj) {
        Node<E> newNode = new Node<E>(obj);
        // If there is an empty list
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        // If an element already exists in the list
        Node<E> tmp = tail;
        // setting the next reference for the current tail element
        tmp.next = newNode;
        // setting the previous reference for the new incoming element
        newNode.prev = tmp;
        // setting the tail to point to the new element
        tail = newNode;
        size++;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Empty list";
        } else if (size == 1) {
            return "head = tail = " + head.data;
        } else {
            return "head = " + head.data + " tail = " + tail.data;
        }
    }
}

