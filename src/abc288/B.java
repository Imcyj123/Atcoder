package abc288;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] nk = in.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] ss = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            ss[i] = in.readLine();
        }
        Arrays.sort(ss, 1, k + 1);
        for (int i = 1; i <= k; i++) {
            out.write(ss[i] + "\n");
        }
        out.flush();
    }
}