class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int currX;
        int currY;
        int currDist;
        int destX = destination[0];
        int destY = destination[1];
        int mazeLength = maze[0].length - 1;
        int mazeHeight = maze.length - 1;
        int trackerX;
        int trackerY;
        int trackerDist;
        int distSum;
        String key;
        String trackerKey;
        int[] curr;
        PriorityQueue<int[]> frontier = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Map<String,Integer> visited = new HashMap<>();
        frontier.add(new int[]{start[0],start[1],0});
        visited.put((start[0]+","+start[1]),0);
        while (!frontier.isEmpty()) {
            curr = frontier.poll();
            currX = curr[0];
            currY = curr[1];
            currDist = curr[2];
            if ((currX == destX) && (currY == destY)) return currDist;
            key = (currX+","+currY);
            //if ((visited.keySet().contains(key)) && (visited.get(key) < currDist)) continue;
            //if testing a coordinate with an existing entry in VISITED with a lower distance, stop

            //up
            trackerX=currX;
            trackerY=currY;
            trackerDist=0;
            while(trackerX>0 && maze[trackerX - 1][trackerY] == 0) {
                trackerX--;
                trackerDist++;
            }
            trackerKey = (trackerX+","+trackerY);
            distSum = currDist + trackerDist;
            if ((!visited.keySet().contains(trackerKey)) || (visited.get(trackerKey) > currDist + trackerDist)) {
                visited.put(trackerKey, distSum);
                frontier.add(new int[]{trackerX,trackerY,distSum});
            }
            //down
            trackerX=currX;
            trackerDist=0;
            while(trackerX<mazeHeight && maze[trackerX + 1][trackerY] == 0) {
                trackerX++;
                trackerDist++;
            }
            trackerKey = (trackerX+","+trackerY);
            distSum = currDist + trackerDist;
            if ((!visited.keySet().contains(trackerKey)) || (visited.get(trackerKey) > currDist + trackerDist)) {
                visited.put(trackerKey, distSum);
                frontier.add(new int[]{trackerX,trackerY,distSum});
            }
            //left
            trackerX=currX;
            trackerDist=0;
            while(trackerY>0 && maze[trackerX][trackerY - 1] == 0) {
                trackerY--;
                trackerDist++;
            }
            trackerKey = (trackerX+","+trackerY);
            distSum = currDist + trackerDist;
            if ((!visited.keySet().contains(trackerKey)) || (visited.get(trackerKey) > currDist + trackerDist)) {
                visited.put(trackerKey, distSum);
                frontier.add(new int[]{trackerX,trackerY,distSum});
            }
            //right
            trackerY=currY;
            trackerDist=0;
            while(trackerY<mazeLength && maze[trackerX][trackerY + 1] == 0) {
                trackerY++;
                trackerDist++;
            }
            trackerKey = (trackerX+","+trackerY);
            distSum = currDist + trackerDist;
            if ((!visited.keySet().contains(trackerKey)) || (visited.get(trackerKey) > currDist + trackerDist)) {
                visited.put(trackerKey, distSum);
                frontier.add(new int[]{trackerX,trackerY,distSum});
            }
        }
        return -1;
    }
}