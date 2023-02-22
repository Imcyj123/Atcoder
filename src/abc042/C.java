package abc042;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int r, ret;

    public static void main(String[] args) throws Exception {
        int N = readInt();
        int K = readInt();
        boolean[] dislike = new boolean[10];
        for (int i = 0; i < K; i++) {
            dislike[readInt()] = true;
        }
        for (int i = N; i < 10 * N; i++) {
            int n = i;
            boolean hate = false;
            while (n > 0) {
                int digit = n % 10;
                if (dislike[digit]) {
                    hate = true;
                    break;
                }
                n /= 10;
            }
            if (!hate) {
                System.out.println(i);
                break;
            }
        }
    }

    static int readInt() throws Exception {
        ret = 0;
        r = in.read();
        while (r > 47 && r < 58) {
            ret *= 10;
            ret += (r & 15);
            r = in.read();
        }
        return ret;
    }
}