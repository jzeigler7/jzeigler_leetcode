/**
 * @param {string[]} strs
 * @return {number}
 */
var findLUSlength = function(strs) {
    strs.sort(function(a,b){return b.length - a.length});
    for (i = 0; i < strs.length; i++) {
        matchFound = false;
        for (j = 0; j < strs.length; j++) {
            if (i === j) {
                continue;
            }
            if (isSubseq(strs[i],strs[j])) {
                matchFound = true;
                break;
            }
        }
        if (!matchFound) {
            return strs[i].length;
        }
    }
    return -1;
};

var isSubseq = function(small, large) {
    smallInd = 0;
    for (largeInd = 0; largeInd < large.length && smallInd < small.length; largeInd++) {
        if (small[smallInd] === large[largeInd]) {
            smallInd++;
        }
    }
    return (small.length == smallInd); 
};