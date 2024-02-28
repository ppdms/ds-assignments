/*
The peregrine falcon (Falco peregrinus) is the fastest known creature
in the animal kingdom, reaching speeds of over 240 miles per hour.
*/

public class Falcon<K, V> implements Cache<K, V> {
    private class Record<K, V> { // using this like a struct
        K key;
        V val;
        int l = -1;
        int r = -1;
    }

    private final Record<K, V>[] data;
    private int head = -1;
    private int tail = -1;
    
    private static final int SIZE = 0; // ?
    private int capacity; // how much space we have remaining
    
    private long lookups = 0;
    private long hits = 0;

    private final int NUL = -1; 

    @SuppressWarnings("unchecked")
    public <K, V> Falcon(int N) {
        data = new Record<K, V>[N]; // this is causing a shit ton of problems TODO
        SIZE = N;
        capacity = N;
    }

    private static int hash(int hash_code) { // why static
        // might be able to use memoization here
        hash_code = hash_code ^ (hash_code >> 32);
        hash_code ^= hash_code >> 16;
        hash_code ^= hash_code >> 8;
        hash_code ^= hash_code >> 4;
        hash_code ^= hash_code >> 2;
        hash_code ^= hash_code >> 1;
        return hash_code % SIZE;
    } 

    /**
	 * Look for data associated with key. 
	 * @param key the key to look for
	 * @return The associated data or null if it is not found
	 */
    @Override
	public V lookUp(K key) {
        ++lookups;
        if (data[hash(key.hashCode())].key.equals(key)) {
            ++hits;
            return data[hash(key.hashCode())].val;
        } else {
            return null;
        }
    }
	
	/**
	 * Stores data with associated with the given key. If required, it evicts a
	 * data record to make room for the new one
	 * @param key the key to associate with the data
	 * @param value the actual data
	 */
    @Override
	public void store(K key, V value) {
        int pos = hash(key.hashCode());
        do {
            // If the key is found, then we update the he value and the priority of the key 
            if (data[pos].key.equals(key)) { // key already at data[hash]
                data[pos].val = value;
                // move this to tail
                removeEntry(pos);
                addEntry(pos);
                return;
            } 
            // If the position is null then the key isn't in the cache yet
            if (data[pos] == null) {
                // If there is no space then we remove the key located in the head
                if (capacity == 0) {
                    removeEntry(head);
                    //shiftKeys(head);
                    ++capacity;
                    break;
                } 
                // We have space, so just insert it
                else {
                    data[pos] = new Record<K, V>();
                    addEntry(pos);
                    --capacity;
                    return;
                }
            }
            ++pos; // Change so that it wrappes around if it exceeds the limit TODO
        } while (true);
        pos = hash(key.hashCode());
        int currentPosition = pos;
        do {
            // In case a break happens we simply search for the new empty spot
            if (data[currentPosition] == null) {
                data[pos] = new Record<K, V>();
                addEntry(pos);
                --capacity;
                return;
            }
            ++currentPosition; // Change so that it wrappes around if it exceeds the limit TODO
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
    }

    private void addEntry(int position) {
        // Place the data back at the end (in a way updating it's priority in the cache)
        if (tail >= 0) {
            data[tail].r = position;
        }
        data[position].l = tail;
        data[position].r = NUL;
        tail = position;
        if (head < 0) {
            head = tail;
        }
    }



}
