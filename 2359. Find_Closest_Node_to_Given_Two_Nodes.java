class Solution {
    private int[] firstBFS;
    private int[] secondBFS;
    private int highestNode;
    private boolean disjoint;
    private boolean[] counted;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) return node1;
        this.highestNode = 0;
        this.firstBFS = new int[edges.length];
        
        this.secondBFS = new int[edges.length];
        this.counted = new boolean[edges.length];
        this.disjoint = true;

        //conducts BFS on both input nodes, storing their data in
        //two separate arrays
        this.bfs(edges, node1, 1, true);
        this.counted = new boolean[edges.length];
        System.out.println("");
        this.bfs(edges, node2, 1, false);
        if (this.disjoint) return -1;

        int answer = -1;
        int maxMin = Integer.MAX_VALUE;

        for (int i = 0; i < this.highestNode + 1; i++) {
            if ((this.firstBFS[i] != 0) && (this.secondBFS[i] != 0) && (Math.max(this.firstBFS[i], this.secondBFS[i]) == 2)) return i;
            if ((firstBFS[i] != 0) && (this.secondBFS[i] != 0) && (Math.max(this.firstBFS[i], this.secondBFS[i]) < maxMin)) {
                maxMin = Math.max(this.firstBFS[i], this.secondBFS[i]);
                answer = i;
            }
        }
        return answer;
        


        
        
    }

    private void bfs(int[] edges, int node, int distance, boolean first) {
        if (disjoint && !first && this.firstBFS[node] != 0) this.disjoint = false;
        this.counted[node] = true;
        if (node > this.highestNode) this.highestNode = node;
        if (first) this.firstBFS[node] = distance;
        else this.secondBFS[node] = distance;
        System.out.println(node);
        if ((edges[node] != -1) && (!this.counted[edges[node]])) bfs(edges, edges[node], distance + 1, first);
    }
    

    //for node1 and node2, conduct a BFS and record the shortest distance to each node
    //create private static arraylist representing the nodes that have already been counted


}