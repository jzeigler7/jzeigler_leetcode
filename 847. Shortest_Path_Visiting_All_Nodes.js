/**
 * @param {number[][]} graph
 * @return {number}
 */
var shortestPathLength = function(graph) {
    let endMask = (1 << graph.length) - 1;
    let queue = new Array();
    let visited = new Set();
    for (var i = 0; i < graph.length; i++) {
        queue.push([i, 1 << i]);
        visited.add(`${i},${1 << i}`);
    }
    let steps = 0;
    while (queue.length) {
        let next = new Array();
        while (queue.length) {
            popped = queue.pop();
            currNode = popped[0];
            currMask = popped[1];
            if (currMask == endMask) {
                return steps;
            }
            for (var neighbor of graph[currNode]) {
                let newMask = currMask | (1 << neighbor);
                if (!visited.has(`${neighbor},${newMask}`)) {
                    next.push([neighbor, newMask]);
                    visited.add(`${neighbor},${newMask}`);
                }
            }
        }
        queue = next;
        steps++;
    }
};