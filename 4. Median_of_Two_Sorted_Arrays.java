import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] combinedList = new double[nums1.length + nums2.length];
        int mFloor = 0;
        int nFloor = 0;
        int mCurr = 0;
        int nCurr = 0;
        if (nums1.length == 0) {
             if (nums2.length % 2 == 0) {
                return ((nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0);
            }
            return nums2[nums2.length / 2];
        }
        if (nums2.length == 0) {
             if (nums1.length % 2 == 0) {
                return ((nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0);
            }
            return nums1[nums1.length / 2];
        }
        for (int i = 0; i < combinedList.length; i++) {
            
            if (mFloor == nums1.length) {
                nCurr = nums2[nFloor];
                combinedList[i] = nCurr;
                nFloor++;
                continue;
            }
            if (nFloor == nums2.length) {
                mCurr = nums1[mFloor];
                combinedList[i] = mCurr;
                mFloor++;
                continue;
            }
            mCurr = nums1[mFloor];
            nCurr = nums2[nFloor];
            if (mCurr < nCurr) {
                combinedList[i] = mCurr;
                mFloor++;
            } else {
                combinedList[i] = nCurr;
                nFloor++;
            }
        }
        if (combinedList.length % 2 == 0) {
            double const1 = combinedList[combinedList.length / 2];
            double const2 = combinedList[combinedList.length / 2 - 1];
            return (const1 + const2) / 2.0;
        }
        return combinedList[combinedList.length / 2];
    }
}