class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> rems = new HashMap<Integer, Integer>();
        rems.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!(rems.keySet().contains(sum % k))) {
                rems.put(sum % k, i + 1);
            } else if (rems.get(sum % k) < i) {
                return true;
            }
        }
        return false;
    }
}