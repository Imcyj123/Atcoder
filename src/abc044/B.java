package abc044;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int[] freq = new int[26];
        for (char c : in.readLine().toCharArray()) {
            freq[c-'a']++;
        }
        System.out.println(beautiful(freq) ? "Yes" : "No");
    }

    static boolean beautiful(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) return false;
        }
        return true;
    }
}