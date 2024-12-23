/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int answer = -1;
        for (int i = fonts.length - 1; i > -1; i--) {
            if (fits(text, w, h, fonts[i], fontInfo)) {
                return fonts[i];
            }
        }
        return -1;
    }

    public boolean fits(String text, int w, int h, int font, FontInfo fontInfo) {
        return fitsHeight(h, font, fontInfo) && fitsWidth(text, w, font, fontInfo);

    }

    public boolean fitsWidth(String text, int w, int font, FontInfo fontInfo) {
        int totalWidth = 0;
        char[] textChars = text.toCharArray();
        for (int i = 0; i < textChars.length; i++) {
            totalWidth += fontInfo.getWidth(font, textChars[i]);
        }
        return totalWidth <= w;
    }

    public boolean fitsHeight(int h, int font, FontInfo fontInfo) {
        return fontInfo.getHeight(font) <= h;
    }
}

//fonts contains all font sizes in ascending order
//can use getWidth and getHeight
//each font's height will not exceed the height of the following font
//each font's width will not exceed the width of the following font

//set answer to -1
//iterate backwards through the font array, checking if the height fits within
//the max height and if the width of all characters combined fits within the
// max width of the screen.