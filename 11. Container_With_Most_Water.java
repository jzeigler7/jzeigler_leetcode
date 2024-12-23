class Solution {
    public int maxArea(int[] height) {
        int i;
        int highest = 0;
        for (int j = height.length - 1; j > 0; j--) {
            i = 0;
            while ((height[j] >= height[i]) && (i < j - 1)) {
                if (water(i, j, height[i], height[j]) > highest) {
                    highest = water(i, j, height[i], height[j]);
                }
                i++;
            }
            if (water(i, j, height[i], height[j]) > highest) {
                    highest = water(i, j, height[i], height[j]);
                }
        }
        return highest;
        
    }
    public int water(int begInd, int endInd, int begHeight, int endHeight) {
        return (Math.min(begHeight, endHeight) * Math.abs(begInd - endInd));
    }
}