

import static java.util.stream.Collectors.toList;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int arrSize = arr.length;
        int currPieceLength;
        int[] currPiece;
        Map<Integer, int[]> pieceMap = new HashMap<Integer, int[]>();
        for (int[] p : pieces) pieceMap.put(p[0], p);
        for (int i = 0; i < arrSize;) {
            //find a piece that matches
            if (!pieceMap.keySet().contains(arr[i])) return false;
            currPiece = pieceMap.get(arr[i]);
            currPieceLength = currPiece.length;
            for (int j = 0; j < currPieceLength; j++) {
                if (arr[i] != currPiece[j]) break; 
                i++;
            }
        }
        return true;


        
    }
}