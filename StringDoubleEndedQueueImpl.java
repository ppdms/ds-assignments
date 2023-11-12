import java.io.PrintStream;
import java.util.NoSuchElementException;


class StringDoubleEndedQueueImpl<T> implements StringDoubleEndedQueue<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(T item) {
        Node<T> n = new Node<T>(item);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head.setPrevious(n); 
            head = n;
        }
        // Changing the size accordingly
        size += 1;
    }

    @Override
    public T removeFirst() throws NoSuchElementException{
        if (isEmpty()) throw new NoSuchElementException("The list is empty...");

        T data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();
            head.setPrevious(null);
        // Changing the size accordingly
        size -= 1;

        return data;
    }

    @Override
    public void addLast(T item) {
        Node<T> n = new Node<T>(item);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            n.setPrevious(tail);
            tail = n;
        }    
        // Changing the size accordingly
        size += 1;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("The list is empty...");

        T data = tail.getData();
        Node<T> prev_to_tail = tail.getPrevious();

        if (head == tail)
            head = tail = null;
        else {
            prev_to_tail.setNext(null);
            tail = prev_to_tail;
        }
        // Changing the size accordingly
        size -= 1;

        return data;    
    }

    @Override
    public T getFirst() {
        return head.getData();
    }

    @Override
    public T getLast() {
        return tail.getData();    
    }

    @Override
    public void printQueue(PrintStream stream) {
        if (isEmpty()) {
            System.out.println("The list is empty...");
        }
        else{
            Node<T> current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append(" HEAD -> ");

        while (current != null) {
            ret.append(current.data);

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");

        System.out.println(ret.toString());
        }
    }

    @Override
    public int size() {
        return size;    
    }

}