class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int subStart, subEnd;
        char[] inputArr = s.toCharArray();
        for (int i = s.length() - 1; i > 0; i--) {
            subStart = 0;
            subEnd = i;
            while (subEnd < s.length()) {
                if (isPalin(inputArr, subStart, subEnd)) {
                    return createSubstring(inputArr, subStart, subEnd);
                }
                subStart++;
                subEnd++;
            }
        }
        String toReturn = "";
        toReturn += inputArr[0];
        return toReturn;
    }
    public boolean isPalin(char[] inputArr, int subStart, int subEnd) {
        if (subStart == subEnd) {
            return true;
        }
        while (inputArr[subStart] == inputArr[subEnd]) {
            subStart++;
            subEnd--;
            if (subStart > subEnd) {
                return true;
            }
        }
        return false;
    }

    public String createSubstring(char[] inputArr, int subStart, int subEnd) {
        String toReturn = "";
        for (int i = subStart; i <= subEnd; i++) {
            toReturn += inputArr[i];
        }
        return toReturn;
    }
}