package arc154;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(in.readLine());
        char[] s = in.readLine().toCharArray();
        char[] t = in.readLine().toCharArray();
        int[] ss = new int[26];
        int[] tt = new int[26];
        in.close();
        for (int i = 0; i < N; i++) {
            ss[s[i] - 'a']++;
            tt[t[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ss[i] != tt[i]) {
                System.out.println("-1");
                return;
            }
        }
        int x = N - 1;
        for (int i = x; i >= 0; i--) {
            while (x >= 0 && s[i] != t[x]) {
                x--;
            }
            if (x >= 0 && s[i] == t[x]) {
                x--;
            } else {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("0");
    }
}