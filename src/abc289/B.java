package abc289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int n = readInt();
        int m = readInt();
        boolean[] bool = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int idx = readInt();
            bool[idx] = true;
        }
        int l = 1, r = 1;
        while (l <= n) {
            while (r < n && bool[r]) r++;
            for (int i = r; i >= l; i--) out.write(i + " ");
            l = ++r;
        }
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