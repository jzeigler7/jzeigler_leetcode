class Solution {
    public void reverseWords(char[] s) {
        int lastWordStart = s.length - 1;
        int startOfWordToMove = 0;
        char holder;
        while ((lastWordStart != 0) && (!(s[lastWordStart - 1] == ' '))) {
            lastWordStart--;
        }
        while (lastWordStart != 0) {
            startOfWordToMove = lastWordStart - 1;
            while ((startOfWordToMove != 0) && (!(s[startOfWordToMove - 1] == ' '))) {
                startOfWordToMove--;
            }
            if (s[lastWordStart - 1] == ' ') {
                holder = ' ';
                for (int j = lastWordStart - 1; j < s.length - 1; j++) {
                    s[j] = s[j + 1];
                }
                s[s.length - 1] = holder;
                lastWordStart--;
            }
            while (startOfWordToMove != lastWordStart) {
                holder = s[startOfWordToMove];
                for (int j = startOfWordToMove; j < s.length - 1; j++) {
                    s[j] = s[j + 1];
                }
                s[s.length - 1] = holder;
                lastWordStart--;
            }
        }
    }

    //Locate the index of the first letter of the last word

    //As long as there is a word immediately before it, move that word in front of the
    //last word and update the pointer of the last word.
}