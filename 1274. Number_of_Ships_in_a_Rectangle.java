/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return rCountShips(sea, topRight, bottomLeft);
        
    }
    public int rCountShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (sea.hasShips(topRight, bottomLeft)) {
            if (Arrays.equals(topRight, bottomLeft)) {
                return 1;
            } else {
                if ((bottomLeft[1] > topRight[1]) || (bottomLeft[0] > topRight[0])) {
                    return 0;
                }
                int HMP = (topRight[0] + bottomLeft[0]) / 2;
                int VMP = (topRight[1] + bottomLeft[1]) / 2;
                int total = rCountShips(sea, new int[] { HMP,topRight[1] }, new int[] { bottomLeft[0],VMP + 1 });
                if (total < 10) {
                    total += rCountShips(sea, topRight, new int[] { HMP+1,VMP + 1 });
                }
                if (total < 10) {
                    total += rCountShips(sea, new int[] { HMP,VMP }, bottomLeft);
                }
                if (total < 10) {
                    total += rCountShips(sea, new int[] { topRight[0], VMP }, new int[] { HMP + 1, bottomLeft[1] });
                }
                return total;
            }
        } else {
            return 0;
        }
    }
}