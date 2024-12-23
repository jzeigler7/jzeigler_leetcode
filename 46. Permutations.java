class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return new ArrayList<List<Integer>>(Collections.singletonList(Collections.singletonList(nums[0]))); 
        }
        int[] removed;
        Integer[] currTotal = new Integer[nums.length];
        List<List<Integer>> suffixes = new ArrayList<List<Integer>>();
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        for (int n = 0; n < nums.length; n++) {
            suffixes.clear();
            currTotal = new Integer[nums.length];
            removed = new int[nums.length - 1];
            int i = 0, j = 0;
            while (i < nums.length) {
                if (n != i) {
                    removed[j] = nums[i];
                    j++;
                }
                i++;
            }
            currTotal[0] = nums[n];
            suffixes = permute(removed);
            for (int s = 0; s < suffixes.size(); s++) {
                for (int t = 0; t < suffixes.get(s).size(); t++) {
                    currTotal[t + 1] = suffixes.get(s).get(t);
                } 
                permutations.add(new ArrayList<Integer>(Arrays.asList(currTotal)));
            }  
        }
        return permutations;
    }    
}