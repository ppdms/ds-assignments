/*
The peregrine falcon (Falco peregrinus) is the fastest known creature
in the animal kingdom, reaching speeds of over 387 kilometers per hour.
*/

import java.lang.reflect.Array;

public class Falcon<K, V> implements Cache<K, V> {

    private class Record<K, V> {
        K key;
        V val;
        int l = -1;
        int r = -1;
    }

    private final Record<K, V>[] data;
    private int head = -1;
    private int tail = -1;

    private static int totalCapacity; // how much space we have remaining
    private int cacheSize;
    private long lookups = 0;
    private long hits = 0;

    @SuppressWarnings("unchecked")
    public <thisK, thisV> Falcon(int N) {
        totalCapacity = (int) Math.ceil(N / 0.75);
        data = (Record<K, V>[]) Array.newInstance((new Record<thisK, thisV>()).getClass(), totalCapacity);
        for (int i = 0; i < totalCapacity; i++) {
            data[i] = new Record<K, V>();
        }
        cacheSize = N;
    }

    /**
     * Look for data associated with key.
     * 
     * @param key the key to look for
     * @return The associated data or null if it is not found
     */

    @Override
    public V lookUp(K key) {
        ++lookups;
        int startPosition = key.hashCode() % totalCapacity;
        int currentPosition = startPosition;
        do {
            if (data[currentPosition].key == null) {
                return null;
            }
            if (key.equals(data[currentPosition].key)) {
                removeEntry(currentPosition);
                addEntry(currentPosition);
                ++hits;
                return data[currentPosition].val;
            }
            currentPosition = (currentPosition + 1) % totalCapacity;
        } while (currentPosition != startPosition);
        return null;
    }

    /**
     * Stores data with associated with the given key. If required, it evicts a
     * data record to make room for the new one
     * 
     * @param key   the key to associate with the data
     * @param value the actual data
     */

    @Override
    public void store(K key, V value) {
        int pos = key.hashCode() % totalCapacity;
        if (cacheSize == 0) {
            int currentHead = head;
            removeEntry(currentHead);
            shiftKeys(currentHead);
            ++cacheSize;
            do {
                // we simply search for the new empty spot
                if (data[pos].key == null) {
                    data[pos].key = key;
                    data[pos].val = value;
                    addEntry(pos);
                    --cacheSize;
                    return;
                }
                pos = (pos + 1) % totalCapacity; // Wraps around the array
            } while (true);
        }
        do {
            if (data[pos].key != null) { // if cell isn't empty
                if (data[pos].key.equals(key)) { // if key already at data[hash]
                    data[pos].val = value; // we update the value
                    removeEntry(pos); // move it to tail, updating priority
                    addEntry(pos);
                    return;
                }
            } else {
                // If the position is null then the key isn't in the cache yet
                // We have space, so just insert it
                data[pos].key = key;
                data[pos].val = value;
                addEntry(pos);
                --cacheSize;
                return;
            }
            pos = (pos + 1) % totalCapacity; // Wraps around the array
        } while (true);
    }

    /**
     * Returns the hit ratio, i.e. the number of times a lookup was successful
     * divided by the number of lookup
     * 
     * @return the cache hit ratio
     */
    @Override
    public double getHitRatio() {
        return (double) hits / lookups;
    }

    /**
     * Returns the absolute number of cache hits, i.e. the number of times a lookup
     * found data in the cache
     */
    @Override
    public long getHits() {
        return hits;
    }

    /**
     * Returns the absolute number of cache misses, i.e. the number of times a
     * lookup returned null
     */
    @Override
    public long getMisses() {
        return lookups - hits;
    }

    /**
     * Returns the total number of lookups performed by this cache
     */
    @Override
    public long getNumberOfLookUps() {
        return lookups;
    }

    /*
     * Helpers for store
     */
    private void removeEntry(int position) {
        // If there is another object to the left of the one to be deleted then set that
        // one's right as the right of the selected one
        if (data[position].l >= 0) {
            data[data[position].l].r = data[position].r;
        }
        // otherwise change the head pointer
        else {
            head = data[position].r;
        }
        // If there is another object to the right of the one to be deleted then set
        // that one's left as the left of the selected one
        if (data[position].r >= 0) {
            data[data[position].r].l = data[position].l;
        }
        // otherwise change the tail pointer
        else {
            tail = data[position].l;
        }
    }

    private void addEntry(int position) {
        // Place the data back at the end (in a way updating it's priority in the cache)
        if (tail >= 0) {
            data[tail].r = position;
        }
        data[position].l = tail;
        data[position].r = -1;
        tail = position;
        if (head < 0) {
            head = tail;
        }
    }

    private void shiftKeys(int currentPosition) {
        int freeSlot;
        int currentKeySlot;
        do {
            freeSlot = currentPosition;
            currentPosition = (currentPosition + 1) % totalCapacity;
            while (true) {
                if (data[currentPosition].key == null) {
                    data[freeSlot].key = null;
                    return;
                }
                currentKeySlot = data[currentPosition].key.hashCode() % totalCapacity;
                if (freeSlot <= currentPosition) {
                    if (freeSlot >= currentKeySlot || currentKeySlot > currentPosition) {
                        break;
                    }
                } else {
                    if (currentPosition < currentKeySlot && currentKeySlot <= freeSlot) {
                        break;
                    }
                }
                currentPosition = (currentPosition + 1) % totalCapacity;
            }
            data[freeSlot].key = data[currentPosition].key;
            data[freeSlot].val = data[currentPosition].val;
            data[freeSlot].l = data[currentPosition].l;
            data[freeSlot].r = data[currentPosition].r;
            if (data[currentPosition].l >= 0) {
                data[data[currentPosition].l].r = freeSlot;
                if (currentPosition == tail) {
                    tail = freeSlot;
                }
            }
            if (data[currentPosition].r >= 0) {
                data[data[currentPosition].r].l = freeSlot;
                if (currentPosition == head) {
                    head = freeSlot;
                }
            }
        } while (true);
    }
}
