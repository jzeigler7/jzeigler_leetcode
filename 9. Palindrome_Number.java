class Solution {
    public boolean isPalindrome(int x) {
        char[] input = Integer.toString(x).toCharArray();
        if (input.length == 1) {
            return true;
        }
        int a = 0;
        int b = input.length - 1;
        if (input.length == 2) {
            return (input[a] == input[b]);
        }
        while (input[a] == input[b]) {
            if (a > b) {
                return true;
            }
            a++;
            b--;
        }
        return false;
    }
}