import java.util.*;
/**
 * OccurenceAnagram
 * 
 * Problem :
 * for given s string and patter string where you have return count of occurence of
 * angram pattern in s.
 */
public class OccurenceAnagram {

    public static boolean isAnagram(String window, String pattern) {
        HashMap<Character, Integer> mapWindow = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapPattern = new HashMap<Character, Integer>();

        for (int i = 0; i < window.length(); i++) {
            mapWindow.put(window.charAt(i), mapWindow.getOrDefault(window.charAt(i), 0)+1);
        }
        for (int i = 0; i < pattern.length(); i++) {
            mapPattern.put(pattern.charAt(i), mapPattern.getOrDefault(pattern.charAt(i), 0)+1);
        }

        if (mapPattern.size() == mapWindow.size() && mapWindow.equals(mapPattern)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "forxxofrxxfroxoxorxxxxfor";
        String pattern = "for";

        int j = 0, i = 0, count = 0;

        while (j < s.length()) {
            if (j - i + 1 < pattern.length()) {
                j++;
            } else if (j - i + 1 == pattern.length()) {
                String window = "";
                window = s.substring(i, j+1);
                
                if (isAnagram(window, pattern)) {
                    count++;
                }
                i++;
                j++;
            }
        }

        System.out.println(count);
    }
}