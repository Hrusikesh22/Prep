package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ConvertMapToSortedMap {
	public static void main(String[] str) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		for(int i = 1; i<=10; i++)
			map.put("key"+i, "value"+i);
		
		System.out.println("Map (unsorted) - " + map);
		
		map = new TreeMap<>(map);
		
		System.out.println("Map (Sorted) - " + map);

		System.out.println("Map (unsorted) - " + map);
	}
}
