
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
    	System.out.printf("%s\t%s\n", s, p);
        boolean matched = true;
        int shift = 0;
        int sLen = s.length(), pLen = p.length();
        char cur;
        if (pLen == 0) return sLen == 0; // p="", s ="abc" or " "
        if (p.charAt(0) == '.')  cur = sLen > 0 ? s.charAt(0) : ' ' ; // p=".xxx", s="abc" or " "
        else cur = p.charAt(0); // p="xxx", s="abc" or " ";
        if (pLen > 1 && p.charAt(1) == '*') { // p="[]*", s="abc" or " "
            while (sLen > shift && s.charAt(shift) == cur)
                shift++;
            return isMatch(s.substring(shift), p.substring(2));
        }
        else {
            matched = (sLen > 0 && s.charAt(0) == cur);
            return matched && isMatch(s.substring(1), p.substring(1));
        }
    }
    public static void main(String[] args) {
    	isMatch("aaa", "ab*ac*a");
    }
}
