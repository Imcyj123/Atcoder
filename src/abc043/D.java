package abc043;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String str = in.readLine();
        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                System.out.println((i + 1) + " " + (i + 2));
                return;
            }
            if (i + 2 < len) {
                if (str.charAt(i) == str.charAt(i + 2)) {
                    System.out.println((i + 1) + " " + (i + 3));
                    return;
                }
            }
        }
        System.out.println("-1 -1");
    }
}