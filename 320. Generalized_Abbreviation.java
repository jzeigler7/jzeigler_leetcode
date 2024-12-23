class Solution {
    public List<String> generateAbbreviations(String word) {
        ArrayList<String> answer = new ArrayList<String>();
        for (int i = 0; i < Math.pow(2, word.length()); i++) {
            answer.add(bitstringify(word, fatten(Integer.toBinaryString(i), word.length())));
        }
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals("-")) {
                String toAdd = "";
                toAdd += Character.getNumericValue(word.length());
                answer.set(i, toAdd);
            }
        }
        return answer;
    }
 
    public String fatten(String input, int targetSize) {
        while (input.length() < targetSize) {
            input = "0".concat(input);
        }
        return input;
    }

    public String bitstringify(String input, String bitstring) {
        List<Character> inputAL = arrayToList(input.toCharArray());
        boolean modifications = true;
        int[] consec;
        List<Character> pre;
        List<Character> post;
        List<Character> num;
        for (int i = 0; i < bitstring.length(); i++) {
            if (bitstring.charAt(i) == '1') {
                inputAL.set(i, '1');
            }
        }
        consec = findConsec(inputAL, 0);
        while (!((consec[0] == -1) && (consec[1] == -1))) {
            pre = inputAL.subList(0, consec[0]);
            if (consec[1] == inputAL.size()) {
                post = new ArrayList<Character>();
            } else {
                post = inputAL.subList(consec[1], inputAL.size());
            }
            num = arrayToList(((Integer.toString(consec[1] - consec[0])).toCharArray()));
            
            inputAL = tripleListCombiner(pre, num, post);
            consec = findConsec(inputAL, consec[0] + num.size());
        }
        return listToString(inputAL); 
    }

    public ArrayList<Character> tripleListCombiner(List<Character> list1, List<Character> list2, List<Character> list3) {
        ArrayList<Character> answer = new ArrayList<Character>();
        for (Character c : list1) {
            answer.add(c);
        }
        for (Character c : list2) {
            answer.add(c);
        }
        for (Character c : list3) {
            answer.add(c);
        }
        return answer;
    }

    public ArrayList<Character> arrayToList(char[] input) {
        ArrayList<Character> answer = new ArrayList<Character>();
        for (int i = 0; i < input.length; i++) {
            answer.add(input[i]);
        }
        return answer;
    }

    public String listToString(List<Character> input) {
        String answer = "";
        for (int i=0; i < input.size(); i++) {
            answer += input.get(i);
        }
        return answer;
    }

    public int[] findConsec(List<Character> input, int start) {
        int[] answer = { -1, -1 };
        for (int i = start; i < input.size() - 1; i++) {
            if ((input.get(i) == '1') && (input.get(i + 1) == '1')) {
                answer[0] = i;
                for (int j = i + 1; j < input.size(); j++) {
                    if (input.get(j) != '1') {
                        answer[1] = j;
                        return answer;
                    }
                }
                answer[1] = input.size();
                return answer;
            }
        }
        return answer;
    }
}