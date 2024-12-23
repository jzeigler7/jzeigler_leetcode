class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lookup = new HashMap<Character, Integer>();
        String currSubstring = new String();
        char currChar;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            currChar = s.charAt(i);
            if (lookup.keySet().contains(currChar)) {
                if (currSubstring.length() > longest) {
                    longest = currSubstring.length();
                }
                i = lookup.get(currChar);
                lookup.clear();
                currSubstring = "";   
            } else {
                currSubstring += currChar;
                lookup.put(currChar, i);
            }
        }
        return Math.max(currSubstring.length(), longest);
    }
}