package ds_n_algo.sorting.misc;

import java.util.Arrays;
import java.util.Comparator;

public class AlphanumericSorting implements Comparator<Object> {

	public int compare(Object firstObjToCompare, Object secondObjToCompare) {
    
		String firstString = removePadding(firstObjToCompare.toString());
        String secondString = removePadding(secondObjToCompare.toString());
 
        if (secondString == null || firstString == null) {
            return 0;
        }
 
        int lengthFirstStr = firstString.length();
        int lengthSecondStr = secondString.length();
 
        int index1 = 0;
        int index2 = 0;
 
        while (index1 < lengthFirstStr && index2 < lengthSecondStr) {
            char ch1 = firstString.charAt(index1);
            char ch2 = secondString.charAt(index2);
 
            char[] space1 = new char[lengthFirstStr];
            char[] space2 = new char[lengthSecondStr];
 
            int loc1 = 0;
            int loc2 = 0;
 
            do {
                space1[loc1++] = ch1;
                index1++;
 
                if (index1 < lengthFirstStr) {
                    ch1 = firstString.charAt(index1);
                } else {
                    break;
                }
            } while (Character.isDigit(ch1) == Character.isDigit(space1[0]));
 
            do {
                space2[loc2++] = ch2;
                index2++;
 
                if (index2 < lengthSecondStr) {
                    ch2 = secondString.charAt(index2);
                } else {
                    break;
                }
            } while (Character.isDigit(ch2) == Character.isDigit(space2[0]));
 
            String str1 = new String(space1);
            String str2 = new String(space2);
 
            int result;
            
            System.out.println("str1  - " + str1 + ", str1  - " + str2);
 
            if (Character.isDigit(space1[0]) && Character.isDigit(space2[0])) {
                Integer firstNumberToCompare = new Integer(Integer.parseInt(str1.trim()));
                Integer secondNumberToCompare = new Integer(Integer.parseInt(str2.trim()));
                result = firstNumberToCompare.compareTo(secondNumberToCompare);
            } else {
                result = str1.compareTo(str2);
            }
 
            if (result != 0) {
                return result;
            }
        }
        return lengthFirstStr - lengthSecondStr;
    }
 
    /**
     * @param string I/P
     * @return after removes padded zeros, if present. Else I/P String
     */
    private String removePadding(String string) {
        String result="";
        try{
            result+= Integer.parseInt(string.trim());
        } catch (Exception e) {
            result= string;
        }
        return result;
    }
 
    /**
     * Testing the alphanumeric sorting
     */
    public static void main(String[] args) {
        
    	String[] alphaNumericStringArray = {"1NUM10071", "1NUM9999", "9997", "9998", "9996", "9996F", "00010", "01", "1", "001"};
 
        Arrays.sort(alphaNumericStringArray, new AlphanumericSorting());
 
        for (String arrElem : alphaNumericStringArray) {
            System.out.println(arrElem);
        }
 
    }
 
}
