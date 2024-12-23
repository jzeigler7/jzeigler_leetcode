class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int answer = 0;
        int leftLimit = -1 * (img1.length - 1);
        int rightLimit = img1.length;
        int target = ones(img2);
        ArrayList<int[][]> shiftedImages = new ArrayList<int[][]>();
        for (int i = leftLimit; i < rightLimit; i++) {
            for (int j = leftLimit; j < rightLimit; j++) {
                shiftedImages.add(shiftImage(img1, i, j));
            }
        }
        shiftedImages.add(shiftImage(img1, 1, 1));
        int currOverlap;
        for (int[][] si : shiftedImages) {
            currOverlap = overlap(si, img2);
            if (currOverlap > answer) {
                answer = currOverlap;
            }
            if (answer == target) {
                return target;
            }
        }
        return answer;
    }

    public int[][] shiftImage(int[][] image, int hShift, int vShift) {
        int[][] answer = new int[image.length][image[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                answer[i][j] = image[i][j];
            }
        }
        if (hShift > 0) {
            for (int i = 0; i < Math.abs(hShift); i++) {
                answer = shiftRight(answer);
            }
        }
        if (hShift < 0) {
            for (int i = 0; i < Math.abs(hShift); i++) {
                answer = shiftLeft(answer);
            }
        }
        if (vShift > 0) {
            for (int i = 0; i < Math.abs(vShift); i++) {
                answer = shiftUp(answer);
            }
        }
        if (vShift < 0) {
            for (int i = 0; i < Math.abs(vShift); i++) {
                answer = shiftDown(answer);
            }
        }
        return answer;
    
    }
    //

    public int[][] shiftUp(int[][] image) {
        for (int i = 1; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i - 1][j] = image[i][j];
            }
        }
        for (int j = 0; j < image[image.length - 1].length; j++) {
            image[image.length - 1][j] = 0;
        }
        return image;
    }

    public int[][] shiftDown(int[][] image) {
        for (int i = image.length - 2; i > -1; i--) {
            for (int j = 0; j < image[i].length; j++) {
                image[i + 1][j] = image[i][j];
            }
        }
        for (int j = 0; j < image[0].length; j++) {
            image[0][j] = 0;
        }
        return image;
    }

    public int[][] shiftLeft(int[][] image) {
        int width = image[0].length;
        for (int j = 1; j < width; j++) {
            for (int i = 0; i < image.length; i++) {
                image[i][j - 1] = image[i][j];
            }
        }
        for (int i = 0; i < image.length; i++) {
            image[i][width - 1] = 0;
        }
        return image;
    }

    public int[][] shiftRight(int[][] image) {
        int width = image[0].length;
        for (int j = width - 2; j > -1; j--) {
            for (int i = 0; i < image.length; i++) {
                image[i][j + 1] = image[i][j];
            }
        }
        for (int i = 0; i < image.length; i++) {
            image[i][0] = 0;
        }
        return image;
    }

    public int overlap(int[][] image1, int[][] image2) {
        int answer = 0;
        for (int i = 0; i < image1.length; i++) {
            for (int j = 0; j < image1[0].length; j++) {
                if ((image1[i][j] == 1) && (image2[i][j] == 1)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public int ones(int[][] input) {
        int answer = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

}

//