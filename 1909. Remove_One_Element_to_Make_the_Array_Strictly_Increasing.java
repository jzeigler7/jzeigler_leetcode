class Solution {
    public boolean canBeIncreasing(int[] nums) {
        if (isStrictlyIncreasing(nums)) {
            return true;
        }
        int[][] allPossibleOmissions = omissions(nums);
        for (int[] i : allPossibleOmissions) {
            if (isStrictlyIncreasing(i)) {
                return true;
            }
        }
        return false;
    }
    public boolean isStrictlyIncreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums [i + 1]) {
                return false;
            }
        }
        return true;
    }
    public int[][] omissions (int[] nums) {
        int[][] answer = new int[nums.length][nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = omission(nums, i);
        }
        return answer;
    }

    public int[] omission (int[] nums, int omit) {
        int[] answer = new int[nums.length - 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != omit) {
                answer[j] = nums[i];
                j++;
            }
        }
        return answer;
    }
}