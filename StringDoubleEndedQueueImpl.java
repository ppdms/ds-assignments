import java.io.PrintStream;
import java.util.NoSuchElementException;


class StringDoubleEndedQueueImpl<T> implements StringDoubleEndedQueue<T>{
    DoublyNode<T> head = null;
    DoublyNode<T> tail = null;
    int size = 0;
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(T item) {
        DoublyNode<T> n = new DoublyNode<T>(item);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
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
        // Changing the size accordingly
        size -= 1;

        return data;
    }

    @Override
    public void addLast(T item) {
        DoublyNode<T> n = new DoublyNode<T>(item);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }    
        // Changing the size accordingly
        size += 1;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("The list is empty...");

        T data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            DoublyNode<T> iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
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
            DoublyNode<T> current = head;

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