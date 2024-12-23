class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] toReturn = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((equalToSum(target, nums[i], nums[j])) && (i != j)) {
                    toReturn[0] = i;
                    toReturn[1] = j; 
                }
            }
        }
        return toReturn;
    }
    public boolean equalToSum(int target, int num1, int num2) {
        return (num1 + num2 == target);
    }
}