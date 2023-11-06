/**
 * ListNode represents a list node
 * Each node contains an String as data and a reference to the next node in the list.
 */
public class DoublyNode<T> {
    protected T data;
    protected DoublyNode<T> next = null;
    protected DoublyNode<T> previous = null;

    /**
     * Constructor. Sets data
     *
     * @param data the data stored
     * @return
     */
    DoublyNode(T data) {
        this.data = data;
    }

    /**
     * Returns this node's data
     *
     * @return the reference to node's data
     */
    public T getData() {
        // return data stored in this node
        return data;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public DoublyNode<T> getNext() {
        // get next node
        return next;
    }


    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setPrevious(DoublyNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public DoublyNode<T> getPrevious() {
        // get next node
        return previous;
    }


    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }
}