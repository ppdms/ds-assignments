import java.util.Comparator;
import java.util.NoSuchElementException;

public class PQ {
    public int capacity = 4; // I have removed the resizing ability, since we only use it in a use case that doesn't need it, and it helped me solve the problem more easily. It will not work properly if you set the capacity less than the maximum size you want the PQ to attain, so make sure to set the capacity correctly.
    private LargeDepositor heap[];
    private int size = 0;
    private Comparator<LargeDepositor> comparator = new PositiveComparator();

    public PQ() {
        heap = new LargeDepositor[capacity + 1];
    }

    public PQ(int capacity) {
        this.capacity = capacity;
        heap = new LargeDepositor[capacity + 1];
    }

    public PQ(int capacity, Comparator<LargeDepositor> comparator) {
        heap = new LargeDepositor[capacity + 1];
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public LargeDepositor min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        return heap[1];
    }

    public LargeDepositor getmin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        /*
         * -> Grab the min item. It is at index 0.
         * -> Move the last item in the heap to the "top" of the
         * heap at index 0.
         * -> Reduce size.
         */
        LargeDepositor minItem = heap[1];
        heap[1] = heap[size];

        size--;

        /*
         * Restore the heap since it is very likely messed up now
         * by bubbling down the element we swapped up to index 0
         */
        sink(1);

        return minItem;
    }

    public void insert(LargeDepositor LargeDepositorToAdd) {
        /*
         * -> Place the item at the bottom, far right, of the
         * conceptual binary heap structure
         * -> Increment size
         */
        heap[++size] = LargeDepositorToAdd;
        // size++;

        /*
         * Restore the heap since it is very likely messed up now
         * by bubbling up the element we just put in the last empty
         * position of the conceptual complete binary tree
         */
        swim(size);
    }

     // Restoration helpers
     
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
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        LargeDepositor temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }
    
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.println(heap[i]);
        }
    }
}
