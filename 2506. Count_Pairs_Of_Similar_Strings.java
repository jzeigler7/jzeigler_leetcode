class Solution {
    public int similarPairs(String[] words) {
        //create bitmask-to-frequency map
        //for each word, generate a 26-bit bitmask and increment its frequency in the map
        // next, for every value in the map that appears more than once, calculate the # of combinations
        // return cumulative total of combinations



        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        int bitmask;
        for (String w: words) {
            bitmask = 0;
            for (char c : w.toCharArray()) {
                bitmask |= (1 << c - 'a');
            }
            table.put(bitmask, table.getOrDefault(bitmask, 0) + 1);
        }
        int total = 0;
        for (int c : table.values()) {
            if (c > 1) total += (((c)  *(c - 1)) / (2));
        }
        return total;

        
    }

    
}