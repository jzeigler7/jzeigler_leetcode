class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        char[] sc3 = s3.toCharArray();
        int l1 = sc1.length;
        int l2 = sc2.length;
        int l3 = sc3.length;
        int ml;
        int minl = Integer.min(l1, l2);
        int i = 0;
        char c1,c2,c3;
        minl = Integer.min(minl, l3); 
        while (i < minl) {
            c1=sc1[i];
            c2=sc2[i];
            c3=sc3[i];
            if (!((c1==c2) && (c2==c3))) break;
            i++;
        }
        if (i==0) return -1;
        int diff1 = l1 - i;
        int diff2 = l2 - i;
        int diff3 = l3 - i;
        return diff1+diff2+diff3;




    }
    //determine if there is a non-null prefix common to each of the three strings. var1 stores the length of the longest common prefix. if there is none, return -1
    //var2 tracks the length of the longest given string
    //return var2 - var1
}