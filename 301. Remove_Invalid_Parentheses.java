class Solution {
    private Set<String> validExpressions = new HashSet<String>();
    private int minRemoved;
    public List<String> removeInvalidParentheses(String s) {
        validExpressions.clear();
        minRemoved = Integer.MAX_VALUE;
        this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(this.validExpressions);
    }

    private void recurse(String s, int index, int lefties, int righties, StringBuilder expression, int removedCount) {
        if (index == s.length()) {
            if (lefties == righties) {
                if (removedCount <= minRemoved) {
                    String possibleAnswer = expression.toString();
                    if (removedCount < minRemoved) {
                        this.validExpressions.clear();
                        this.minRemoved = removedCount;
                    }
                    this.validExpressions.add(possibleAnswer);
                }
            }
        } else {
            char currChar = s.charAt(index);
            int length = expression.length();
            if (currChar != '(' && currChar != ')') {
                expression.append(currChar);
                this.recurse(s, index + 1, lefties, righties, expression, removedCount);
                expression.deleteCharAt(length);
            } else {
                this.recurse(s, index + 1, lefties, righties, expression, removedCount + 1);
                expression.append(currChar);
                if (currChar == '(') {
                    this.recurse(s, index + 1, lefties + 1, righties, expression, removedCount);
                } else if (lefties > righties) {
                    this.recurse(s, index + 1, lefties, righties + 1, expression, removedCount);

                }
                expression.deleteCharAt(length);
            }
        }
    }
}