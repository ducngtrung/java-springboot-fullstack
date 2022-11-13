// Given two string arrays word1 and word2.
// Return true if the two arrays represent the same string, and false otherwise.

public class LeetCode_1662 {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "b", "c"};

        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";

        for (int i = 0; i < word1.length; ++i) {
            s1 = s1 + word1[i];
        }
        for (int i = 0; i < word2.length; ++i) {
            s2 = s2 + word2[i];
        }

        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }

        // // Cách 2:
        // StringBuilder sb1 = new StringBuilder();
        // StringBuilder sb2 = new StringBuilder();

        // for (String s : word1) {
        //     sb1.append(s);
        // }
        // for (String s : word2) {
        //     sb2.append(s);
        // }

        // boolean result = sb1.toString().equals(sb2.toString());
        // return result;
    }
}