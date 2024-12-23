class Solution {
    public int getMaximumGenerated(int n) {
        int[] back = new int[n + 1];
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                back[i] = i;
            } else if (i % 2 == 0) {
                back[i] = back[i / 2];
            } else {
                back[i] = back[i / 2] + back[(i / 2) + 1];
            }
            if (back[i] > max) max = back[i];
        }
        return max;
        
        
    }
}