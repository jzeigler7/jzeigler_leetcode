class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String answer = "";
        if (str1.length() > str2.length()) {
            for (int one = 0; one <= str1.length(); one++) {
                if ((isDivisor(str1,str1.substring(0,one))) && (isDivisor(str2,str1.substring(0,one)))) {
                    answer = str1.substring(0,one);
                }
            }
        } else {
            for (int one = 0; one <= str2.length(); one++) {
                if ((isDivisor(str1,str2.substring(0,one))) && (isDivisor(str2,str2.substring(0,one)))) {
                    answer = str2.substring(0,one);
                }
            }
        }
        return answer;
    }
    public boolean isDivisor(String str, String divisor) {
        if ((divisor.length() == 0) || (str.length() % divisor.length() != 0) || (divisor.length() > str.length())) {
            return false;
        }
        int repeats = str.length() / divisor.length();
        String test = "";
        for (int i = 0; i < repeats; i++) {
            test += divisor;
        }
        return test.equals(str);
    }
}

//cr