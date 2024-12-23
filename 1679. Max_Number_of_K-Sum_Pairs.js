/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
function maxOperations(nums, k) {
    let count = 0;
    nums.sort(function(a,b){return (a - b)});
    let i = 0;
    let j = nums.length - 1;
    while (!(i > j)) {
        if (nums[i] + nums[j] == k) {
            if (i != j) {
                count++;
            }
            i++;
            j--;
            continue;
        } else if (k - nums[j] > nums[i]) {
            i++;
            continue;
        } else {
            j--;
        }

    }
    return count;





};