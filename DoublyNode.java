/**
 * ListNode represents a list node
 * Each node contains an String as data and a reference to the next node in the list.
 */
public class DoublyNode {
    protected String data;
    protected DoublyNode next = null;
    protected DoublyNode previous = null;

    /**
     * Constructor. Sets data
     *
     * @param data the data stored
     * @return
     */
    DoublyNode(String data) {
        this.data = data;
    }

    /**
     * Returns this node's data
     *
     * @return the reference to node's data
     */
    public String getData() {
        // return data stored in this node
        return data;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public DoublyNode getNext() {
        // get next node
        return next;
    }


    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public DoublyNode getPrevious() {
        // get next node
        return previous;
    }


    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setNext(DoublyNode next) {
        this.next = next;
    }
}