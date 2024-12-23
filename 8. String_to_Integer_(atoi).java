class Solution {
    public int myAtoi(String s) {
        ArrayList<Character> input = new ArrayList<Character>();
        int output = 0;
        boolean isNeg = false;
        char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < s.length(); i++) {
            input.add(s.charAt(i));
        }
        while ((input.size() != 0) && ((input.get(0) == ' ') || (input.get(0) == '+') || (input.get(0) == '-'))) {
            isNeg = (input.get(0) == '-');
            if ((input.get(0) == '+') || (input.get(0) == '-')) {
                input.remove(0);
                break;
            }
            if ((input.size() > 1) && (((input.get(0) == '-') || (input.get(0) == '+')) && ((input.get(1) == '-') || (input.get(1) == '+')))) {
                return 0;
            }
            input.remove(0);

        }
        if (input.size() == 0) {
            return 0;
        }
        if (input.get(0) == ' ') {
            return 0;
        }
        while ((input.size() != 0) && ((input.get(0) == '0'))) {
            input.remove(0);
        }
        while ((input.size() != 0) && (Arrays.binarySearch(digits, input.get(0)) >= 0)) {
            if (output == (isNeg ? -2147483648 : 2147483647)) {
                break;
            }
            if (output < 214748364) {
                output = output * 10 + Character.getNumericValue(input.remove(0));
            } else if (output == 214748364) {
                if (Character.getNumericValue(input.get(0)) <= (isNeg ? 8 : 7)) {
                    output = output * 10 + Character.getNumericValue(input.remove(0));
                } else {
                    output = (isNeg ? -2147483648 : 2147483647);
                    break;
                }
            } else {
                output = (isNeg ? -2147483648 : 2147483647);
                break;
            }
        }
        return (isNeg ? output * -1 : output);
    }
}