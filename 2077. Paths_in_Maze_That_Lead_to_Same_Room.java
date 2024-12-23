class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        if (corridors.length < 3) return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        int answer = 0;
        for (int i = 1; i <= n; i++) graph.put(i, new HashSet<Integer>());
        for (int[] a : corridors) {
            if (a[0] < a[1]) graph.get(a[0]).add(a[1]);
            else graph.get(a[1]).add(a[0]);
        }
        for (int[] a : corridors) {
            Set<Integer> s0 = graph.get(a[0]);
            Set<Integer> s1 = graph.get(a[1]);
            for (int k: s0) if (s1.contains(k)) answer++;

        }
        return answer;
        
    }
}