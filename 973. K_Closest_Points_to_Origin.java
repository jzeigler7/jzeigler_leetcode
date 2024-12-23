class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Coordinate> coords = new ArrayList<Coordinate>();
        int[][] sol = new int[k][1];
        for (int i = 0; i < points.length; i++) {
            coords.add(new Coordinate(magnitude(points[i][0], points[i][1]), i));
        }
        Collections.sort(coords);
        for (int j = 0; j < k; j++) {
            sol[j] = points[coords.get(j).pos];
        }
        return sol;
    }

    public double magnitude(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    class Coordinate implements Comparable<Coordinate>{
        private double mag;
        private int pos;
        public Coordinate(double mag, int pos) {
            this.mag = mag;
            this.pos = pos;
        }

        @Override
        public int compareTo(Coordinate other) {
            return Double.compare(this.mag, other.mag);
        }
        public int getPos() {
            return this.pos;
        }
    }  
}