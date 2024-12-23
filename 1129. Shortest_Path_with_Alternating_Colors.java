class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] answer = new int[n];
        ArrayList<Integer> redStales = new ArrayList<Integer>();
        ArrayList<Integer> blueStales = new ArrayList<Integer>();
        LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
        int[] code = new int[3];
        boolean found;
        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }
        queue.add(new Integer[] { 0,0,0 });
        queue.add(new Integer[] { 0,1,0 });
        while (queue.size() > 0) {
            code[0] = queue.get(0)[0];
            code[1] = queue.get(0)[1];
            code[2] = queue.get(0)[2];
            queue.removeFirst();
            found = false;
            if (code[1] == 1) {
                for (Integer i : redStales) {
                    if (code[0] == i) {
                        found = true;
                    }
                }
            } else {
                for (Integer i : blueStales) {
                    if (code[0] == i) {
                        found = true;
                    }
                }
            }
            if (found) {
                continue;
            } else {
                if ((answer[code[0]] == -1) || (answer[code[0]] > code[2])) {
                    answer[code[0]] = code[2];
                }
                if (code[1] == 1) {
                    redStales.add(code[0]);
                    for (int[] b : blueEdges) {
                        if (b[0] == code[0]) {
                            queue.add(new Integer[] { b[1],0,(code[2] + 1) });
                        }
                    }
                } else {
                    blueStales.add(code[0]);
                    for (int[] r : redEdges) {
                        if (r[0] == code[0]) {
                            queue.add(new Integer[] { r[1],1,(code[2] + 1) });
                        }
                    }
                }
            }
        }
        return answer;
    }
}