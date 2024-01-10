private class Node<K> {
    protected K data;
    protected Node<K> next = null;

    Node(K data) {
        this.data = data;
    }

    public K getData() {
        return data;
    }

    public Node<K> getNext() {
        // get next node
        return next;
    }

    public void setNext(Node<K> next) {
        this.next = next;
    }
}
