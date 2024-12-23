class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() - 1;
        for (int l = n - 1; l >= 0; l--) {
            for (int x = 0; x <= l; x++) {
                triangle.get(l).set(x,triangle.get(l).get(x) + Math.min((triangle.get(l + 1).get(x)),(triangle.get(l + 1).get(x + 1))));
            }
        }
        return triangle.get(0).get(0); 
    }
}