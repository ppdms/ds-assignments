
import java.io.IOException;

import javax.print.DocFlavor.STRING;


public class TestCacheSpeed {

	public static void main(String[] args) throws IOException {
		
		int cachesize = 100;
		//initialize with your cache implementation		
		Cache<String, String> cache = new Falcon<String, String>(500); // TODO: change to cachesize
		LRUCache betterCache = new LRUCache(500);

		//give path to the dat file
		String dataFile = "datasets/dataset-5000/data-5000.dat";
		
		//give path to the workload file
		String requestsFile = "datasets/dataset-5000/requests-100000.dat";

		DataSource dataSource = new DataSource(dataFile);
		WorkloadReader requestReader = new WorkloadReader(requestsFile);
		
		String key = null;		
		long numberOfRequests = 0;
		
		/*start performance test*/
		
		//track current time
		long startTime = System.currentTimeMillis();
		
		while ((key = requestReader.nextRequest()) != null) {
			System.out.println("requests " + numberOfRequests++);
			String data = (String)cache.lookUp(key);
			
			String otherData = (String)betterCache.lookUp(key);
			if (data == null && otherData != null) {
				System.out.println("Looked up key: " + key + " with hash: " + key.hashCode() % 500 + " but didn't find it. Cache is currently: " );
				((Falcon<String, String>) cache).print();
			}

			if (data == null) {//data not in cache
				data = dataSource.readItem(key);
				if (data == null) {
					throw new IllegalArgumentException("DID NOT FIND DATA WITH KEY " + key +". Have you set up files properly?");
				}else{
					cache.store(key, data);
					//System.out.println("TestCacheSpeed: storing!");
				}
			} else {//System.out.println("TestCacheSpeed: hit!");
			}
			if (otherData == null) {//data not in cache
				otherData = dataSource.readItem(key);
				if (otherData == null) {
					throw new IllegalArgumentException("DID NOT FIND DATA WITH KEY " + key +". Have you set up files properly?");
				}else{
					betterCache.store(key, data);
					//System.out.println("TestCacheSpeed: storing!");
				}
			}
		}

		/*speed test finished*/
		long duration = System.currentTimeMillis() - startTime;
		
		System.out.printf("Read %d items in %d ms\n", numberOfRequests,	duration);
		System.out.printf("Stats: lookups %d, hits %d, hit-ratio %f\n", cache.getNumberOfLookUps(), cache.getHits(), cache.getHitRatio());

		requestReader.close();
	}
}
