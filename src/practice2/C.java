package practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static long R, ret, N, M, A, B, sum;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            N = readLong();
            M = readLong();
            A = readLong();
            B = readLong();
            out.write(floorSum(N, M, A, B) + "\n");
        }
        out.flush();
    }

    static long floorSum(long n, long m, long a, long b) {
        long t = (a * (n - 1) + b) / m;
        if (t == 0) return 0;
        long p = m / a;
        long q = m % a;
        long s = (a - (b % a)) - 1;
        long r = (b + 1 + s) / a;
        return t * n + t * (r - 1) - p * t * (t + 1) / 2 - floorSum(t + 1, a, q, s);
    }

    static long readLong() throws Exception {
        ret = 0;
        R = in.read();
        while (R > 47 && R < 58) {
            ret *= 10;
            ret += (R & 15);
            R = in.read();
        }
        return ret;
    }
}