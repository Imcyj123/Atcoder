package abc042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class D {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static int mod = 1000000007;
    static long[] fac = new long[200010];
    static long[] inv = new long[200010];

    public static void main(String[] args) throws Exception {
        String[] split = in.readLine().split(" ");
        int h = Integer.parseInt(split[0]);
        int w = Integer.parseInt(split[1]);
        int a = Integer.parseInt(split[2]);
        int b = Integer.parseInt(split[3]);
        init();
        long ans = 0;
        for (int i = b + 1; i <= w; i++) {
            ans = (ans + C(h - a + i - 2, i - 1) * C(a + w - i - 1, a - 1) % mod) % mod;
        }
        System.out.println(ans);
    }

    static void init() {
        fac[0] = 1;
        for (int i = 1; i <= 200000; i++) {
            fac[i] = fac[i - 1] * i % mod;
        }
        inv[200000] = fpow(fac[200000], mod - 2);
        for (int i = 200000 - 1; i >= 0; i--) {
            inv[i] = inv[i + 1] * (i + 1) % mod;
        }
    }

    static long fpow(long x, long y) {
        long ret = 1;
        while (y != 0) {
            if ((y & 1) == 1)
                ret = ret * x % mod;
            x = x * x % mod;
            y >>= 1;
        }
        return ret;
    }

    static long C(int x, int y) {
        return fac[x] * inv[y] % mod * inv[x - y] % mod;
    }
}