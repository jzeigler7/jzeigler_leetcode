class TreeAncestor {

    private int n;
    private int[] parent;
    private HashMap<Integer, HashMap<Integer, Integer>> memory;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
        this.memory = new HashMap<Integer, HashMap<Integer, Integer>>();
    }

    

    
    public int getKthAncestor(int node, int k) {
        
        if ((memory.containsKey(node)) && (this.memory.get(node).get(k) != null)) {
            return this.memory.get(node).get(k);
        } else {
            int curr = node;
            if ((node < k) && (this.parent[node] < node)) {
                return -1;
            }
            for (int i = 0; i < k; i++) {
                if (curr == -1) {
                    return -1;
                }
                curr = this.parent[curr];
            }
            if (!(memory.containsKey(node))) {
                memory.put(node, new HashMap<Integer, Integer>());
            }
            memory.get(node).put(k, curr);
            return curr;
        }
        
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */