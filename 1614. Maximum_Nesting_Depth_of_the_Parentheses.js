/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    deepest = 0;
    depth = 0;
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) == '(') {
            depth++;
        }
        if (s.charAt(i) == ')') {
            depth--;
        }
        if (depth > deepest) {
            deepest = depth;
        }
    }
    return deepest;
};