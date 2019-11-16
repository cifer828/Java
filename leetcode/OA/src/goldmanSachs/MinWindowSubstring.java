package goldmanSachs;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
	    public String minWindow(String s, String t) {
	        if (t.length() == 0 || t.length() > s.length())   return "";
	        Map<Character, Integer> countMap = new HashMap<>();
	        Map<Character, Integer> curMap = new HashMap<>();
	        int start = 0, end;
	        int seen = 0; // current chars seen in t
	        int ansStart = 0;
	        int ansLen = Integer.MAX_VALUE;
	        // create a countMap that records char count in t
	        for (char c: t.toCharArray()){
	            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
	        }
	        int required = countMap.size();  // unique char count in t
	        for (end = 0; end < s.length(); end++){
	            char c = s.charAt(end);
	            // see a partly desired substring
	            if (countMap.containsKey(c) && seen < required) {
	                curMap.put(c, curMap.getOrDefault(c, 0) + 1);
	                // !!! Integer objects only auto-unboxing to int int range(-128, 127)
	                // so when Integer is big, we need .intValue() to convert to int
	                if (curMap.get(c).intValue() == countMap.get(c).intValue())
	                    seen++;
	            }
	            // if seeing a complete desired substring
	            // move the start pointer until it's incomplete
	            while (seen == required) {
	                char st = s.charAt(start);
	                if (countMap.containsKey(st)) {
	                    // extra start char
	                    if (curMap.get(st).intValue() >= countMap.get(st).intValue()) {
	                        curMap.put(st, curMap.getOrDefault(st, 0) - 1);
	                        if (end - start + 1 < ansLen){
	                            ansStart = start;
	                            ansLen = end - start + 1;
	                        }         
	                    }
	                    // not enough start char
	                    if (curMap.get(st).intValue() < countMap.get(st).intValue())
	                        seen--;
	                }
	                start++; 
	            }
	        }
	        return ansLen == Integer.MAX_VALUE ? "": s.substring(ansStart, ansStart + ansLen);
	    }
}
