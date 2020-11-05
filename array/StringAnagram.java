package array;

import java.util.HashMap;
import java.util.Map;

public class StringAnagram {

	public static void main(String[] args) {
		System.out.println("isAnagram : " + isAnagram("abcd", "acbd"));
		System.out.println("isAnagram : " + isAnagram("taste", "etsat"));
	}
	
	static boolean isAnagram(String str1, String str2) {

		if(str1 != null && str2 != null) {
			if(str1.length() != str2.length())
				return false;

			Map<Character, Integer> map = new HashMap<>();

			//Iterate str1 and add to map <char-count>
			for(int i = 0; i < str1.length(); i++) {
				char charAtI = str1.charAt(i);
				if(map.containsKey(charAtI)) 
					map.put(charAtI, map.get(charAtI)+1);
				else
					map.put(charAtI, 1);
			}

			//Iterate str2 and reduce count if already present until 0. Else return false if not present.
			for(int i = 0; i < str2.length(); i++) {
				char charAtI = str2.charAt(i);
				if(!map.containsKey(charAtI))
					return false;

				if(map.get(charAtI)==0)
					return false;

				map.put(charAtI, map.get(charAtI)-1);
			}
			
			return true;
		}
		return false;
	}
	
}
