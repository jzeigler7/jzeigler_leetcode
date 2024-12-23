class Solution {
    public String convert(String s, int numRows) {
        return levelOrder(createZigzag(s, numRows), numRows);
    }
    public ArrayList<Character[]> createZigzag (String s, int numRows) {
        ArrayList<Character[]> zigzag = new ArrayList<Character[]>();
        int column = 0;
        int row = 0;
        boolean movingUp = false;
        for (int i = 0; i < s.length(); i++) {
            if (zigzag.size() == column) {
                zigzag.add(new Character[numRows]);
            }
            if (row == -1) {
                row = 0;
            }
            zigzag.get(column)[row] = s.toCharArray()[i];
            if (row == 0) {
                movingUp = false;
            }
            if (row == numRows - 1) {
                movingUp = true;
            }
            if (movingUp == true) {
                row--;
                column++;
            } else {
                row++;
            }
        }
        return zigzag;
    }
    public String levelOrder(ArrayList<Character[]> input, int numRows) {
        String toReturn = "";
        int column = 0;
        int row = 0;
        while (0 == 0) {
            if (!(input.get(column)[row] == null)) {
                toReturn += input.get(column)[row];
            }
            if (column == input.size() - 1) {
                column = 0;
                row++;
            } else {
                column++;
            }
            if (row == numRows) {
                return toReturn;
            }
        }
    }
}