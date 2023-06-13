package arc058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class E {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int x = readInt();
        int y = readInt();
        int z = readInt();

        int[][] dp = new int[41][1 << 18];
        int res = 1;

        int C = (1 << (x + y + z - 1)) | (1 << (y + z - 1)) | (1 << (z - 1));
        int ALL = (1 << (x + y + z)) - 1;

        dp[0][0] = 1;

        for (int i = 1; i <= n; ++i) {
            res = (int) ((long) res * 10 % MOD);
            for (int S = 0; S <= ALL; ++S) {
                int k = dp[i - 1][S];
                if (k != 0 && (S & C) != C) {
                    for (int w = 1; w <= 10; ++w) {
                        dp[i][(S << w | (1 << (w - 1))) & ALL] += k;
                        dp[i][(S << w | (1 << (w - 1))) & ALL] %= MOD;
                    }
                }
            }
        }

        for (int S = 0; S <= ALL; ++S) {
            if ((S & C) != C) {
                res -= dp[n][S];
                res = (res + MOD) % MOD;
            }
        }
        out.write(res + "\n");
        out.flush();
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