package abc044;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(in.readLine());
        long s = Long.parseLong(in.readLine());
        Solver sol = new Solver();
        System.out.println(sol.solve(n,s));
        System.out.close();
    }
}
class Solver {
    long solve(long n, long s) {
        long res;
        if (s > n) return -1;
        if (s == n) return n + 1;
        for (long b = 2; b * b <= n; b++) if (sum(b, n) == s) return b;
        for (long i = (long) Math.ceil(Math.sqrt(n) - 1); i >= 1; i--) {
            res = ((n - s) / i) + 1;
            if (res == 1) continue;
            if (res > 1 && sum(res, n) == s) return res;
        }
        return -1;
    }

    long sum(long b, long n) {
        long res = 0;
        while (n >= b) {
            res += n % b;
            n /= b;
        }
        return res + n;
    }
}