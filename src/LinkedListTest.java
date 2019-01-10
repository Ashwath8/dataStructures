import java.util.ListIterator;

// Generic Implementation of a linked list
/*
    Boundary Conditions to watch out for any data structure
    1. Empty structure
    2. Single Element present in the structure
    3. Add/Remove from the beginning
    4. Add/Remove from the end
    5. Add/Remove in the middle

 */
public class LinkedListTest<E> {
    // A class that depicts the structure of a node
    // Node contains a pointer to the next node and a value
    public class Node<E> {
        Node<E> next;
        E data;

        // Constructor for the Node
        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    // Head pointer
    private Node<E> head;
    // Tail pointer
    private Node<E> tail;
    // Size of the LinkedList
    private int size;

    // Initializing the LinkedList
    public LinkedListTest() {
        head = tail = null;
        size = 0;
    }

    // Adding elements to the front of the linkedlist
    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        // If no element exists in the list
        if (size == 0) {
            node.next = head;
            head = tail = node;
            size++;
            return;
        }
        // If an element already exists in the linkedlist
        node.next = head;
        head = node;
        size++;
    }

    // Adding at the end of the linkedlist
    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);
        // If no elements exists in the linkedlist
        // head -> null <- tail
        if (size == 0) {
            head = tail = node;
            size++;
            return;
        }
        // If an elements already exists in the linkedlist
        // head -> n1 <- tail
        // the new inserted node now will point to null
        tail.next = node;
        // make the new node as the tail
        tail = node;
        size++;
        return;
    }

    // Removing the first element from the linkedlist
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            // head -> n1 <-tail
            E tmp = head.data;
            head = tail = null;
            size--;
            return tmp;
        } else {
            // head -> n1 -> n2 <- tail
            // head -> n1 -> n2 -> n3 <- tail
            E tmp = head.data;
            head = head.next;
            size--;
            return tmp;
        }
    }

    // Removing an element from the end of the linkedList
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            // head -> n1 <- tail
            E tmp = tail.data;
            head = tail = null;
            size--;
            return tmp;
        } else {
            // head -> n1 -> n2 <- tail
            // head -> n1 -> n2 -> n3 <-tail
            Node<E> curr = head;
            Node<E> prev = null;
            // Looping till we reach the tail to find the previous element
            while (curr != tail) {
                prev = curr;
                curr = curr.next;
            }
            // Setting the previous node's next pointer to null
            prev.next = null;
            // Setting the tail to the previous node
            tail = prev;
            size--;
            return curr.data;
        }
    }

    //Removing an element based on provided data
    public E remove(E obj) {
        // head -> n1 <- tail
        // head -> n1 -> n2 -> n3 <- tail
        Node<E> curr = head;
        Node<E> prev = null;
        while (curr != null) {
            if (((Comparable<E>) obj).compareTo(curr.data) == 0) {
                if (curr == head) {
                    return removeFirst();
                }
                if (curr == tail) {
                    return removeLast();
                }
                // Yowza
                prev.next = curr.next;
                size--;
                return curr.data;
            }
            // Yowza
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    // Checking to see if an element exists in the list
    public boolean contains(E obj) {
        Node<E> curr = head;
        while (curr != null) {
            if (((Comparable<E>) obj).compareTo(curr.data) == 0) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public E peekLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Empty list";
        } else if (size == 1) {
            return "head = tail = " + tail.data + " size = " + size;
        } else {
            return "head = " + head.data + " ,tail = " + tail.data + " size = " + size;
        }
    }
}