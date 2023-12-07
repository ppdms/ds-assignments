import java.util.Comparator;
import java.util.NoSuchElementException;

public class PQ {
    private int capacity = 4;
    private City heap[];
    private int ids[];
    private int size = 0;
    private Comparator<City> comparator = new PositiveComparator();

    public PQ() {
        heap = new City[capacity + 1];
        ids = new int[1000]; // ids range from 1 to 999
    }

    public PQ(int capacity) {
        heap = new City[capacity + 1];
        ids = new int[1000]; // ids range from 1 to 999
    }

    public PQ(int capacity, Comparator<City> comparator) {
        heap = new City[capacity + 1];
        ids = new int[1000]; // ids range from 1 to 999
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        capacity = capacity * 2;
        City[] newHeap = new City[capacity + 1];

        // Copy all elements from the original array
        for (int i = 1; i <= size; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public City min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        return heap[1];
    }

    public City remove(int id) {
        int index = ids[id];
        City toRemove = heap[index];
        heap[index] = heap[size];
        ids[heap[index].getID()] = index;

        size--;

        sink(index);

        return toRemove;
    }

    public City getmin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        /*
         * -> Grab the min item. It is at index 0.
         * -> Move the last item in the heap to the "top" of the
         * heap at index 0.
         * -> Reduce size.
         */
        City minItem = heap[1];
        heap[1] = heap[size];
        // Change the id array
        ids[heap[1].getID()] = 1;

        size--;

        /*
         * Restore the heap since it is very likely messed up now
         * by bubbling down the element we swapped up to index 0
         */
        sink(1);

        return minItem;
    }

    public void insert(City cityToAdd) {
        // Check for available space
        if (((float) size / capacity) * 100 >= 75)
            resize();
        /*
         * -> Place the item at the bottom, far right, of the
         * conceptual binary heap structure
         * -> Increment size
         */
        heap[++size] = cityToAdd;
        // Change the id array
        ids[heap[size].getID()] = size;
        // size++;

        /*
         * Restore the heap since it is very likely messed up now
         * by bubbling up the element we just put in the last empty
         * position of the conceptual complete binary tree
         */
        swim(size);
    }

    /*********************************
     * Heap restoration helpers
     ***********************************/

    private void sink(int i) {
        // determine left, right child
        int left = 2 * i;
        int right = left + 1;

        // if 2*i > size, node i is a leaf return
        if (left > size)
            return;

        // while haven't reached the leafs
        while (left <= size) {
            // Determine the smallest child of node i
            int min = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) == 1)
                    min = right;
            }

            // If the heap condition holds, stop. Else swap and go on.
            // child smaller than parent
            if (comparator.compare(heap[i], heap[min]) == -1)
                return;
            else {
                swapIDs(heap[i].getID(), heap[min].getID());
                swap(i, min);
                i = min;
                left = i * 2;
                right = left + 1;
            }
        }
    }

    // Bubble up the item we inserted at the "end" of the heap
    private void swim(int i) {
        // if i is root (i==1) return
        if (i == 1)
            return;

        // find parent
        int parent = i / 2;
        // System.out.println(heap);
        // System.out.println(i);
        // System.out.println(parent);
        // System.out.println(heap[parent].getName());
        // System.out.println(heap[i].getName());

        // compare parent with child i
        while (i != 1 && comparator.compare(heap[i], heap[parent]) == -1) {
            swapIDs(heap[i].getID(), heap[parent].getID());
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        City temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    private void swapIDs(int idOne, int idTwo) {
        int tempPos = ids[idOne];
        ids[idOne] = ids[idTwo];
        ids[idTwo] = tempPos;
    }
    
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.println(heap[i].getName());
        }
    }
}
