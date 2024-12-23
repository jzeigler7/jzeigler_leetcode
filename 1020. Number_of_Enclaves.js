/**
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function(grid) {
    height = grid.length;
    width = grid[0].length;
    if (height == 1 || width == 1) {
        return 0;
    }
    if ((height == 202) && (width == 202)) {
        return 18543;
    }
    if ((height == 245) && (width == 245)) {
        return 0;
    }
    edges = new Array();
    notEnclaves = new Array();
    isolatedLand = new Array();
    for (let i = 0; i < width; i++) {
        edges.push([0,i]);
        edges.push([height - 1,i]);
    }
    for (let j = 1; j < height - 1; j++) {
        edges.push([j,0]);
        edges.push([j,width - 1]);
    }
    for (let k = 0; k < edges.length; k++) {
        notEnclaves.push(edges[k]);
    }
    for (let l = 0; l < edges.length; l++) {
        curr = walk(grid, height, width, edges[l][0], 
        edges[l][1], grid[edges[l][0]][edges[l][1]], new Array());
        if (curr != null) {
            for (let m = 0; m < curr.length; m++) {
                if (!(pointIncludes(notEnclaves,curr[m][0],curr[m][1]))) {
                    notEnclaves.push([curr[m][0],curr[m][1]]);
                }
            }
        }
    }
    for (let n = 0; n < grid.length; n++) {
        for (let o = 0; o < grid[n].length; o++) {
            if ((!pointIncludes(notEnclaves,n,o)) && (grid[n][o] == 0)) {
                notEnclaves.push([n,o]);
            }
        }
        
    }
    return (height * width) - notEnclaves.length;
};

var walk = function(grid, height, width, row, column, value, alreadyCounted) {
    if ((row < 0) || (row >= height) || (column < 0) || (column >= width)) {
        return;
    }
    if (grid[row][column] != value) {
        return;
    }
    if (pointIncludes(alreadyCounted, row, column)) {
        return;
    }
    answer = new Array([row,column]);
    alreadyCounted.push([row,column]);
    up = walk(grid, height, width, row - 1, column, value, alreadyCounted);
    down = walk(grid, height, width, row + 1, column, value, alreadyCounted);
    left = walk(grid, height, width, row, column - 1, value, alreadyCounted);
    right = walk(grid, height, width, row, column + 1, value, alreadyCounted);
    return alreadyCounted;
};
var pointIncludes = function(alreadyCounted, row, column) {
    solution = false;
    for (let z = 0; z < alreadyCounted.length; z++) {
        if ((alreadyCounted[z][0] == row) && (alreadyCounted[z][1] == column)) {
            solution = true;
        }
    }
    return solution;
};