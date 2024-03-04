/*
The peregrine falcon (Falco peregrinus) is the fastest known creature
in the animal kingdom, reaching speeds of over 387 kilometers per hour.
*/

import java.lang.reflect.Array;

public class Falcon<K, V> implements Cache<K, V> {
    private final int NULL = -1;
    private final boolean DEBUG = false;

    private class Record <K, V> {
        K key;
        V val;
        int l = NULL;
        int r = NULL;
    }

    private final Record<K, V>[] data;
    private int head = -1;
    private int tail = -1;
    
    private static int size;
    private int capacity; // how much space we have remaining
    
    private long lookups = 0;
    private long hits = 0;

    @SuppressWarnings("unchecked")
    public <thisK, thisV> Falcon(int N) {
        data = (Record<K, V>[]) Array.newInstance((new Record<thisK, thisV>()).getClass(), N);
        for (int i = 0; i < N; i++) {
            data[i] = new Record<K, V>();
        }
        size = N;
        capacity = N;
    }

    private void print() {
        System.out.println("Head: " + head);
        System.out.println("Tail: " + tail);
        for (int i = 0; i < size; i++) {
            if (data[i].key == null) {
                System.out.println("Position " + i + ": null");
            } else {
                System.out.println("Position " + i + ": Key: " + data[i].key + ", Value: " + data[i].val + ", Left: " + data[i].l + ", Right: " + data[i].r + ", Hash: " + hash(data[i].key.hashCode()));
            }
        }

    }

    private static int hash(int hash_code) { // why static
        // might be able to use memoization here
        /*
        hash_code = hash_code ^ (hash_code >> 32);
        hash_code ^= hash_code >> 16;
        hash_code ^= hash_code >> 8;
        hash_code ^= hash_code >> 4;
        hash_code ^= hash_code >> 2;
        hash_code ^= hash_code >> 1;
        */
        return hash_code % size;
    } 

    /**
	 * Look for data associated with key. 
	 * @param key the key to look for
	 * @return The associated data or null if it is not found
	 */
    @Override
	public V lookUp(K key) { 
        if (DEBUG) System.out.println("Looking up key: " + key + " with hash: " +hash(key.hashCode()));
        ++lookups;
        int startPosition = hash(key.hashCode());
        int currentPosition = startPosition;
        do {
            if (data[currentPosition].key == null) {
                if (DEBUG) System.out.println("Nothing at hash slot.");
                return null;
            }
            if (key.equals(data[currentPosition].key)) {
                removeEntry(currentPosition);
                addEntry(currentPosition);
                ++hits;
                if (DEBUG) System.out.println("Found it!");
                return data[currentPosition].val;
            }
            currentPosition = (currentPosition + 1) % size;
        } while (currentPosition != startPosition);
        if (DEBUG) System.out.println("Didn't find it anywhere.");
        return null;
    }
	
	/**
	 * Stores data with associated with the given key. If required, it evicts a
	 * data record to make room for the new one
	 * @param key the key to associate with the data
	 * @param value the actual data
	 */
    @Override
	public void store(K key, V value) {
        if (DEBUG) System.out.println("DEBUG: storing! Key to store: " + key + " has hash: " + hash(key.hashCode()) + ". Cache before store:");
        if (DEBUG) this.print();
        int pos = hash(key.hashCode());
        do {
            // If the key is found, then we update the value and the priority of the key 
            if (data[pos].key != null) {
                if (data[pos].key != null && data[pos].key.equals(key)) { // key already at data[hash]
                    data[pos].val = value;
                    // move this to tail
                    removeEntry(pos);
                    addEntry(pos);
                    if (DEBUG) System.out.println("DEBUG: storing! Cache after store:");
                    if (DEBUG) this.print();
                    return;
                }
                if (capacity == 0) {
                    int currentHead = head;
                    removeEntry(currentHead);
                    shiftKeys(currentHead);
                    ++capacity;
                    break;
                }
            } else {
                // If the position is null then the key isn't in the cache yet
                // If there is no space then we remove the key located in the head
                if (capacity == 0) {
                    removeEntry(head);
                    shiftKeys(head);
                    ++capacity;
                    break;
                } else { // We have space, so just insert it
                    data[pos].key = key;
                    data[pos].val = value;
                    addEntry(pos);
                    --capacity;
                    if (DEBUG) System.out.println("DEBUG: storing! Cache after store:");
                    if (DEBUG) this.print();
                    return;
                }
            }
            pos = (pos + 1) % size; // Wraps around the array
        } while (true);
        pos = hash(key.hashCode());
        int currentPosition = pos;
        do {
            // In case a break happens we simply search for the new empty spot
            if (data[currentPosition].key == null) {
                data[pos].key = key;
                data[pos].val = value;
                addEntry(pos);
                --capacity;
                if (DEBUG) System.out.println("DEBUG: storing! Cache after store:");
                if (DEBUG) this.print();
                return;
            }
            currentPosition = (currentPosition + 1) % size; // Wraps around the array
        } while (currentPosition != pos); // For some reason i think this is useless, since here will always be an empty position...
    }
	
