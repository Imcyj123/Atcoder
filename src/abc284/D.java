package abc284;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static long r, ret;

    public static void main(String[] args) throws Exception {
        long T = readInt();
        while (T-- > 0) {
            long N = readInt();
            long cuberoot = (long) Math.cbrt(N);
            long p = 0, q = 0;
            for (int i = 2; i <= cuberoot; i++) {
                if (N % i == 0) {
                    N /= i;
                    if (N % i == 0) {
                        p = i;
                        q = N / i;
                    } else {
                        q = i;
                        p = (long) Math.sqrt(N);
                    }
                }
            }
            out.write(p + " " + q + "\n");
        }
        out.flush();
    }

    static long readInt() throws Exception {
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