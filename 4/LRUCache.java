import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
	int capacity;
	HashMap<String, String> map;
	LinkedList<String> queue;
	private long lookups = 0;
    private long hits = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		queue = new LinkedList<>();
	}

	public String lookUp(String key) {
		++lookups;
		if (map.containsKey(key)) {
			queue.remove(new String(key));
			queue.addFirst(key);
			++hits;
			return map.get(key);
		}
		return null;
	}

	public void store(String key, String value) {
		if (map.containsKey(key)) {
			queue.remove(new String(key));
			queue.addFirst(new String(key));
			map.replace(key, value);

		} else {
			if (queue.size() == capacity) {
				map.remove(queue.pollLast());
				queue.addFirst(key);
				map.put(key, value);
			} else {
				queue.addFirst(key);
				map.put(key, value);
			}
		}
	}

	public double getHitRatio() {
        return (double) hits / lookups;
    }
	
	public long getHits() {
        return hits;
    }
	
	public long getMisses() {
        return lookups - hits;
    }

	public long getNumberOfLookUps() {
        return lookups;
    }

}