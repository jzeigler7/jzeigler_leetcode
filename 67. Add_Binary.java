class Solution {
    public String addBinary(String a, String b) {
        int place = 0;
        String answer = "";
        boolean carry = false;
        int curr;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            curr = 0;
            if ((i < a.length()) && (a.charAt(a.length() - i - 1) == '1')) {
                curr++;
            }
            if ((i < b.length()) && (b.charAt(b.length() - i - 1) == '1')) {
                curr++;
            }
            if (carry) {
                curr++;
            }
            carry = curr > 1;
            answer = Integer.toString(curr % 2) + answer;
        }
        if (carry) {
            answer = "1" + answer;
        }
        return answer;  
    }
}