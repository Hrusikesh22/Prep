package collections;


import java.util.Collections;  
import java.util.Comparator;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.LinkedHashMap;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;  

public class SortHashMapByValue   
{  
	public static void main(String[] args)   
	{  
		//implementing HashMap  
		HashMap<Integer, String> hm = new HashMap<Integer, String>();  
		hm.put(6, "Tushar");  
		hm.put(12, "Ashu");  
		hm.put(5, "Zoya");  
		hm.put(78, "Yash");  
		hm.put(10, "Praveen");  
		hm.put(67, "Boby");  
		hm.put(1, "Ritesh");  
		
		System.out.println("Before Sorting:");  
		
		printMap(hm);
		
		Map<Integer, String> sortedMap = sortValues(hm);   
		
		System.out.println("\nAfter Sorting:");  
		
		printMap(sortedMap);  
	}  
	//method to sort values  
	private static Map<Integer, String> sortValues(HashMap<Integer, String> map)   
	{   
		//Convert Map to List.
		List<Entry<Integer, String>> list = new LinkedList<Entry<Integer, String>>(map.entrySet());  
		
		//Custom Comparator to sort  
		Collections.sort(list, new Comparator<Entry<Integer, String>>() {  
			
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {  
				return o1.getValue().compareTo(o2.getValue());  
			}  
		});  
		
		//Convert back from list to map.  
		Map<Integer, String> sortedHashMap = new LinkedHashMap<Integer, String>();//LL to retain sorted order.  
		for(Map.Entry<Integer, String> entry : list) {
			sortedHashMap.put(entry.getKey(), entry.getValue());  
		}   
		return sortedHashMap;  
	}  
	
	private static void printMap(Map<Integer, String> map) {
		Set<Entry<Integer, String>> set2 = map.entrySet();  
		
		Iterator<Entry<Integer, String>> iterator2 = set2.iterator();  
		while(iterator2.hasNext())   
		{  
			Map.Entry<Integer, String> me2 = (Map.Entry<Integer, String>)iterator2.next();  
			System.out.println("Roll no:  "+me2.getKey()+"     Name:   "+me2.getValue());  
		}
	}
} 