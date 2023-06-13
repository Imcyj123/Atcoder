package abc043;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C {
    static BufferedReader in;
    static int r, ret;
    static boolean negative = false;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = readInt();
        int min = Integer.MAX_VALUE;
        for (int i = -100; i <= 100; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += (i - a[j]) * (i - a[j]);
            }
            min = Math.min(min, sum);
        }
        System.out.println(min);
    }

    static int readInt() throws Exception {
        ret = 0;
        r = in.read();
        if (r == '-') {
            negative = true;
            r = in.read();
        }
        while (r > 47 && r < 58) {
            ret *= 10;
            ret += (r & 15);
            r = in.read();
        }
        if (negative) {
            negative = false;
            ret *= -1;
        }
        return ret;
    }
}