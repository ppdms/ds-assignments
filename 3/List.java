public class List {
    private Node<LargeDepositor> head = null;
    private Node<LargeDepositor> tail = null;
    public String lastname;
    public int N;

    public List() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtFront(LargeDepositor data) {
        Node<LargeDepositor> n = new Node<LargeDepositor>(data);
        ++N;

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    public void insertAtBack(LargeDepositor data) {
        Node<LargeDepositor> n = new Node<LargeDepositor>(data);
                ++N;


        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public LargeDepositor removeFromFront() throws RuntimeException {
        if (isEmpty())
            throw new RuntimeException();

        --N;

        LargeDepositor data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();

        return data;
    }

    public LargeDepositor removeFromBack() throws RuntimeException {
        if (isEmpty())
            throw new RuntimeException();

        --N;
        LargeDepositor data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            Node<LargeDepositor> iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
        }

        return data;
    }

    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node<LargeDepositor> current = head;

        StringBuilder ret = new StringBuilder();

        while (current != null) {
            ret.append(current.data.toString()+"\n");
            current = current.next;
        }

        return ret.toString();
    }
}