class Solution {

    // wrapper method for recursive function - initializes pointers for
    // input and pattern to 0.
    
    public boolean isMatch(String s, String p) {
        return checkInd(s.toCharArray(), p.toCharArray(), 0, 0);
    }


    // determines if the character at the given index in the pattern is affected
    // by a subsequent asterisk (and is therefore "stalling", as I've dubbed it)

    public boolean stalling(char[] pattern, int pInd) {
        if (pInd >= pattern.length - 1) {
            return false;
        }
        return pattern[pInd + 1] == '*';
    }


    // the primary method of this monster problem - recursively calls itself using intelligently
    // updated pointers. 

    public boolean checkInd(char[] input, char[] pattern, int inputInd, int patternInd) {
        if (inputInd == input.length) { //if input pointer is outside the array, check for remaining chars in pattern
            int remStart = (stalling(pattern, patternInd)) ? nextNonstall(pattern, patternInd) : patternInd;
            if (remStart == -1) {
                remStart = patternInd;
            } // remStart is set to either the next nonstalling character or just the current pattern index, depending on if we're stalling'
            return checkRem(pattern, remStart, remStart);
        }
        if (patternInd == pattern.length) { //the failure case. if you run out of charaters in the pattern, you lose
            return false;
        }
        if (pattern[patternInd] == '*') { //if pattern pointer is on an asterisk, pass over it
            return checkInd(input, pattern, inputInd, patternInd + 1);
        }
        if (stalling(pattern, patternInd)) { //this is the awful part
            if ((input[inputInd] == pattern[patternInd]) || (pattern[patternInd] == '.')) { //checks if both pointers match characters
                int nns = nextNonstall(pattern, patternInd); //now, we check for bidirectional equality across the asterisk
                if ((nns != -1) && ((pattern[patternInd] == pattern[nns]) || (pattern[patternInd] == '.') || pattern[nns] == '.')) {
                    if (checkInd(input, pattern, inputInd + 1, patternInd)) { //attempt to match using the remainder of input
                        return true;
                    } else { //if the above attempt fails, try again using the next nonstalling character in the pattern
                        return checkInd(input, pattern, inputInd, nns);
                    }
                } else { //if no bidirectional equality, only advance input pointer
                    return checkInd(input, pattern, inputInd + 1, patternInd);
                }
            } else { //if the pointers don't match characters, try the next character in the pattern
                return checkInd(input, pattern, inputInd, patternInd + 1);
            }
        } else { // if we're not stalling
            if ((input[inputInd] == pattern[patternInd]) || (pattern[patternInd] == '.')) { //if the characters match, increment both pointers
                return checkInd(input, pattern, inputInd + 1, patternInd + 1);
            } else {
                return false; //another failure case. if there's no asterisk in front and there's a mismatch, you're done
            }
        }
    }


    //returns the next character in the pattern after the one passed in that's not stalling

    public int nextNonstall(char[] pattern, int patternInd) {
        if (patternInd >= pattern.length - 1) {
            return -1;
        } else {
            for (int i = patternInd + 1; i < pattern.length; i++) {
                if ((pattern[i] != '*') && (!(stalling(pattern, i)))) {
                    return i;
                }
            }
            return -1;
        }
    }

    //runs after checkInd determines success to see if there are any leftover nonstalling characters in the pattern
    //that would obstruct a match being made.

    public boolean checkRem(char[] pattern, int patternInd, int startInd) {
        if (patternInd >= pattern.length) {
            return true;
        }
        if (pattern[patternInd] == '*') {
            return checkRem(pattern, patternInd + 1, startInd);
        }
        if (patternInd == pattern.length - 1) {
            return false;
        }
        if (patternInd < pattern.length - 1) {
            if (stalling(pattern, patternInd)) {
                return checkRem(pattern, patternInd + 1, startInd);
            } else if ((patternInd == startInd) && (prevChar(pattern, patternInd) == pattern[patternInd])) {
                return checkRem(pattern, patternInd + 1, startInd);
            } else {
                return false;
            }
        }
        return false;
    }


    //returns the previous character
    
    public int prevChar(char[] pattern, int patternInd) {
        if (patternInd == 0) {
            return -1;
        } else {
            for (int i = patternInd; i > -1; i--) {
                if (pattern[patternInd] != '*') {
                    return i;
                }
            } 
            return -1;
        }
    }
}
