class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Boolean> tracker = new HashMap<Integer, Boolean>();
        for (int i  = 0; i < nums.length; i++) {
            if (tracker.keySet().contains(nums[i])) {
                return nums[i];
            } else {
                tracker.put(nums[i], true);
            }
        }
        return -1;
    }
}