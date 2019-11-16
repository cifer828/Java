package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringOfSizeK {
    public static List<String> kSubstring(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        Set<String> result = new HashSet<>();
        int left = 0, right = 0;
        int distinct = 0;
        
        for (; right < s.length(); right++) {
        	char c = s.charAt(right);
        	// when window size is fixed as k
            if (right - left + 1 > k) {
            	char leftChar = s.charAt(left);
            	window.put(leftChar, window.get(leftChar) - 1);
            	if (window.get(leftChar) == 0) 
            		distinct--;
            	left++;
            }
            // right char may or may not add the distinct char
        	if (!window.containsKey(c) || window.get(c) == 0) {
        		window.put(c, 1);
        		distinct++;
        	}
        	else {
        		window.put(c, window.get(c) + 1);
        	}
        	// save the substring if its length == distinct == k
        	if (right - left + 1 == k && distinct == k) {
        		result.add(s.substring(left, right + 1));
        	}
        }
        return new ArrayList<>(result);
    }
    
    public static void main(String[] args) {
        System.out.println(kSubstring("awaglknagawunagwkwagl", 4));
    }
}
