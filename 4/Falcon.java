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
    
    private final int size; // how much we can fit
    private int capacity; // how much space we have remaining
    
    private long lookups = 0;
    private long hits = 0;


    public <K, V> Falcon(int N) {
        data = new Record<K, V>[N];
        size = N;
        capacity = N;
    }

    private static int hash(int hash_code) {
        // might be able to use memoization here
        hash_code = hash_code ^ (hash_code >> 32);
        hash_code ^= hash_code >> 16;
        hash_code ^= hash_code >> 8;
        hash_code ^= hash_code >> 4;
        hash_code ^= hash_code >> 2;
        hash_code ^= hash_code >> 1;
        return hash_code % N;
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
            if (data[pos].key.equals(key)) { // key already at data[hash]
                data[pos].val = value;
                // move this to tail
                return;
            } else { // key not at data[hash], so:
                if (capacity == 0) { // if no space, increase capacity by removing LRU record, then insert
                    break;
                } else { // we have space, just insert
                    return;
                }
            }
            ++pos;
        } while (true);
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

}