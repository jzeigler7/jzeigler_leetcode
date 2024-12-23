class Solution {
    public String breakPalindrome(String palindrome) {
        //find the first non-'a' character before the midpoint of the String
        //and make it an  'a'.
        //solution is not possible if there are only 'a' characters leading up to the midpoint of the string
        int length = palindrome.length();
        int halfway = length / 2;
        char[] palArr = palindrome.toCharArray();
        String answer = "";
        if (length == 1) return "";
        for (int i = 0; i < halfway; i++) {
            if (palArr[i] != 'a') {
                palArr[i] = 'a';
                for (char c : palArr) answer += c;
                return answer;
            }
        }
        for (int i = length - 1; i >= halfway; i--) {
            if (palArr[i] != 'z') {
                palArr[i] = (palArr[i] == 'a') ? 'b' : 'a';
                for (char c : palArr) answer += c;
                return answer;
            }
        }
        return "";
    }
}