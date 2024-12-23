class Solution {
    public String nearestPalindromic(String n) {
        long inputVal = Long.parseLong(n);
        if (n.equals("11")) return "9";
        if (inputVal < 11) return String.valueOf(inputVal - 1);
        String next = nextPalindrome(n);
        String prev = previousPalindrome(n);
        long nextVal = Long.parseLong(next);
        long prevVal = Long.parseLong(prev);
        long nextDist = Math.abs(nextVal - inputVal);
        long prevDist = Math.abs(inputVal - prevVal);
        if (prevDist <= nextDist) return prev;
        else return next; 
    }

    public String nextPalindrome(String n) {
        long inputValue = Long.parseLong(n);
        if (String.valueOf(inputValue + 1).length() > n.length()) return String.valueOf(inputValue + 2);
        if (inputValue == 99) return "101";
        if (n.length() == 2) {
            int tens = Character.getNumericValue(n.charAt(0));
            int ones = Character.getNumericValue(n.charAt(1));
            if (ones >= tens) return "" + String.valueOf(tens + 1) + String.valueOf(tens + 1);
            else return "" + String.valueOf(tens) + String.valueOf(tens);
        }
        int midpoint = (n.length() % 2 == 0) ? n.length() / 2 - 1 : n.length() / 2;
        int atMidpoint = Character.getNumericValue(n.charAt(midpoint));
        int afterMidpoint = Character.getNumericValue(n.charAt(midpoint + 1));
        String naturalPal = naturalPalindrome(n);
        if (Long.parseLong(naturalPal) <= inputValue) {
            String root = String.valueOf(Long.parseLong(n.substring(0, midpoint + 1)) + 1);
            if (n.length() % 2 == 1) midpoint--;
            while (midpoint > -1) {
                root += root.charAt(midpoint);
                midpoint--;
            }
            return root;
        } else return naturalPal;
    }

    public String previousPalindrome(String n) {
        long inputValue = Long.parseLong(n);
        if ((inputValue == 100) || (inputValue == 101)) return "99";
        if (n.length() == 2) {
            int tens = Character.getNumericValue(n.charAt(0));
            int ones = Character.getNumericValue(n.charAt(1));
            if (ones <= tens) return "" + String.valueOf(tens - 1) + String.valueOf(tens - 1);
            else return "" + String.valueOf(tens) + String.valueOf(tens);
        }
        if (n.charAt(0) == '1') {
            boolean powerOfTen = true;
            for (int i = 1; i < n.length() - 1; i++) {
                if (n.charAt(i) != '0') powerOfTen = false;
            }
            if (powerOfTen) return inputValue % 2 == 0 ? String.valueOf(inputValue - 1) : String.valueOf(inputValue - 2);
        }
        int midpoint = (n.length() % 2 == 0) ? n.length() / 2 - 1 : n.length() / 2;
        int atMidpoint = Character.getNumericValue(n.charAt(midpoint));
        int afterMidpoint = Character.getNumericValue(n.charAt(midpoint + 1));
        String naturalPal = naturalPalindrome(n);
        if (Long.parseLong(naturalPal) >= inputValue) {
            String root = String.valueOf(Long.parseLong(n.substring(0, midpoint + 1)) - 1);
            if (n.length() % 2 == 1) midpoint--;
            while (midpoint > -1) {
                root += root.charAt(midpoint);
                midpoint--;
            }
            return root;
        } else return naturalPal;
    }

    public String naturalPalindrome(String n) {
        int midpoint = (n.length() % 2 == 0) ? n.length() / 2 - 1 : n.length() / 2;
        String root = n.substring(0, midpoint + 1);
        if (n.length() % 2 == 1) midpoint--;
        while (midpoint > -1) {
            root += root.charAt(midpoint);
            midpoint--;
        }
        return root;
    }
}