	/**
	 * Returns the hit ratio, i.e. the number of times a lookup was successful divided by the number of lookup 
	 * @return the cache hit ratio
	 */
    @Override
	public double getHitRatio() {
        return (double) hits / lookups;
    }
	
	/**
	 * Returns the absolute number of cache hits, i.e. the number of times a lookup found data in the cache
	 */
    @Override
	public long getHits() {
        return hits;
    }
	
	/**
	 * Returns the absolute number of cache misses, i.e. the number of times a lookup returned null
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
     *  Helpers for store
     */
    private void removeEntry(int position) {
        if (DEBUG) System.out.println("DEBUG: removeEntry! Position is: " + position + ", cache before remove: ");
        if (DEBUG) this.print();
        // If there is another object to the left of the one to be deleted then set that one's right as the right of the selected one
        if (data[position].l >= 0) {
            data[data[position].l].r = data[position].r;
        } 
        // otherwise change the head pointer
        else { 
            head = data[position].r;
        }
        // If there is another object to the right of the one to be deleted then set that one's left as the left of the selected one
        if (data[position].r >= 0) {
            data[data[position].r].l = data[position].l;
        }
        // otherwise change the tail pointer
        else {
            tail = data[position].l;
        }

        data[position].key = null;
        if (DEBUG) System.out.println("Cache after remove: ");
        if (DEBUG) this.print();
    }

    private void addEntry(int position) {
        if (DEBUG) System.out.println("DEBUG: addEntry!");
        // Place the data back at the end (in a way updating it's priority in the cache)
        if (tail >= 0) {
            data[tail].r = position;
        }
        data[position].l = tail;
        data[position].r = NULL;
        tail = position;
        if (head < 0) {
            head = tail;
        }
    }

    private void shiftKeys(int currentPosition) {
        if (DEBUG) System.out.println("DEBUG: shifiting! Current position is: " + currentPosition);
        int freeSlot;
        int currentKeySlot;
        do {
            freeSlot = currentPosition;
            currentPosition = (currentPosition + 1) % size;
            while (true) {
                //if (DEBUG) this.print();
                //try {Thread.sleep(100);} catch (Exception e) {;}
                if (data[currentPosition].key == null) {
                    data[freeSlot].key = null;
                    return;
                }
                currentKeySlot = hash(data[currentPosition].key.hashCode());
                if (freeSlot <= currentPosition) {
                    if (freeSlot >= currentKeySlot || currentKeySlot > currentPosition) {
                        break;
                    }
                } else {
                    if (currentPosition < currentKeySlot && currentKeySlot <= freeSlot) {
                        break;
                    }
                }
                currentPosition = (currentPosition + 1) % size;
            }
            data[freeSlot].key = data[currentPosition].key;
            data[freeSlot].val = data[currentPosition].val;
            data[freeSlot].l = data[currentPosition].l;
            data[freeSlot].r = data[currentPosition].r;
            data[currentPosition].key = null;
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
