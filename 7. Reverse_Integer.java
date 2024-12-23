class Solution {
    public int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        int rev = genRev(x);
        int revOfRev = genRev(rev);
        if (x == revOfRev) {
            return rev;
        } else {
            while (!((Math.abs(revOfRev) > Math.abs(x)) || (Math.abs(revOfRev) > 214748364) )) {
                revOfRev *= 10;
                if (x == revOfRev) {
                    return rev;
                }
            }
            return 0;
        }
    }
    public int genRev(int x) {
        int curr = x;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        ArrayList<Integer> revDigits = new ArrayList<Integer>();
        while (Math.abs(curr) > 9) {
            digits.add(curr % 10);
            curr /= 10;
        }
        digits.add(curr);
        int place = 0;
        for (int i = digits.size() - 1; i > -1; i--) {
            revDigits.add((int) (Math.pow(10, place) * digits.get(i)));
            place++;
        }
        int total2 = 0;
        for (int i = 0; i < revDigits.size(); i++) {
            total2 += revDigits.get(i);
        }
        return total2;
    }
}