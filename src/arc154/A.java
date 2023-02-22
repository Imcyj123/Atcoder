package arc154;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    final static Long MOD = 998244353l;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(in.readLine());
        char[] a = in.readLine().toCharArray();
        char[] b = in.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (a[i] > b[i]) {
                char t = a[i];
                a[i] = b[i];
                b[i] = t;
            }
        }
        Long aa = 0l, bb = 0l;
        for (int i = 0; i < N; i++) {
            aa *= 10;
            bb *= 10;
            aa += a[i] - '0';
            bb += b[i] - '0';
            aa %= MOD;
            bb %= MOD;
        }
        out.write(aa * bb % MOD + "\n");
        out.flush();
    }
}