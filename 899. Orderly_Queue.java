class Solution {
    PriorityQueue<String> checkedPQ = new PriorityQueue<String>();
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                checkedPQ.add(s);
                s = sendBack(s);
            }
            return checkedPQ.poll();
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = "";
            for (int i = 0; i < chars.length; i++) {
                s += (chars[i]);
            }
            return s;
        }
    }




    public String sendBack(String s) {
        String placeholder = s.substring(0, 1);
        s = s.substring(1);
        s = s.concat(placeholder);
        return s;
    }

    //create PriorityQueue of strings called checkedList. This will contain all of the Strings weve checked, in order
    //call rOrderlyQueue on the given string
    // return 
}